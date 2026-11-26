package com.wealth.common.model.dto.admin;

import java.io.Serializable;

public class ProviderRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String provider;

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}
}
