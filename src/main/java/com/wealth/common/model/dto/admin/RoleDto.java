package com.wealth.common.model.dto.admin;

// A role with the menus it can open (inherited); a locked role sends no menus because it always sees every one.
public class RoleDto extends RoleMenusDto {

	private static final long serialVersionUID = 1L;

	private String label;
	private int users;
	private boolean locked;

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
}
