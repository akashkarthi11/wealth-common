package com.wealth.common.model.dto.customer;

import java.io.Serializable;

public class PasswordResetRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;
	private String newPassword;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}
