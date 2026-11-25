package com.wealth.common.utils.generic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.wealth.common.assembler.GenericAssembler;
import com.wealth.common.client.CustomersServiceFeignClient;
import com.wealth.common.client.NexusServiceFeignClient;
import com.wealth.common.constants.CommonConstants;
import com.wealth.common.generic.ApiResponse;
import com.wealth.common.generic.EnumData;
import com.wealth.common.logger.GrowxLogger;
import com.wealth.common.model.dto.ThreadLocalDto;
import com.wealth.common.model.dto.UserPermissionDTO;
import com.wealth.common.model.dto.customer.CompanyUserDTO;
import com.wealth.common.model.dto.customer.GxsysApplicationConfigDTO;
import com.wealth.common.model.entity.GxsysApplicationConfig;

import jakarta.annotation.PostConstruct;

@Component
public class RequestHeaderUtil {
	private static GenericAssembler genericAssembler;

	private static final GrowxLogger LOGGER = new GrowxLogger(RequestHeaderUtil.class);
	public static NexusServiceFeignClient redisFeignClient;
	private static CustomersServiceFeignClient customerClient;
	@Value("${spring.redis.enabled}")
	private Boolean isRedis;
	public NexusServiceFeignClient client;

	public RequestHeaderUtil(NexusServiceFeignClient client, GenericAssembler genericAssembler,
			CustomersServiceFeignClient customersServiceFeignClient) {
		this.client = client;
		RequestHeaderUtil.genericAssembler = genericAssembler;
		RequestHeaderUtil.customerClient = customersServiceFeignClient;
	}

	@PostConstruct
	public void init() {
		if (isRedis) {
			redisFeignClient = client;
		}
	}

	private static final ThreadLocal<String> userCodeThreadLocal = new ThreadLocal<String>();
	private static final ThreadLocal<String> countryCode2ThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<Integer> useridThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<Integer> groupSmeCompIdThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<Integer> smeCompIdThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> userTypeThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> IpThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> loginPortalThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> emailIdThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> channelTypeThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> jwtTokenThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> permissionIdThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> scopeThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> menuIdThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> appIdThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<GxsysApplicationConfigDTO> appConfigThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> preferredLanguageThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> localeCodeThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> smeUserSupportCountriesThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> userCodeHeaderThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> schemaThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> traceIdThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> correlationIdThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<String> spanIdThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<Boolean> publicEndpointThreadLocal = ThreadLocal.withInitial(() -> Boolean.FALSE);
	private static final ThreadLocal<Boolean> headerCacheHydratedThreadLocal = ThreadLocal
			.withInitial(() -> Boolean.FALSE);


	private static String generateRedisKey(String propertyName) {
		return "thread2_" + propertyName + "_" + userCodeHeaderThreadLocal.get();
	}

	private static void setProperty(ThreadLocal<String> threadLocal, String propertyName, String value) {
		if (value != null) {
			threadLocal.set(value);
		}
	}

	/**
	 * Loads the Nexus header cache at most once per thread. The hydrated flag is
	 * set BEFORE the Feign call so a nested read raised from inside a Feign
	 * request interceptor short circuits instead of re-entering this method.
	 */
	private static void hydrateHeaderCacheOnce() {
		if (Boolean.TRUE.equals(headerCacheHydratedThreadLocal.get())) {
			return;
		}
		headerCacheHydratedThreadLocal.set(Boolean.TRUE);
		try {
			getNexusRequestHeaderCache();
		} catch (Exception e) {
			LOGGER.warn("Header cache hydration failed, continuing without cached headers. Reason="
					+ e.getMessage());
		}
	}

	private static String getProperty(ThreadLocal<String> threadLocal, String propertyName) {
		String val = threadLocal.get();
		if (val != null) {
			return val;
		}
		hydrateHeaderCacheOnce();
		return threadLocal.get();
	}

	private static void setIntProperty(ThreadLocal<Integer> threadLocal, String propertyName, Integer value) {
		if (value != null) {
			threadLocal.set(value);
		}
	}

	private static int getIntProperty(ThreadLocal<Integer> threadLocal, String propertyName) {
		Integer val = threadLocal.get();
		if (val != null) {
			return val;
		}
		hydrateHeaderCacheOnce();
		Integer hydratedVal = threadLocal.get();
		return hydratedVal != null ? hydratedVal : 0;
	}

	// ------------------------------------------------------------------------
	// PUBLIC API (Refactored to use generic helpers)
	// ------------------------------------------------------------------------

	public static void setXUserCode(String x_user_code) {
		if (x_user_code != null)
			userCodeHeaderThreadLocal.set(x_user_code);
	}

	public static void setUserCode(String userCode) {
		setProperty(userCodeThreadLocal, "userCode", userCode);
	}


	public static boolean isPublic() {
	    return Boolean.TRUE.equals(publicEndpointThreadLocal.get());
	}

	public static void setPublic(boolean isPublic) {
	    publicEndpointThreadLocal.set(isPublic);
	}

	public static String getUserCode() {
		return getProperty(userCodeThreadLocal, "userCode");
	}
	public static void setTraceId(String traceId) {
		setProperty(traceIdThreadLocal, "traceId", traceId);
	}
	public static String getTraceId() {
		return traceIdThreadLocal.get();
	}
	public static void setCorrelationId(String traceId) {
		setProperty(correlationIdThreadLocal, "CorrelationId", traceId);
	}
	public static String getCorrelationId() {
		return correlationIdThreadLocal.get();
	}

	public static void setSpanId(String spanId) {
		setProperty(spanIdThreadLocal, "spanId", spanId);
	}

	public static String getSpanId() {
		return spanIdThreadLocal.get();
	}
	
	public static void setUserId(int userId) {
		setIntProperty(useridThreadLocal, "userId", userId);
	}

	public static int getUserId() {
		return getIntProperty(useridThreadLocal, "userId");
	}

	public static void setIp(String ip) {
		setProperty(IpThreadLocal, "Ip", ip);
	}

	public static String getIp() {
		return getProperty(IpThreadLocal, "Ip");
	}

	public static void setSmeUserSupportCountriesThreadLocal(String supportCountries) {
		setProperty(smeUserSupportCountriesThreadLocal, "smeUserSupportCountries", supportCountries);
	}

	public static String getSmeUserSupportCountriesThreadLocal() {
		return getProperty(smeUserSupportCountriesThreadLocal, "smeUserSupportCountries");
	}

	public static void setCountryCode2(String countryCode) {
		setProperty(countryCode2ThreadLocal, "countryCode2", countryCode);
	}

	public static String getCountryCode2() {
		return getProperty(countryCode2ThreadLocal, "countryCode2");
	}

	public static void setSmeCompId(Integer smeCompId) {
		setIntProperty(smeCompIdThreadLocal, "smeCompId", smeCompId);
	}

//	public static int getSmeCompId() {
//		return getIntProperty(smeCompIdThreadLocal, "smeCompId");
//	}

	public static void setGroupSmeCompId(Integer groupSmeCompId) {
		setIntProperty(groupSmeCompIdThreadLocal, "groupSmeCompId", groupSmeCompId);
	}

	public static int getGroupSmeCompId() {
		return getIntProperty(groupSmeCompIdThreadLocal, "groupSmeCompId");
	}

	public static void setScope(String scope) {
		setProperty(scopeThreadLocal, "scope", scope);
	}

	public static String getScope() {
		return getProperty(scopeThreadLocal, "scope");
	}

	public static void setUserType(String userType) {
		setProperty(userTypeThreadLocal, "userType", userType);
	}

	public static String getUserType() {
		return getProperty(userTypeThreadLocal, "userType");
	}

	public static void setLoginPortal(String loginPortal) {
		setProperty(loginPortalThreadLocal, "loginPortal", loginPortal);
	}

	public static String getLoginPortal() {
		return getProperty(loginPortalThreadLocal, "loginPortal");
	}

	public static void setEmailId(String emailId) {
		setProperty(emailIdThreadLocal, "emailId", emailId);
	}

	public static String getEmailId() {
		return getProperty(emailIdThreadLocal, "emailId");
	}

	public static void setChannelType(String channelType) {
		setProperty(channelTypeThreadLocal, "channelType", channelType);
	}

	public static String getChannelType() {
		return getProperty(channelTypeThreadLocal, "channelType");
	}

	public static void setjwt(String jwt) {
		if (jwt != null) {
			jwtTokenThreadLocal.set(jwt);
//			if (redisFeignClient != null) {
//				redisFeignClient.setCacheData("tl_jwtToken_" + jwt, jwt, userCodeHeaderThreadLocal.get());
//			}
		}
	}

	public static String getjwt() {
		return jwtTokenThreadLocal.get();
	}

	public static void setMenu(String menu) {
		setProperty(menuIdThreadLocal, "menuId", menu);
	}

	public static int getMenu() {
		String val = getProperty(menuIdThreadLocal, "menuId");
		return val != null ? Integer.parseInt(val) : 0;
	}

	public static void setPermission(String permission) {
		setProperty(permissionIdThreadLocal, "permissionId", permission);
	}

	public static int getPermission() {
		String val = getProperty(permissionIdThreadLocal, "permissionId");
		return val != null ? Integer.parseInt(val) : 0;
	}

	public static void setAppId(String appId) {
		setProperty(appIdThreadLocal, "appId", appId);
	}

	public static String getAppId() {
		return getProperty(appIdThreadLocal, "appId");
	}

	public static void setPreferredLanguage(String preferredLanguage) {
		setProperty(preferredLanguageThreadLocal, "preferredLanguage", preferredLanguage);
	}

	public static String getPreferredLanguage() {
		return getProperty(preferredLanguageThreadLocal, "preferredLanguage");
	}

	public static void setSchemaName(String SchemaName) {
		setProperty(schemaThreadLocal, "SchemaName", SchemaName);
	}

	public static String getSchemaName() {
		return getProperty(schemaThreadLocal, "SchemaName");
	}

	public static void setLocaleCode(String localeCode) {
		setProperty(localeCodeThreadLocal, "localeCode", localeCode);
	}

	public static String getLocaleCode() {
		return getProperty(localeCodeThreadLocal, "localeCode");
	}

	public static void setAppConfig(GxsysApplicationConfig appConfig) {
		if (appConfig != null) {
			appConfigThreadLocal.set(genericAssembler.toDTO(appConfig, GxsysApplicationConfigDTO.class));
			LOGGER.info(generateRedisKey("appConfig"));
			LOGGER.info(userCodeHeaderThreadLocal.get());
			LOGGER.info(Helper.toJson(appConfig));
			redisFeignClient.setCacheData(generateRedisKey("appConfig"), Helper.toJson(appConfig),
					userCodeHeaderThreadLocal.get(), appIdThreadLocal.get());
		}

	}

	
	public static void setOpenapiAppConfig(GxsysApplicationConfigDTO appconfig) {
		if (appconfig != null) {
			appConfigThreadLocal.set(genericAssembler.toDTO(appconfig, GxsysApplicationConfigDTO.class));
		}
	}

	


	public static GxsysApplicationConfigDTO getAppConfig() {
		GxsysApplicationConfigDTO appconfig = appConfigThreadLocal.get();
		if (appconfig != null ) {
			if ( !getScope().equals(EnumData.SCOPE_OPENAPI)) {
				setSchemaName(appconfig.getSchemaName());	
			}
			return appconfig;
		}
		String config = redisFeignClient != null
				? redisFeignClient.getCacheData(generateRedisKey("appConfig"), userCodeHeaderThreadLocal.get(),
						appIdThreadLocal.get())
				: null;
		GxsysApplicationConfigDTO GxsysApplicationConfig = Helper.fromJson(config, GxsysApplicationConfigDTO.class);
//		setSchemaName(GxsysApplicationConfig.getSchemaName());
		return GxsysApplicationConfig;
	}

	public static void clear() {
	    userCodeThreadLocal.remove();
	    countryCode2ThreadLocal.remove();
	    useridThreadLocal.remove();
	    groupSmeCompIdThreadLocal.remove();
	    smeCompIdThreadLocal.remove();
	    userTypeThreadLocal.remove();
	    IpThreadLocal.remove();
	    loginPortalThreadLocal.remove();
	    emailIdThreadLocal.remove();
	    channelTypeThreadLocal.remove();
	    jwtTokenThreadLocal.remove();
	    permissionIdThreadLocal.remove();
	    menuIdThreadLocal.remove();
	    appIdThreadLocal.remove();
	    preferredLanguageThreadLocal.remove();
	    localeCodeThreadLocal.remove();
	    scopeThreadLocal.remove();
	    smeUserSupportCountriesThreadLocal.remove();
	    appConfigThreadLocal.remove();
	    userCodeHeaderThreadLocal.remove();
	    schemaThreadLocal.remove();
	    traceIdThreadLocal.remove();
	    correlationIdThreadLocal.remove();
	    spanIdThreadLocal.remove();
	    publicEndpointThreadLocal.remove(); // ✅ Added missing clear
	    headerCacheHydratedThreadLocal.remove();
	    childClear();
	}

	public static void setNexusRequestHeaderCache() {
		ThreadLocalDto headerCacheObj = new ThreadLocalDto();
		headerCacheObj.setUserCode(userCodeHeaderThreadLocal.get());
		headerCacheObj.setCountryCode2(countryCode2ThreadLocal.get());
		headerCacheObj.setUserId(useridThreadLocal.get());
		headerCacheObj.setSmeCompId(smeCompIdThreadLocal.get());
		headerCacheObj.setGroupSmeCompId(groupSmeCompIdThreadLocal.get());
		headerCacheObj.setUserType(userTypeThreadLocal.get());
		headerCacheObj.setIp(IpThreadLocal.get());
		headerCacheObj.setLoginPortal(loginPortalThreadLocal.get());
		headerCacheObj.setEmailId(emailIdThreadLocal.get());
		headerCacheObj.setChannelType(channelTypeThreadLocal.get());
		headerCacheObj.setJwtToken(jwtTokenThreadLocal.get());
		headerCacheObj.setPermissionId(permissionIdThreadLocal.get());
		headerCacheObj.setScope(scopeThreadLocal.get());
		headerCacheObj.setMenuId(menuIdThreadLocal.get());
		headerCacheObj.setAppId(appIdThreadLocal.get());
		headerCacheObj.setSchema(schemaThreadLocal.get());
		headerCacheObj.setPreferredLanguage(preferredLanguageThreadLocal.get());
		headerCacheObj.setLocaleCode(localeCodeThreadLocal.get());
		headerCacheObj.setSmeUserSupportCountries(smeUserSupportCountriesThreadLocal.get());
//		LOGGER.info(Helper.toJson(headerCacheObj));
		if (redisFeignClient != null) {
			// Read the thread locals directly. Going through getUserCode()/getAppId()
			// would let a write trigger a cache load.
			redisFeignClient.setCacheData(generateRedisKey("ThreadLocalDto"), Helper.toJson(headerCacheObj),
					userCodeThreadLocal.get(), appIdThreadLocal.get());
		}
		// Thread locals are authoritative after a write, so do not re-fetch and
		// overwrite them later in this request.
		headerCacheHydratedThreadLocal.set(Boolean.TRUE);
	}

	

	public static ThreadLocalDto getNexusRequestHeaderCache() {
		LOGGER.info("getNexusRequestHeaderCache start");
		String redisData = redisFeignClient.getCacheData(generateRedisKey("ThreadLocalDto"),
				userCodeHeaderThreadLocal.get(), appIdThreadLocal.get());
		if (redisData == null) {
			return null;
		}
		ThreadLocalDto headerCacheObj = Helper.fromJson(redisData, ThreadLocalDto.class);
		setAppId(headerCacheObj.getAppId());
		setUserId(headerCacheObj.getUserId() != 0 ? headerCacheObj.getUserId() : 0);
		setUserCode(headerCacheObj.getUserCode());
		setChannelType(headerCacheObj.getChannelType());
		setCountryCode2(headerCacheObj.getCountryCode2());
		setEmailId(headerCacheObj.getEmailId());
		setIp(headerCacheObj.getIp());
		setjwt(headerCacheObj.getJwtToken());
		setLocaleCode(headerCacheObj.getLocaleCode());
		setMenu(headerCacheObj.getMenuId());
		setLoginPortal(headerCacheObj.getLoginPortal());
		setPermission(headerCacheObj.getPermissionId());
		setPreferredLanguage(headerCacheObj.getPreferredLanguage());
		LOGGER.info("getNexusRequestHeaderCache in middle");
		setScope(headerCacheObj.getScope());
		setSmeCompId(headerCacheObj.getSmeCompId());
		setGroupSmeCompId(headerCacheObj.getGroupSmeCompId());
		setSmeUserSupportCountriesThreadLocal(headerCacheObj.getSmeUserSupportCountries());
		setUserType(headerCacheObj.getUserType());
		getAppConfig();
//		LOGGER.info(Helper.toJson(headerCacheObj));
		LOGGER.info("getNexusRequestHeaderCache end");
		return headerCacheObj;
	}

	public static void childClear() {
		userCodeThreadLocal.remove();

	}

	public static UserPermissionDTO getPermissionListByUser(UserPermissionDTO requestUserPermissionDTO) {
		ResponseEntity<ApiResponse<UserPermissionDTO, Void>> responseUserPermissionDTO = customerClient
				.getPermissionListByUser(requestUserPermissionDTO, "web", getUserCode());

		if (responseUserPermissionDTO.getBody() != null
				&& responseUserPermissionDTO.getStatusCode().isSameCodeAs(HttpStatusCode.valueOf(200))) {
			UserPermissionDTO UserPermissionDTOObj = responseUserPermissionDTO.getBody().getData();
			return UserPermissionDTOObj;
		}
		return null;

	}
	
	public static void setNexusRequestHeaderOpenapiCache() {
		ThreadLocalDto headerCacheObj = new ThreadLocalDto();
		headerCacheObj.setUserCode(userCodeThreadLocal.get());
		headerCacheObj.setIp(IpThreadLocal.get());
		headerCacheObj.setJwtToken(jwtTokenThreadLocal.get());
		headerCacheObj.setScope(scopeThreadLocal.get());
		headerCacheObj.setAppId(appIdThreadLocal.get());
		headerCacheObj.setSchema(schemaThreadLocal.get());
		headerCacheObj.setGroupSmeCompId(groupSmeCompIdThreadLocal.get());
		String userIdStr = getUserCode().replace(CommonConstants.USER_CODE_PREFIX, "");
    	int	userId = Integer.parseInt(userIdStr);
    	headerCacheObj.setUserId(userId);
		if (redisFeignClient != null) {
			redisFeignClient.setCacheData(generateRedisKey("ThreadOpenapiDto"), Helper.toJson(headerCacheObj),
					getUserCode(), getAppId());
		}
	}


	public static ThreadLocalDto getNexusRequestHeaderOpenapiCache() {
		LOGGER.info("getNexusRequestHeaderCache start");
		String redisData = redisFeignClient.getCacheData(generateRedisKey("ThreadOpenapiDto"),
				userCodeHeaderThreadLocal.get(), appIdThreadLocal.get());
		if (redisData == null) {
			return null;
		}
		ThreadLocalDto headerCacheObj = Helper.fromJson(redisData, ThreadLocalDto.class);
		setAppId(headerCacheObj.getAppId());
		setIp(headerCacheObj.getIp());
		setjwt(headerCacheObj.getJwtToken());
		setScope(headerCacheObj.getScope());
		setUserCode(headerCacheObj.getUserCode());
		setUserId(headerCacheObj.getUserId());
		setGroupSmeCompId(headerCacheObj.getGroupSmeCompId());
		setSchemaName(headerCacheObj.getSchema());
		LOGGER.info("getNexusRequestHeaderCache end");
		return headerCacheObj;
	}

	// remove 
	public static void removeNexusRequestHeaderCache() {
		LOGGER.info("removeNexusRequestHeaderCache start");
		if (redisFeignClient != null) {
			LOGGER.info("redisFeignClient is present");
			boolean removed = redisFeignClient.removeCacheData(generateRedisKey("ThreadLocalDto"),
					userCodeThreadLocal.get(), appIdThreadLocal.get());
			removeAppConfig();
			LOGGER.info("removeNexusRequestHeaderCache removed=" + removed);
		}
		headerCacheHydratedThreadLocal.set(Boolean.FALSE);
		LOGGER.info("removeNexusRequestHeaderCache end");
	}
	
	public static void removeNexusRequestHeaderOpenapiCache() {
		LOGGER.info("removeNexusRequestHeaderOpenapiCache start");
		if (redisFeignClient != null) {
			LOGGER.info("redisFeignClient is present");
			boolean removed = redisFeignClient.removeCacheData(generateRedisKey("ThreadOpenapiDto"), getUserCode(),
					getAppId());
			removeOpenapiAppConfig();
			LOGGER.info("removeNexusRequestHeaderOpenapiCache removed=" + removed);
		}
		LOGGER.info("removeNexusRequestHeaderOpenapiCache end");
	}
	
	public static void removeOpenapiAppConfig() {
		LOGGER.info("removeOpenapiAppConfig start");
		appConfigThreadLocal.remove();
		LOGGER.info("removeOpenapiAppConfig end");
	}
	
	public static void removeAppConfig() {
		LOGGER.info("removeAppConfig start");
		appConfigThreadLocal.remove();
		if (redisFeignClient != null) {
			boolean removed = redisFeignClient.removeCacheData(generateRedisKey("appConfig"),
					userCodeHeaderThreadLocal.get(), appIdThreadLocal.get());
			LOGGER.info("removeAppConfig removed=" + removed);
		}
		LOGGER.info("removeAppConfig end");
	}
	
	
	
}
