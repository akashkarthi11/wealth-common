package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// url: an address or host:port (a Kafka list may have commas). username and password are optional: empty keeps what is set now.
public class ConnectionRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	// For the Kafka refresh time only.
	private Integer refreshSeconds;

	// key: which service address (ui_to_bff or bff_to_bss) when saving one.
	private String key;
	private String url;
	private String username;
	private String password;
	// For the Active / Inactive switch only: true turns the service on, false turns it off.
	private Boolean enabled;

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRefreshSeconds() {
		return refreshSeconds;
	}

	public void setRefreshSeconds(Integer refreshSeconds) {
		this.refreshSeconds = refreshSeconds;
	}
}
