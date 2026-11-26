package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// Adds or changes a provider. apiKey: empty keeps the key now saved; a value replaces it.
public class ThirdPartySaveRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String provider;
	private String label;
	private String baseUrl;
	private String apiKey;
	private boolean enabled;
	private int priority;
	// The other login values by name (Angel One: clientCode, pin, totpSecret, macAddress); an empty one keeps what is saved.
	private java.util.Map<String, String> extra;
	private boolean autoFetch;

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public java.util.Map<String, String> getExtra() {
		return extra;
	}

	public void setExtra(java.util.Map<String, String> extra) {
		this.extra = extra;
	}

	public boolean isAutoFetch() {
		return autoFetch;
	}

	public void setAutoFetch(boolean autoFetch) {
		this.autoFetch = autoFetch;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
}
