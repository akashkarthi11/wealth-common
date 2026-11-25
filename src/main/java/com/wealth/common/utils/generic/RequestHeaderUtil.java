package com.wealth.common.utils.generic;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import com.wealth.common.client.NexusServiceClient;
import com.wealth.common.model.dto.ThreadLocalDto;

// Thread-local holds request metadata only; the user context is never kept here, it is read from Redis on every call.
@Component
public class RequestHeaderUtil {

	private static final ThreadLocal<State> STATE = ThreadLocal.withInitial(State::new);

	// Same wiring as growx-common-lib: a static handle set once by the Spring bean.
	private static volatile ObjectProvider<NexusServiceClient> nexusServiceClient;

	public RequestHeaderUtil(ObjectProvider<NexusServiceClient> client) {
		nexusServiceClient = client;
	}

	private static final class State {
		String traceId;
		String spanId;
		String correlationId;
		String ip;
		String userId;
		boolean publicEndpoint;
	}

	public static void setTraceId(String v) { STATE.get().traceId = v; }
	public static String getTraceId() { return STATE.get().traceId; }

	public static void setSpanId(String v) { STATE.get().spanId = v; }
	public static String getSpanId() { return STATE.get().spanId; }

	public static void setCorrelationId(String v) { STATE.get().correlationId = v; }
	public static String getCorrelationId() { return STATE.get().correlationId; }

	public static void setIp(String v) { STATE.get().ip = v; }
	public static String getIp() { return STATE.get().ip; }

	public static void setUserId(String v) { STATE.get().userId = v; }
	public static String getUserId() { return STATE.get().userId; }

	public static void setPublic(boolean v) { STATE.get().publicEndpoint = v; }
	public static boolean isPublic() { return STATE.get().publicEndpoint; }

	// Fetches from Redis each call; null for a public request, an unknown user, or when no Nexus client exists (BFF).
	public static ThreadLocalDto getThreadLocalDto() {
		String userId = getUserId();
		ObjectProvider<NexusServiceClient> provider = nexusServiceClient;
		if (userId == null || provider == null) {
			return null;
		}
		NexusServiceClient client = provider.getIfAvailable();
		return client == null ? null : client.getRequestHeaderCache(userId);
	}

	public static void clear() {
		STATE.remove();
	}
}
