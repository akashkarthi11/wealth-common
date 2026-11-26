package com.wealth.common.model.dto.admin;

import java.io.Serializable;
import java.util.List;

public class RoleDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String role;
	private String label;
	private int users;
	private boolean locked;
	private List<String> menus;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getUsers() {
		return users;
	}

	public void setUsers(int users) {
		this.users = users;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public List<String> getMenus() {
		return menus;
	}

	public void setMenus(List<String> menus) {
		this.menus = menus;
	}
}
