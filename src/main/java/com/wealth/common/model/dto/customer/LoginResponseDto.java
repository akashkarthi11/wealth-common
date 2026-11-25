package com.wealth.common.model.dto.customer;

import java.io.Serializable;

public class LoginResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String token;
	private long expiresIn;
	private UserDto user;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}
}
