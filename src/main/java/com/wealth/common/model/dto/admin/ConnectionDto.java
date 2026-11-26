package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// One service address: what is used now, what the deployment set, and whether the live check answers UP.
public class ConnectionDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String url;
	private String defaultUrl;
	private boolean customised;
	private String status;
	// The user the service signs in as (empty when none), and whether a password is set. The password itself is never returned.
	private String username;
	private boolean passwordSet;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDefaultUrl() {
		return defaultUrl;
	}

	public void setDefaultUrl(String defaultUrl) {
		this.defaultUrl = defaultUrl;
	}

	public boolean isCustomised() {
		return customised;
	}

	public void setCustomised(boolean customised) {
		this.customised = customised;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isPasswordSet() {
		return passwordSet;
	}

	public void setPasswordSet(boolean passwordSet) {
		this.passwordSet = passwordSet;
	}
}
