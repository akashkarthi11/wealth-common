package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// The calls of one API (internal) or one outside provider endpoint (external) over the days asked for.
// success: 2xx answers, or calls that worked. clientErrors: 4xx answers (internal only). failures: 5xx answers, or outside calls that failed.
public class ApiUsageRowDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private long calls;
	private long success;
	private long clientErrors;
	private long failures;
	// Average time of a call in milliseconds (total time divided by calls).
	private long averageMs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCalls() {
		return calls;
	}

	public void setCalls(long calls) {
		this.calls = calls;
	}

	public long getSuccess() {
		return success;
	}

	public void setSuccess(long success) {
		this.success = success;
	}

	public long getClientErrors() {
		return clientErrors;
	}

	public void setClientErrors(long clientErrors) {
		this.clientErrors = clientErrors;
	}

	public long getFailures() {
		return failures;
	}

	public void setFailures(long failures) {
		this.failures = failures;
	}

	public long getAverageMs() {
		return averageMs;
	}

	public void setAverageMs(long averageMs) {
		this.averageMs = averageMs;
	}
}
