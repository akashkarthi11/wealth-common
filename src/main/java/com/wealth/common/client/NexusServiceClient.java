package com.wealth.common.client;

import com.wealth.common.model.dto.ThreadLocalDto;

// Request-header cache lookup used by the Interceptor; wealth-bss implements it in-process.
public interface NexusServiceClient {

	// Returns null when the user is unknown.
	ThreadLocalDto getRequestHeaderCache(String userId);
}
