package com.wealth.common.model.dto.admin;

import java.io.Serializable;
import java.sql.Timestamp;

// One line of the connections overview. For a main row: the provider's settings and its last test. For a common row: the one key everyone shares (only that it is set and its last
// characters). For a user row: one user's own key (only that it is set, its status and last check). A key is never here.
public class ConnectionOverviewRowDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String provider;
	private String label;
	// "shared" (one key for everyone) or "user" (each user's own).
	private String scope;
	private boolean enabled;
	private boolean keySet;
	private String keyHint;
	// "ok" or "failed" from the last check, null when never checked.
	private String status;
	private Timestamp checkedAt;
	private Timestamp updatedAt;
	// Only on user rows: whose connection it is.
	private String userEmail;

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

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

	public Timestamp getCheckedAt() {
		return checkedAt;
	}

	public void setCheckedAt(Timestamp checkedAt) {
		this.checkedAt = checkedAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
