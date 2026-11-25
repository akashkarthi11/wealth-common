package com.wealth.common.model.dto;

import java.io.Serializable;

// Per-request identity kept in the Nexus cache; no email, password or token.
public class ThreadLocalDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userId;
	private String role;
	private Integer sessionVersion;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getSessionVersion() {
		return sessionVersion;
	}

	public void setSessionVersion(Integer sessionVersion) {
		this.sessionVersion = sessionVersion;
	}
}
