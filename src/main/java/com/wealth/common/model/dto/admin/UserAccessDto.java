package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// A user and the role they have, for the admin's Users screen. No password, hash or token.
public class UserAccessDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String email;
	private String role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
