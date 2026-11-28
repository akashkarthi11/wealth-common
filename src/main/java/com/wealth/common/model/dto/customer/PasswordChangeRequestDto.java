package com.wealth.common.model.dto.customer;

import java.io.Serializable;

// The signed-in user changes their own password: the current one and the new one. Never logged.
public class PasswordChangeRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String currentPassword;
	private String newPassword;

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}
