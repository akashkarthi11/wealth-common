package com.wealth.common.model.dto.admin;

import java.io.Serializable;
import java.sql.Timestamp;

// The signed-in user's own INDstocks connection. providerOn: an admin has switched INDstocks on in Common. tokenSet: a token is saved (never the token). status is "ok" or "failed" from the last test, null when never tested.
public class IndstocksStatusDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean providerOn;
	private boolean tokenSet;
	private String status;
	private Timestamp checkedAt;

	public boolean isProviderOn() {
		return providerOn;
	}

	public void setProviderOn(boolean providerOn) {
		this.providerOn = providerOn;
	}

	public boolean isTokenSet() {
		return tokenSet;
	}

	public void setTokenSet(boolean tokenSet) {
		this.tokenSet = tokenSet;
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
}
