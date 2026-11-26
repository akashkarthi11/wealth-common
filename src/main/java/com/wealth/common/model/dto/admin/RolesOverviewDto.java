package com.wealth.common.model.dto.admin;

import java.io.Serializable;
import java.util.List;

public class RolesOverviewDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<MenuDto> menus;
	private List<RoleDto> roles;

	public List<MenuDto> getMenus() {
		return menus;
	}

	public void setMenus(List<MenuDto> menus) {
		this.menus = menus;
	}

	public List<RoleDto> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
	}
}
