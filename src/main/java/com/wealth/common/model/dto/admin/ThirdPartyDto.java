package com.wealth.common.model.dto.admin;

import java.io.Serializable;
import java.sql.Timestamp;

// One third-party service for the Connections screen. The key itself is never here: only whether one is set and its last characters.
public class ThirdPartyDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String provider;
	private String label;
	private String baseUrl;
	private boolean enabled;
	private int priority;
	private boolean keySet;
	private String keyHint;
	// "ok" or "failed" from the last Test connection, null when never tested (or changed since).
	private String status;
	private Timestamp checkedAt;
	// Names of the other login values that are saved (Angel One: clientCode, pin, totpSecret, macAddress). Never their values.
	private java.util.List<String> extraSet;
	// The daily automatic fetch, and the last fetch (time and short result).
	private boolean autoFetch;
	private Timestamp lastFetchAt;
	private String lastFetchNote;

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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean isKeySet() {
		return keySet;
	}

	public void setKeySet(boolean keySet) {
		this.keySet = keySet;
	}

	public String getKeyHint() {
		return keyHint;
	}

	public void setKeyHint(String keyHint) {
		this.keyHint = keyHint;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public java.util.List<String> getExtraSet() {
		return extraSet;
	}

	public void setExtraSet(java.util.List<String> extraSet) {
		this.extraSet = extraSet;
	}

	public boolean isAutoFetch() {
		return autoFetch;
	}

	public void setAutoFetch(boolean autoFetch) {
		this.autoFetch = autoFetch;
	}

	public Timestamp getLastFetchAt() {
		return lastFetchAt;
	}

	public void setLastFetchAt(Timestamp lastFetchAt) {
		this.lastFetchAt = lastFetchAt;
	}

	public String getLastFetchNote() {
		return lastFetchNote;
	}

	public void setLastFetchNote(String lastFetchNote) {
		this.lastFetchNote = lastFetchNote;
	}

	public Timestamp getCheckedAt() {
		return checkedAt;
	}

	public void setCheckedAt(Timestamp checkedAt) {
		this.checkedAt = checkedAt;
	}
}
