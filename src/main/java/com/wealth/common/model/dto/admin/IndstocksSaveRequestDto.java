package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// The user's INDstocks API token, generated at indstocks.com. Saved encrypted and never returned.
public class IndstocksSaveRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
