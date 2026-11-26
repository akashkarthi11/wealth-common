package com.wealth.common.model.dto.admin;

import java.io.Serializable;
import java.util.List;

public class RoleMenusDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String role;
	private List<String> menus;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<String> getMenus() {
		return menus;
	}

	public void setMenus(List<String> menus) {
		this.menus = menus;
	}
}
