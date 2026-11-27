package com.wealth.common.model.dto.admin;

import java.io.Serializable;
import java.sql.Timestamp;

// The signed-in user's own Angel One connection. providerOn: an admin has switched Angel One on in Common. saved: the login is complete. The *Set flags say which login values are saved (never the values).
public class BrokerUserStatusDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean providerOn;
	private boolean saved;
	private boolean apiKeySet;
	private boolean clientCodeSet;
	private boolean pinSet;
	private boolean totpSet;
	private boolean macSet;
	private boolean autoFetch;
	private String status;
	private Timestamp checkedAt;
	private String fetchNote;
	private Timestamp fetchAt;

	public boolean isProviderOn() {
		return providerOn;
	}

	public void setProviderOn(boolean providerOn) {
		this.providerOn = providerOn;
	}

	public boolean isSaved() {
		return saved;
	}

	public void setSaved(boolean saved) {
		this.saved = saved;
	}

	public boolean isApiKeySet() {
		return apiKeySet;
	}

	public void setApiKeySet(boolean apiKeySet) {
		this.apiKeySet = apiKeySet;
	}

	public boolean isClientCodeSet() {
		return clientCodeSet;
	}

	public void setClientCodeSet(boolean clientCodeSet) {
		this.clientCodeSet = clientCodeSet;
	}

	public boolean isPinSet() {
		return pinSet;
	}

	public void setPinSet(boolean pinSet) {
		this.pinSet = pinSet;
	}

	public boolean isTotpSet() {
		return totpSet;
	}

	public void setTotpSet(boolean totpSet) {
		this.totpSet = totpSet;
	}

	public boolean isMacSet() {
		return macSet;
	}

	public void setMacSet(boolean macSet) {
		this.macSet = macSet;
	}

	public boolean isAutoFetch() {
		return autoFetch;
	}

	public void setAutoFetch(boolean autoFetch) {
		this.autoFetch = autoFetch;
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

	public String getFetchNote() {
		return fetchNote;
	}

	public void setFetchNote(String fetchNote) {
		this.fetchNote = fetchNote;
	}

	public Timestamp getFetchAt() {
		return fetchAt;
	}

	public void setFetchAt(Timestamp fetchAt) {
		this.fetchAt = fetchAt;
	}
}
