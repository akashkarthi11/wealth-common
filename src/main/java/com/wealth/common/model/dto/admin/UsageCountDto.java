package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// What one API of the BFF was used for since its last report: the calls, how they ended and the time they took (the BFF sends these to the BSS, which saves them).
public class UsageCountDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	// The user who made the calls; empty when there was none (sign-in, calls before a user is known).
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	private long calls;
	private long success;
	private long clientErrors;
	private long failures;
	private long totalMs;

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

	public long getTotalMs() {
		return totalMs;
	}

	public void setTotalMs(long totalMs) {
		this.totalMs = totalMs;
	}
}
