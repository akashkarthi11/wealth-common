package com.wealth.common.interceptor;

import org.slf4j.MDC;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.wealth.common.constants.SchemaConstants;
import com.wealth.common.dao.CommonRepository;
import com.wealth.common.generic.EnumData;
import com.wealth.common.logger.GrowxLogger;
import com.wealth.common.model.dto.ThreadLocalDto;
import com.wealth.common.model.dto.UserPermissionDTO;
import com.wealth.common.model.dto.customer.GxsysApplicationConfigDTO;
import com.wealth.common.model.entity.GxsysApplicationConfig;
import com.wealth.common.utils.generic.RequestHeaderUtil;
import com.wealth.common.utils.security.JwtTokenUtil;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class Interceptor implements HandlerInterceptor {

	private static final GrowxLogger LOGGER = new GrowxLogger(Interceptor.class);
	private static final Pattern VALID_SCHEMA_NAME = Pattern.compile("^[a-zA-Z_][a-zA-Z0-9_]{0,62}$");
	private static final Pattern API_BASE_PATH = Pattern.compile("^/growx/api/v\\d+(?=/|$)");
	private static final int App = 0;
	@Value("${default.schema}")
	private String defaultSchema;
	@Value("${default.isProd}")
	boolean prod ;
	
	
	private final JwtTokenUtil jwtUtils;
	private  CommonRepository repo;
	

	public Interceptor(JwtTokenUtil jwtUtils, CommonRepository repo) {
		this.jwtUtils = jwtUtils;
		this.repo = repo;
	}

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String traceId = request.getHeader("X-Trace-ID");
		String correlationId = request.getHeader("X-Correlation-ID");
		String scope = request.getHeader(EnumData.SCOPE);
		if (correlationId!=null) {
			 RequestHeaderUtil.setCorrelationId(correlationId);
		} 
		if (traceId==null) {
			  traceId = UUID.randomUUID().toString();
		}
		   long startTime = System.nanoTime();
	 
		String  spanId= UUID.randomUUID().toString();
	    request.setAttribute("TRACE_ID", traceId);
	    request.setAttribute("SPAN_ID", spanId);
	    
	    RequestHeaderUtil.setTraceId(traceId);
	    RequestHeaderUtil.setSpanId(spanId);

	    request.setAttribute("START_TIME", startTime);

	    MDC.put("traceId", traceId);
	    MDC.put("spanId", spanId);
	    LOGGER.info("[traceId= {}] [spanId= {}]API START -> {} {}",
	            traceId,
	            request.getMethod(),
	            request.getRequestURI());

		String uri = request.getRequestURI();
		LOGGER.info("Interceptor preHandle start. uri =" + uri + ", method =" + request.getMethod());

		
		String x_user_code = request.getHeader(EnumData.X_USER_CODE);
		
		RequestHeaderUtil.setIp(getClientIp(request));
		String appId = request.getHeader(EnumData.X_App_ID);
		
		if (isOpenapi(uri)) {
			LOGGER.info("OpenAPI endpoint detected.");
			return validateOpenApiRequest(request, response);
		}
		if (x_user_code != null && appId!=null  ) {
			LOGGER.info("Request x_user_code =" + x_user_code);
			RequestHeaderUtil.setXUserCode(x_user_code);
			RequestHeaderUtil.setAppId(appId);
			if (!uri.startsWith("/growx/api/v1/nexus")
			        && !EnumData.SCOPE_JOB.equals(scope)) {
				LOGGER.info("calling nexus fo cache data" + x_user_code);
				if (refreshCacheValidation(scope)) {
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					LOGGER.info("calling nexus fo cache data but SC_UNAUTHORIZED");
					return false;
				}
			}else {
				LOGGER.info(" nexus api");
			}
			
		}
		if (isPublicEndpoint(uri)||isPublicServiceEndpoint(uri)) {
			LOGGER.info("Public endpoint detected, skipping auth uri :" + uri);
			RequestHeaderUtil.setPublic(true);
			if (uri.startsWith("/growx/api/v1/idp")) {
				
				   String hostHeader = request.getHeader("Host");
			        String serverName = request.getServerName();
			        String forwarded = request.getHeader("Forwarded");
			        String forwardedHost = request.getHeader("X-Forwarded-Host");
//			        LOGGER.info("Host header: " + hostHeader + ", serverName: " + serverName + ", X-Forwarded-Host: " + forwardedHost);
			        LOGGER.info("X-Forwarded-Host: " + forwardedHost);
			        LOGGER.info("Forwarded: " + forwarded);
			        LOGGER.info("Host: " + hostHeader);
			        LOGGER.info("serverName: " + serverName);

			        String domainName = serverName;
				LOGGER.info("domainName  provided, " +domainName);
				String schemaName = SchemaConstants.getConstantNameByValue(domainName);
				if(schemaName == null) {
					String formattedDomain = domainName.replace('.', '_');
					schemaName = SchemaConstants.getValueByKey(formattedDomain);
					
					if(schemaName == null) {
						schemaName = defaultSchema;
					}
					
				} 
				RequestHeaderUtil.setSchemaName(schemaName);
				LOGGER.info("domainName  provided, using  schemaName :" + schemaName);
			}

			return true;
		}


		LOGGER.info("Checking scope =" + scope);
		if (scope != null) {
			LOGGER.info("Request scope =" + scope);
			RequestHeaderUtil.setScope(scope);
			if (EnumData.SCOPE_JOB.equals(scope)) {
				RequestHeaderUtil.setPublic(true);
				String tenantId = request.getHeader(EnumData.X_TENANT_ID);
				LOGGER.info("JOB scope detected, bypassing security checks with defaultSchema "+defaultSchema);
				RequestHeaderUtil.setSchemaName(defaultSchema);
				RequestHeaderUtil.setAppId(tenantId);
				return true;
			}else if (EnumData.SCOPE_OPENAPI.equals(scope)) {
				LOGGER.info("openApi enter");
				String userId = request.getHeader(EnumData.X_USER_ID);
				String groupSmeCompId = request.getHeader(EnumData.X_GROUP_SME_COMP_ID);
				String channelType = request.getHeader(EnumData.X_CHANNEL_TYPE);
				String routingType = request.getHeader(EnumData.X_ROUTING_TYPE);
				String countrycode2 = request.getHeader(EnumData.X_COUNTRY_CODE2);
				if (userId != null && !userId.isBlank()) {
					try {
						RequestHeaderUtil.setUserId(Integer.parseInt(userId.trim()));
						LOGGER.info("openApi userId =" + userId);
					} catch (NumberFormatException ex) {
						LOGGER.warn("Invalid userId header. uri =" + uri);
					}
				}

				if (groupSmeCompId != null && !groupSmeCompId.isBlank()) {
					try {
						RequestHeaderUtil.setGroupSmeCompId(Integer.parseInt(groupSmeCompId.trim()));
						LOGGER.info("openApi groupSmeCompId =" + groupSmeCompId);
					} catch (NumberFormatException ex) {
						LOGGER.warn("Invalid groupSmeCompId header. uri =" + uri);
					}
				}

				if (channelType != null && !channelType.isBlank()) {
					RequestHeaderUtil.setChannelType(channelType);
					LOGGER.info("openApi channelType =" + channelType);
				}
				if (countrycode2 != null && !countrycode2.isBlank()) {
					RequestHeaderUtil.setCountryCode2(countrycode2);
					LOGGER.info("openApi countrycode2 =" + channelType);
				}
				if (routingType != null && !routingType.isBlank()) {
				GxsysApplicationConfigDTO appconfig = RequestHeaderUtil.getAppConfig();
				if ((appconfig==null)) {
					appconfig=new GxsysApplicationConfigDTO();
				}
				appconfig.setRoutingTypeCode(routingType);
					RequestHeaderUtil.setOpenapiAppConfig(appconfig);
					LOGGER.info("openApi routingType =" + routingType);
				}
				 RequestHeaderUtil.setNexusRequestHeaderOpenapiCache();
				return true;
			}
			
		}else {
			scope = EnumData.DEFAULT_SCOPE;
			RequestHeaderUtil.setScope(scope);
		    LOGGER.info("scope not provided, using default scope :" + scope);
		}
		if (!isServiceEndpoint(uri)) {
		
			String authorization = request.getHeader(EnumData.AUTHORIZATION);
			if (authorization == null || authorization.isBlank()) {
				LOGGER.warn("Missing Authorization header. uri =" + uri);
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return false;
			}

			if (!authorization.startsWith(EnumData.BEARER_PREFIX)) {
				LOGGER.warn("Invalid Authorization format. uri =" + uri);
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return false;
			}
			String token = authorization.substring(EnumData.BEARER_PREFIX.length());
			if (!jwtUtils.validateJwtToken(token)) {
				LOGGER.warn("JWT validation failed. uri =" + uri);
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return false;
			}
			Claims claims = JwtTokenUtil.getClaimsFromToken(token);
			if (claims == null) {
				LOGGER.warn("JWT claims extraction failed");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return false;
			}

			LOGGER.info("JWT validated successfully");
			
			String userCode = claims.getSubject();
			if (x_user_code != null) {
				LOGGER.info("Request x_user_code =" + x_user_code);
				RequestHeaderUtil.setXUserCode(x_user_code);
			}
			if (userCode == null || userCode.isBlank()) {
				LOGGER.warn("JWT subject claim missing or empty. uri =" + uri);
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return false;
			}
			RequestHeaderUtil.setXUserCode(userCode);
			
			RequestHeaderUtil.setUserCode(userCode);
			String tenantId = claims.get(EnumData.TENANT_ID, String.class);
			RequestHeaderUtil.setAppId(tenantId);
			String type = claims.get(EnumData.TOKEN_TYPE, String.class);
			if (refreshCacheValidation(scope)) {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return false;
			}
			// VAPT #2 (M22): a LONG token must match the active session in every environment, not only prod
			if (EnumData.TOKEN_TYPE_LONG.equals(type) && !token.equals(RequestHeaderUtil.getjwt())) {
				LOGGER.warn("Token does not match active session. uri =" + uri);
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return false;
			}
			LOGGER.info("Interceptor preHandle success. userCode =" + userCode);
//			RequestHeaderUtil.setjwt(token);
			String menu = request.getHeader(EnumData.MENU);
			String permission = request.getHeader(EnumData.PERMISSION);
			String portal = request.getHeader(EnumData.PORTAL);

			RequestHeaderUtil.setLoginPortal(portal);
			RequestHeaderUtil.setMenu(menu);
			RequestHeaderUtil.setPermission(permission);
	
	
			LOGGER.info("Authenticated userCode =" + userCode + ", tokenType =" + type);
			LOGGER.info("LONG token detected, validating permissions");
			 UserPermissionDTO requestUserPermissionDTO=new UserPermissionDTO();
			 String resourceUrl = toResourceUrl(uri);
			 requestUserPermissionDTO.setUri(resourceUrl);
			 requestUserPermissionDTO.setUserCode(userCode);
				LOGGER.info("checking permission by uri=" + uri + ", resourceUrl=" + resourceUrl);
	        UserPermissionDTO permissionUrlObj = RequestHeaderUtil.getPermissionListByUser(requestUserPermissionDTO);
	        if (permissionUrlObj!=null) {
	        	LOGGER.info(" permission id for uri  =" + permissionUrlObj.getPermissionId());
	        	if (prod&&permissionUrlObj.getPermissionId()==0) {
	        		LOGGER.warn("Permission denied for uri=" + uri);
					response.setStatus(HttpServletResponse.SC_FORBIDDEN);
					return false;
				}
	        	
			}
			RequestHeaderUtil.setNexusRequestHeaderCache();
			if (type.equals(EnumData.TOKEN_TYPE_SHORT)) {
				RequestHeaderUtil.setjwt(token);
			}
		}
		return true;
	}

	
	@Override
	public void afterCompletion(HttpServletRequest request,
	        HttpServletResponse response,
	        Object handler,
	        Exception ex) {

	  
	        String traceId =
	                (String) request.getAttribute("TRACE_ID");
	        String spanId =
	                (String) request.getAttribute("SPAN_ID");

	        Long startTime = (Long) request.getAttribute("START_TIME");

	        if (startTime != null) {
	            double durationSec =
	                    (System.nanoTime() - startTime) / 1_000_000_000.0;

	            LOGGER.info("[trace id={}] [span id={}] API END -> {} {} | Status={} | Time={} sec",
	                    traceId,spanId,
	                    request.getMethod(),
	                    request.getRequestURI(),
	                    response.getStatus(),
	                    String.format("%.3f", durationSec));
	        }

	        MDC.remove("traceId");
	        MDC.remove("spanId");
	        RequestHeaderUtil.clear();

	        LOGGER.info("Request context cleared");
	    }
	

	/* ================= helpers ================= */

	private String toResourceUrl(String uri) {
		if (uri == null) {
			return null;
		}
		Matcher matcher = API_BASE_PATH.matcher(uri);
		if (!matcher.find()) {
			return uri;
		}
		String resourceUrl = uri.substring(matcher.end());
		return resourceUrl.isEmpty() ? "/" : resourceUrl;
	}

	private boolean isPublicEndpoint(String uri) {
		LOGGER.info("isPublicEndpoint check for uri=" + uri);
		return uri.startsWith("/css/")
			        || uri.startsWith("/js/")
			        || uri.startsWith("/growxCss/")
			        || uri.startsWith("/santanderCss/")
			        || uri.startsWith("/mybankCss/")
			        || uri.startsWith("/fonts/")
			        || uri.startsWith("/assets/")
			        || uri.startsWith("/growx/api/v1/nexus")
			        || uri.startsWith("/api/redis")
			        || uri.startsWith("/images/")
			        || uri.startsWith("/ai/query")
			        || uri.startsWith("/actuator")
			        || uri.equals("/favicon.ico")
			        || uri.startsWith("/swagger-ui") 
			        || uri.startsWith("/combined-api.html") 
			        || uri.startsWith("/v3/api-docs")
					|| uri.startsWith("/swagger-resources") 
					|| uri.startsWith("/webjars")
					|| uri.startsWith("/growx/api/v1/auth/") 
					|| uri.startsWith("/auth/") 
					|| uri.startsWith("/mail")
					|| uri.startsWith("/callback") 
					|| uri.startsWith("/hackathon") 
					|| uri.startsWith("/client")
					|| uri.startsWith("/webhook") 
//					|| uri.startsWith("/growx/api/v1/rtp-request/getRtpByRedirectUrl")
					
					|| uri.startsWith("/growx/api/v1/central-bank")
					|| uri.contentEquals("/growx/api/v1/consents/cbs/redirect-url")
					
					|| uri.startsWith("/growx/api/v1/direct-bank")
					|| uri.startsWith("/api/v1/cb")
					|| uri.startsWith("/growx/api/v1/mock-bank")
					
					|| uri.equals("/error")
					|| uri.startsWith("/growx/api/v1/idp/auth/")
					|| uri.startsWith("/growx/api/v1/idp/oauth/")
					|| uri.startsWith("/api/v1/cb/getFilePaymentReport")
					|| uri.startsWith("/growx/api/v1/direct-bank")
					|| uri.startsWith("/growx/api/v1/central-bank")
					
					/* RTP Webhook Call */
					|| uri.startsWith("/growx/api/v1/rtp/collections/webhook")
					
					|| uri.contentEquals("/growx/api/v1/consents/cbs/redirect-url")
					|| uri.contentEquals("/growx/api/v1/auth/idp/token")
					|| uri.contentEquals("/growx/api/v1/idp/post-auth/user/create")

					/* Notify APIs */
					|| uri.contentEquals("/growx/api/v1/notify/template/details")

		            /* CUSTOMERS APIs */
		            || uri.contentEquals("/growx/api/v1/customers/oauth/token")
		            || uri.contentEquals("/growx/api/v1/customers/oauth/token/introspect")
		            || uri.contentEquals("/growx/api/v1/customers/oauth/token/revoke")
		            || uri.contentEquals("/growx/api/v1/customers/oauth/admin/token")
		            || uri.contentEquals("/growx/api/v1/customers/sme/users/invite/verify")
		            || uri.contentEquals("/growx/api/v1/customers/sme/users/set-password")
		            || uri.contentEquals("/growx/api/v1/customers/sme/users/notify/preference")
		            || uri.contentEquals("/growx/api/v1/customers/sme/users/self/onboard/create")
		            || uri.contentEquals("/growx/api/v1/customers/sme/users/self/onboard/verify")
		            || uri.contentEquals("/growx/api/v1/customers/sme/users/self/onboard/kyc/verify")
		            || uri.contentEquals("/growx/api/v1/customers/sme/users/auth/google")
		            || uri.contentEquals("/growx/api/v1/customers/sme/users/secret-key")
		            || uri.contentEquals("/growx/api/v1/customers/post-auth/security-questions/list")
		            || uri.contentEquals("/growx/api/v1/customers/post-auth/users/security-questions/create")
		            || uri.contentEquals("/growx/api/v1/customers/post-auth/users/security-questions/verify")
		            || uri.contentEquals("/growx/api/v1/customers/users/validate")
		            || uri.contentEquals("/growx/api/v1/customers/users/portal/validate")
		            || uri.contentEquals("/growx/api/v1/customers/auth/devices/register")
		            || uri.contentEquals("/growx/api/v1/customers/mpin-attempt")
		            || uri.startsWith("/growx/api/v1/customers/sme/users/pre-auth")
		            || uri.startsWith("/growx/api/v1/customers/sme/pre-auth")
		            || uri.startsWith("/growx/api/v1/customers/pre-auth")
                    || uri.contentEquals("/growx/api/v1/customers/user-details");
		            /* CUSTOMERS APIs */
		
	}

	private boolean isServiceEndpoint(String uri) {
		LOGGER.info("isPublicServiceEndpoint check for uri=" + uri);
		return uri.startsWith("/growx/api/v1/accounts-service")
				|| uri.contentEquals("/growx/api/v1/consent-service/cbs")
				
				|| uri.contentEquals("/growx/api/v1/idp/post-auth/security-questions/list")
//				|| uri.contentEquals("/growx/api/v1/idp/post-auth/users/password/update")
				|| uri.contentEquals("/growx/api/v1/idp/post-auth/password-reset")
				
				|| uri.startsWith("/growx/api/v1/report-service") 
				|| uri.startsWith("/growx/api/v1/amazon") 
				|| uri.startsWith("/growx/api/v1/consent-service")
				|| uri.startsWith("/growx/api/v1/customers-service") 
				|| uri.startsWith("/growx/api/v1/payments-service")
				|| uri.startsWith("/growx/api/v1/collections-service") 
				|| uri.startsWith("/growx/api/v1/ai-service") 
				|| uri.equals("/error") 
				|| uri.startsWith("/growx/api/v1/notifications-service")
				|| uri.contentEquals("/growx/api/v1/idp/post-auth/users/create")
				|| uri.contentEquals("/growx/api/v1/idp/post-auth/user/create");
	}
	
	private boolean isPublicServiceEndpoint(String uri) {
		LOGGER.info("isPublicServiceEndpoint check for uri=" + uri);
		return uri.contentEquals("/growx/api/v1/consent-service/callback")
				|| uri.contentEquals("/growx/api/v1/central-bank/auth/redirect-url")
				|| uri.contentEquals("/growx/api/v1/consent-service/cbs/consentaccounts/create")
				|| uri.contentEquals("/growx/api/v1/consent-service/cbs/consent-accounts/move-to-history")
				|| uri.contentEquals("/growx/api/v1/payments-service/cbs/consent/service-initiation")
				|| uri.startsWith("/growx/api/v1/rtp/collections-service/webhook")
				|| uri.equals("/error")
				
				/* CUSTOMERS-SERVICE APIs */
				|| uri.contentEquals("/growx/api/v1/customers-service/oauth/token")
				|| uri.contentEquals("/growx/api/v1/customers-service/oauth/token/introspect")
				|| uri.contentEquals("/growx/api/v1/customers-service/oauth/token/revoke")
				|| uri.contentEquals("/growx/api/v1/customers-service/oauth/admin/token")
				|| uri.contentEquals("/growx/api/v1/customers-service/sme/users/invite/verify")
				|| uri.contentEquals("/growx/api/v1/customers-service/sme/users/set-password")
				|| uri.contentEquals("/growx/api/v1/customers-service/sme/users/notify/preference")
				|| uri.contentEquals("/growx/api/v1/customers-service/sme/users/self/onboard/create")
				|| uri.contentEquals("/growx/api/v1/customers-service/sme/users/self/onboard/verify")
//				|| uri.contentEquals("/growx/api/v1/customers-service/sme/users/self/onboard/kyc/verify")
				|| uri.contentEquals("/growx/api/v1/customers-service/sme/users/auth/google")
				|| uri.contentEquals("/growx/api/v1/customers-service/sme/users/secret-key")
				|| uri.contentEquals("/growx/api/v1/customers-service/post-auth/security-questions/list")
				|| uri.contentEquals("/growx/api/v1/customers-service/post-auth/users/security-questions/create")
				|| uri.contentEquals("/growx/api/v1/customers-service/post-auth/users/security-questions/verify")
				|| uri.contentEquals("/growx/api/v1/customers-service/users/validate")
				|| uri.contentEquals("/growx/api/v1/customers-service/users/portal/validate")
				|| uri.contentEquals("/growx/api/v1/customers-service/auth/devices/register")
				|| uri.contentEquals("/growx/api/v1/customers-service/mpin-attempt")
				|| uri.contentEquals("/growx/api/v1/customers-service/system/support/country/list")
//				|| uri.contentEquals("/growx/api/v1/customers-service/bank/features/routingtype")
				|| uri.contentEquals("/growx/api/v1/customers-service/sme/users/fcmtoken")
				|| uri.contentEquals("/growx/api/v1/customers-service/users/portal/validate")
		        || uri.contentEquals("/growx/api/v1/customers-service/user-details")
				|| uri.startsWith("/growx/api/v1/customers-service/sme/users/pre-auth")
				|| uri.startsWith("/growx/api/v1/customers-service/sme/pre-auth")
				|| uri.startsWith("/growx/api/v1/customers-service/pre-auth")
				/* CUSTOMERS-SERVICE APIs */
				
 
				|| uri.equals("/payment.html");
	}
	
//	public UserPermissionDTO getPermissionListByUser(String userCode, String uri) throws SQLException {
//		LOGGER.info("Entering getPermissionListByUser() for UserCode: " + userCode + " and URI: " + uri);
//
//		// 1. Try fetching by User Code
////		UserPermissionDTO dto = repo.getPermissionIdsByUserCode(userCode, uri);
////		if (dto != null) {
////			LOGGER.info("Permission found via getPermissionIdsByUserCode for UserCode: " + userCode);
////			return dto;
////		}
//
//		// 2. Try fetching by Company User Code
//		LOGGER.info("Permission not found via UserCode, attempting getPermissionIdsByCompanyUserCode");
//		UserPermissionDTO dto = repo.getPermissionIdsByCompanyUserCode(userCode, uri);
//		if (dto != null) {
//			LOGGER.info("Permission found via getPermissionIdsByCompanyUserCode for UserCode: " + userCode);
//			return dto;
//		}
//
//		// 3. Try fetching from User Register
//		LOGGER.info("Permission not found via CompanyUserCode, attempting getUserRegisterByUserCode");
//		dto = repo.getUserRegisterByUserCode(userCode);
//		if (dto != null) {
//			LOGGER.info("Permission found via getUserRegisterByUserCode for UserCode: " + userCode);
//			return dto;
//		}
//
//		// 4. Final Fallback - Throw Exception
//		LOGGER.error("Permission not found for UserCode: " + userCode + " after all repository checks.");
//		throw new GrowxException(BaseError.PERMISSION_NOT_FOUND);
//	}
//	public UserPermissionDTO getUserIdByUserCode(String userCode) {
//		UserPermissionDTO dto = repo.getUserIdsByUserCode(userCode);
//		if (dto == null)
//			throw new GrowxException(BaseError.USER_NOT_FOUND);
//		return dto;
//	}

	public static String getClientIp(HttpServletRequest request) {
		for (String header : EnumData.getIpHeaderCandidates()) {
			String value = request.getHeader(header);
			if (value != null && !value.isBlank()) {
				return value.split(",")[0].trim();
			}
		}
		return request.getRemoteAddr();
	}


	public static boolean isMobileRequest(HttpServletRequest request) {
		String ua = request.getHeader(EnumData.USER_AGENT);
		if (ua == null)
			return false;

		ua = ua.toLowerCase();
		return ua.contains(EnumData.UA_ANDROID) || ua.contains(EnumData.UA_IPHONE) || ua.contains(EnumData.UA_IPAD)
				|| ua.contains(EnumData.UA_MOBILE);
	}

	public String detectDevice(HttpServletRequest request) {
		return isMobileRequest(request) ? EnumData.CHANNEL_MOBILE : EnumData.CHANNEL_WEB;
	}
	
	public boolean refreshCacheValidation(String scope) {

		if (scope.equals(EnumData.SCOPE_OPENAPI)) {
			ThreadLocalDto cachedata=RequestHeaderUtil.getNexusRequestHeaderOpenapiCache();
			if (cachedata==null) {
				return true;
			}
			return false;
		}else {
			ThreadLocalDto cachedata=RequestHeaderUtil.getNexusRequestHeaderCache();
			if (cachedata==null) {
				return true;
			}
			return false;
		}
		
	}
	public boolean isOpenapi(String uri) {
		return 	uri.startsWith("/openapi/");
		}
	private boolean validateOpenApiRequest(HttpServletRequest request, HttpServletResponse response) {
	    String uri = request.getRequestURI();

	    String authorization = request.getHeader(EnumData.AUTHORIZATION);
	    if (authorization == null || authorization.isBlank()) {
	        LOGGER.warn("Missing Authorization header. uri =" + uri);
	        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        return false;
	    }

	    if (!authorization.startsWith(EnumData.BEARER_PREFIX)) {
	        LOGGER.warn("Invalid Authorization format. uri =" + uri);
	        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        return false;
	    }

	    String token = authorization.substring(EnumData.BEARER_PREFIX.length());
	    if (!jwtUtils.validateJwtToken(token)) {
	        LOGGER.warn("JWT validation failed. uri =" + uri);
	        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        return false;
	    }

	    Claims claims = JwtTokenUtil.getClaimsFromToken(token);
	    if (claims == null) {
	        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        return false;
	    }

	    String userCode = request.getParameter("smeUserCode");
	    if (userCode == null || userCode.isBlank()) {
	        LOGGER.warn("Missing userCode param. uri =" + uri);
	        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	        return false;
	    }

	    RequestHeaderUtil.setjwt(token);
	    RequestHeaderUtil.setScope("openapi");
	    RequestHeaderUtil.setUserCode(userCode);
	    RequestHeaderUtil.setXUserCode(userCode);
		String tenantId = claims.get(EnumData.TENANT_ID, String.class);
		RequestHeaderUtil.setAppId(tenantId);
		GxsysApplicationConfig schema=repo.getSchemaNameByAppId(tenantId);
		RequestHeaderUtil.setSchemaName(schema.getSchemaName());
	    String type = claims.get(EnumData.TOKEN_TYPE, String.class);
	    if (type != null) {
	        LOGGER.info("OpenAPI tokenType =" + type);
	    }
	    RequestHeaderUtil.setNexusRequestHeaderOpenapiCache();
	    return true;
	}

}