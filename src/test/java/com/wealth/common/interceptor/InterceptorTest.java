package com.wealth.common.interceptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.wealth.common.client.NexusServiceClient;
import com.wealth.common.model.dto.ThreadLocalDto;
import com.wealth.common.utils.generic.RequestHeaderUtil;
import com.wealth.common.utils.security.JwtTokenUtil;

import io.jsonwebtoken.Claims;

class InterceptorTest {

	private static final String USER_ID = "3f2b8c1e-0a4d-4c55-9d0e-1b6c7a8d9e10";

	private JwtTokenUtil jwt;
	private NexusServiceClient nexus;
	private ObjectProvider<NexusServiceClient> provider;
	private Interceptor interceptor;
	private MockHttpServletResponse response;

	@SuppressWarnings("unchecked")
	@BeforeEach
	void setUp() {
		jwt = mock(JwtTokenUtil.class);
		nexus = mock(NexusServiceClient.class);
		provider = mock(ObjectProvider.class);
		when(provider.getIfAvailable()).thenReturn(nexus);
		interceptor = new Interceptor(jwt, provider);
		new RequestHeaderUtil(provider);
		response = new MockHttpServletResponse();
	}

	@AfterEach
	void tearDown() {
		RequestHeaderUtil.clear();
	}

	private MockHttpServletRequest request(String method, String uri) {
		return new MockHttpServletRequest(method, uri);
	}

	private MockHttpServletRequest bearer(String uri) {
		MockHttpServletRequest req = request("GET", uri);
		req.addHeader("Authorization", "Bearer token-value");
		return req;
	}

	@Test
	void actuatorIsPublicAndSkipsJwt() throws Exception {
		assertTrue(interceptor.preHandle(request("GET", "/actuator/health"), response, null));
		assertTrue(RequestHeaderUtil.isPublic());
		verify(jwt, never()).validateJwtToken(anyString());
	}
	@Test
	void loginAndRegisterUnderBothBasePathsArePublic() {
		assertTrue(Interceptor.isPublicEndpoint("/wealth/api/v1/customers/users/login"));
		assertTrue(Interceptor.isPublicEndpoint("/wealth-service/api/v1/customers/users/register"));
		assertTrue(Interceptor.isPublicEndpoint("/wealth-service/api/v1/health"));
		assertTrue(Interceptor.isPublicEndpoint("/wealth-service/api/v1/lend-view"));
	}

	@Test
	void otherCustomerEndpointsAndLookalikesAreNotPublic() {
		assertFalse(Interceptor.isPublicEndpoint("/wealth/api/v1/customers/users/me"));
		assertFalse(Interceptor.isPublicEndpoint("/wealth/api/v1/customers/users/password/reset"));
		assertFalse(Interceptor.isPublicEndpoint("/wealth/api/v1/customers/users/login/extra"));
		assertFalse(Interceptor.isPublicEndpoint("/wealth-service/api/v1/ledger"));
		assertFalse(Interceptor.isPublicEndpoint("/other/api/v1/customers/users/login"));
		assertFalse(Interceptor.isPublicEndpoint("/customers/users/login"));
	}
	@Test
	void preflightPasses() throws Exception {
		assertTrue(interceptor.preHandle(request("OPTIONS", "/wealth/api/v1/ledger"), response, null));
	}

	@Test
	void missingAuthorizationIs401() throws Exception {
		assertFalse(interceptor.preHandle(request("GET", "/wealth/api/v1/ledger"), response, null));
		assertEquals(401, response.getStatus());
	}

	@Test
	void nonBearerSchemeIs401() throws Exception {
		MockHttpServletRequest req = request("GET", "/wealth/api/v1/ledger");
		req.addHeader("Authorization", "Basic abc");
		assertFalse(interceptor.preHandle(req, response, null));
		assertEquals(401, response.getStatus());
	}

	@Test
	void invalidJwtIs401() throws Exception {
		when(jwt.validateJwtToken("token-value")).thenReturn(false);
		assertFalse(interceptor.preHandle(bearer("/wealth/api/v1/ledger"), response, null));
		assertEquals(401, response.getStatus());
	}

	@Test
	void blankSubjectIs401() throws Exception {
		when(jwt.validateJwtToken("token-value")).thenReturn(true);
		Claims claims = mock(Claims.class);
		when(claims.getSubject()).thenReturn(" ");
		try (MockedStatic<JwtTokenUtil> util = mockStatic(JwtTokenUtil.class)) {
			util.when(() -> JwtTokenUtil.getClaimsFromToken("token-value")).thenReturn(claims);
			assertFalse(interceptor.preHandle(bearer("/wealth/api/v1/ledger"), response, null));
		}
		assertEquals(401, response.getStatus());
	}

	@Test
	void unknownUserInCacheAndDatabaseIs401() throws Exception {
		when(jwt.validateJwtToken("token-value")).thenReturn(true);
		when(nexus.getRequestHeaderCache(USER_ID)).thenReturn(null);
		Claims claims = mock(Claims.class);
		when(claims.getSubject()).thenReturn(USER_ID);
		when(claims.get("sv", Integer.class)).thenReturn(4);
		try (MockedStatic<JwtTokenUtil> util = mockStatic(JwtTokenUtil.class)) {
			util.when(() -> JwtTokenUtil.getClaimsFromToken("token-value")).thenReturn(claims);
			assertFalse(interceptor.preHandle(bearer("/wealth/api/v1/ledger"), response, null));
		}
		assertEquals(401, response.getStatus());
		assertNull(RequestHeaderUtil.getThreadLocalDto());
	}

	@Test
	void knownUserPassesAndContextIsSet() throws Exception {
		when(jwt.validateJwtToken("token-value")).thenReturn(true);
		ThreadLocalDto dto = new ThreadLocalDto();
		dto.setUserId(USER_ID);
		dto.setRole("user");
		dto.setSessionVersion(4);
		when(nexus.getRequestHeaderCache(USER_ID)).thenReturn(dto);
		Claims claims = mock(Claims.class);
		when(claims.getSubject()).thenReturn(USER_ID);
		when(claims.get("sv", Integer.class)).thenReturn(4);
		try (MockedStatic<JwtTokenUtil> util = mockStatic(JwtTokenUtil.class)) {
			util.when(() -> JwtTokenUtil.getClaimsFromToken("token-value")).thenReturn(claims);
			assertTrue(interceptor.preHandle(bearer("/wealth/api/v1/ledger"), response, null));
		}
		assertEquals(USER_ID, RequestHeaderUtil.getUserId());
		assertEquals("user", RequestHeaderUtil.getThreadLocalDto().getRole());
		assertNotNull(RequestHeaderUtil.getTraceId());
	}

	@Test
	void everyReadOfTheContextGoesToTheNexusClient() throws Exception {
		when(jwt.validateJwtToken("token-value")).thenReturn(true);
		ThreadLocalDto dto = new ThreadLocalDto();
		dto.setRole("user");
		dto.setSessionVersion(4);
		when(nexus.getRequestHeaderCache(USER_ID)).thenReturn(dto);
		Claims claims = mock(Claims.class);
		when(claims.getSubject()).thenReturn(USER_ID);
		when(claims.get("sv", Integer.class)).thenReturn(4);
		try (MockedStatic<JwtTokenUtil> util = mockStatic(JwtTokenUtil.class)) {
			util.when(() -> JwtTokenUtil.getClaimsFromToken("token-value")).thenReturn(claims);
			assertTrue(interceptor.preHandle(bearer("/wealth/api/v1/ledger"), response, null));
		}
		RequestHeaderUtil.getThreadLocalDto();
		RequestHeaderUtil.getThreadLocalDto();
		verify(nexus, times(3)).getRequestHeaderCache(USER_ID);
	}

	@Test
	void publicRequestHasNoContextAndNeverAsksNexus() throws Exception {
		interceptor.preHandle(request("GET", "/actuator/health"), response, null);
		assertNull(RequestHeaderUtil.getThreadLocalDto());
		verify(nexus, never()).getRequestHeaderCache(anyString());
	}

	@Test
	void withoutNexusClientTheBffOnlyChecksTheJwt() throws Exception {
		when(provider.getIfAvailable()).thenReturn(null);
		when(jwt.validateJwtToken("token-value")).thenReturn(true);
		Claims claims = mock(Claims.class);
		when(claims.getSubject()).thenReturn(USER_ID);
		when(claims.get("sv", Integer.class)).thenReturn(4);
		try (MockedStatic<JwtTokenUtil> util = mockStatic(JwtTokenUtil.class)) {
			util.when(() -> JwtTokenUtil.getClaimsFromToken("token-value")).thenReturn(claims);
			assertTrue(interceptor.preHandle(bearer("/wealth/api/v1/ledger"), response, null));
		}
		assertNull(RequestHeaderUtil.getThreadLocalDto());
	}

	@Test
	void afterCompletionClearsTheThreadState() throws Exception {
		MockHttpServletRequest req = request("GET", "/actuator/health");
		interceptor.preHandle(req, response, null);
		assertNotNull(RequestHeaderUtil.getTraceId());
		interceptor.afterCompletion(req, response, null, null);
		assertNull(RequestHeaderUtil.getTraceId());
		assertFalse(RequestHeaderUtil.isPublic());
	}

	@Test
	void clientIpUsesTheFirstForwardedAddress() {
		MockHttpServletRequest req = request("GET", "/x");
		req.setRemoteAddr("10.0.0.9");
		assertEquals("10.0.0.9", Interceptor.getClientIp(req));
		req.addHeader("X-Forwarded-For", "203.0.113.5, 10.0.0.1");
		assertEquals("203.0.113.5", Interceptor.getClientIp(req));
	}

	private boolean preHandleWithSv(Integer tokenSv, Integer cachedSv) throws Exception {
		when(jwt.validateJwtToken("token-value")).thenReturn(true);
		ThreadLocalDto dto = new ThreadLocalDto();
		dto.setSessionVersion(cachedSv);
		when(nexus.getRequestHeaderCache(USER_ID)).thenReturn(dto);
		Claims claims = mock(Claims.class);
		when(claims.getSubject()).thenReturn(USER_ID);
		when(claims.get("sv", Integer.class)).thenReturn(tokenSv);
		try (MockedStatic<JwtTokenUtil> util = mockStatic(JwtTokenUtil.class)) {
			util.when(() -> JwtTokenUtil.getClaimsFromToken("token-value")).thenReturn(claims);
			return interceptor.preHandle(bearer("/wealth/api/v1/ledger"), response, null);
		}
	}

	@Test
	void tokenFromBeforeAPasswordResetIs401() throws Exception {
		assertFalse(preHandleWithSv(3, 4));
		assertEquals(401, response.getStatus());
	}

	@Test
	void tokenWithoutSessionVersionIs401() throws Exception {
		assertFalse(preHandleWithSv(null, 4));
		assertEquals(401, response.getStatus());
	}

	@Test
	void tokenWithTheCurrentSessionVersionPasses() throws Exception {
		assertTrue(preHandleWithSv(4, 4));
	}
}
