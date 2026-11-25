package com.wealth.common.model.dto.customer;

import java.io.Serializable;

public class RegisterRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;
	private String password;
	private String secretKey;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
}
