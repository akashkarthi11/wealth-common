package com.wealth.common.model.dto.people;

import java.io.Serializable;

// The public page asks for one person's summary with the link's secret, sent in the body and never in an address.
public class LendViewRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
