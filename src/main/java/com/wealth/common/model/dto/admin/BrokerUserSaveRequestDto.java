package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// The user's own Angel One login. A blank value keeps the one saved; autoFetch is the daily fetch for this user.
public class BrokerUserSaveRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String apiKey;
	private String clientCode;
	private String pin;
	private String totpSecret;
	private String macAddress;
	private boolean autoFetch;

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getTotpSecret() {
		return totpSecret;
	}

	public void setTotpSecret(String totpSecret) {
		this.totpSecret = totpSecret;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public boolean isAutoFetch() {
		return autoFetch;
	}

	public void setAutoFetch(boolean autoFetch) {
		this.autoFetch = autoFetch;
	}
}
