package com.wealth.common.interceptor;

import java.util.UUID;
import java.util.regex.Pattern;

import org.slf4j.MDC;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.wealth.common.client.NexusServiceClient;
import com.wealth.common.generic.EnumData;
import com.wealth.common.model.dto.ThreadLocalDto;
import com.wealth.common.logger.KarthiLogger;
import com.wealth.common.utils.generic.RequestHeaderUtil;
import com.wealth.common.utils.security.JwtTokenUtil;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// From growx-common-lib Interceptor: trace ids, public endpoints, Bearer JWT, then the Nexus cache check.
// Tenant, schema, openapi/job scope and URI permission checks are not part of Wealth.
@Component
public class Interceptor implements HandlerInterceptor {

	private static final KarthiLogger LOGGER = new KarthiLogger(Interceptor.class);
	private static final Pattern API_BASE_PATH = Pattern.compile("^/(?:wealth|wealth-service)/api/v\\d+(?=/|$)");

	private final JwtTokenUtil jwtUtils;
	private final ObjectProvider<NexusServiceClient> nexusServiceClient;

	public Interceptor(JwtTokenUtil jwtUtils, ObjectProvider<NexusServiceClient> nexusServiceClient) {
		this.jwtUtils = jwtUtils;
		this.nexusServiceClient = nexusServiceClient;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		String traceId = request.getHeader("X-Trace-ID");
		String correlationId = request.getHeader("X-Correlation-ID");
		if (correlationId != null) {
			RequestHeaderUtil.setCorrelationId(correlationId);
		}
		if (traceId == null) {
			traceId = UUID.randomUUID().toString();
		}
		String spanId = UUID.randomUUID().toString();
		request.setAttribute("TRACE_ID", traceId);
		request.setAttribute("SPAN_ID", spanId);
		request.setAttribute("START_TIME", System.nanoTime());
		RequestHeaderUtil.setTraceId(traceId);
		RequestHeaderUtil.setSpanId(spanId);
		RequestHeaderUtil.setIp(getClientIp(request));
		MDC.put("traceId", traceId);
		MDC.put("spanId", spanId);

		String uri = request.getRequestURI();
		LOGGER.info("[traceId=" + traceId + "] [spanId=" + spanId + "] API START -> " + request.getMethod() + " " + uri);

		if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
			return true;
		}
		if (isPublicEndpoint(uri)) {
			RequestHeaderUtil.setPublic(true);
			return true;
		}

		String authorization = request.getHeader(EnumData.AUTHORIZATION);
		if (authorization == null || authorization.isBlank()) {
			LOGGER.warn("Missing Authorization header. uri =" + uri);
			return deny(response);
		}
		if (!authorization.startsWith(EnumData.BEARER_PREFIX)) {
			LOGGER.warn("Invalid Authorization format. uri =" + uri);
			return deny(response);
		}
		String token = authorization.substring(EnumData.BEARER_PREFIX.length());
		if (!jwtUtils.validateJwtToken(token)) {
			LOGGER.warn("JWT validation failed. uri =" + uri);
			return deny(response);
		}
		Claims claims = JwtTokenUtil.getClaimsFromToken(token);
		if (claims == null) {
			LOGGER.warn("JWT claims extraction failed. uri =" + uri);
			return deny(response);
		}
		String userId = claims.getSubject();
		if (userId == null || userId.isBlank()) {
			LOGGER.warn("JWT subject claim missing or empty. uri =" + uri);
			return deny(response);
		}
		RequestHeaderUtil.setUserId(userId);

		// Only wealth-bss owns the cache and database; the BFF only forwards.
		NexusServiceClient nexus = nexusServiceClient.getIfAvailable();
		if (nexus != null) {
			ThreadLocalDto context = nexus.getRequestHeaderCache(userId);
			if (context == null) {
				LOGGER.warn("No cached request context for the user. uri =" + uri);
				return deny(response);
			}
			// A password reset or role change bumps session_version; tokens issued before it stop working.
			Integer tokenVersion = claims.get(EnumData.SESSION_VERSION_CLAIM, Integer.class);
			if (tokenVersion == null || !tokenVersion.equals(context.getSessionVersion())) {
				LOGGER.warn("Token session version does not match. uri =" + uri);
				return deny(response);
			}
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		String traceId = (String) request.getAttribute("TRACE_ID");
		String spanId = (String) request.getAttribute("SPAN_ID");
		Long startTime = (Long) request.getAttribute("START_TIME");
		if (startTime != null) {
			double durationSec = (System.nanoTime() - startTime) / 1_000_000_000.0;
			LOGGER.info("[traceId=" + traceId + "] [spanId=" + spanId + "] API END -> " + request.getMethod() + " "
					+ request.getRequestURI() + " | Status=" + response.getStatus() + " | Time="
					+ String.format("%.3f", durationSec) + " sec");
		}
		MDC.remove("traceId");
		MDC.remove("spanId");
		RequestHeaderUtil.clear();
	}

	private boolean deny(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		return false;
	}

	// Paths are matched without the /wealth/api/v1 (BFF) or /wealth-service/api/v1 (BSS) prefix.
	static boolean isPublicEndpoint(String uri) {
		if (uri == null) {
			return false;
		}
		if (uri.startsWith("/actuator") || uri.equals("/error") || uri.equals("/favicon.ico")
				|| uri.startsWith("/swagger-ui") || uri.startsWith("/v3/api-docs")
				|| uri.startsWith("/swagger-resources") || uri.startsWith("/webjars")) {
			return true;
		}
		var matcher = API_BASE_PATH.matcher(uri);
		if (!matcher.find()) {
			return false;
		}
		String path = uri.substring(matcher.end());
		return path.equals("/customers/users/login") || path.equals("/customers/users/register") || isUnder(path, "/health")
				|| isUnder(path, "/lend-view");
	}

	private static boolean isUnder(String path, String prefix) {
		return path.equals(prefix) || path.startsWith(prefix + "/");
	}

	static String getClientIp(HttpServletRequest request) {
		for (String header : EnumData.getIpHeaderCandidates()) {
			String value = request.getHeader(header);
			if (value != null && !value.isBlank()) {
				return value.split(",")[0].trim();
			}
		}
		return request.getRemoteAddr();
	}
}
