package com.wealth.common.interceptor;

// Optional: when a bean of this type exists, the interceptor reports every finished request to it, once. Counting and storing is its job; a failure in it must
// never reach the request, so the interceptor ignores any exception it throws.
public interface ApiUsageRecorder {

	// route is the route template Spring matched (for example POST /wealth-service/api/v1/accounts/detail), or null when no route matched.
	void record(String method, String route, int status, long millis);
}
