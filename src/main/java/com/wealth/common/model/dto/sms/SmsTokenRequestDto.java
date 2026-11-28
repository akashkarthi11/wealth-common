package com.wealth.common.model.dto.sms;

import java.io.Serializable;

// A call from the phone app that carries only its token (in the body, never in an address).
public class SmsTokenRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
