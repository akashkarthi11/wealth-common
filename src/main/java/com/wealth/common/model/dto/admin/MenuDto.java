package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// One entry of the list a role's permissions are chosen from (from the table wealth_menus).
public class MenuDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String key;
	private String label;
	private String group;
	// The menu this entry is a submenu of (null for a top-level menu), and whether its page exists yet.
	private String parentKey;
	private boolean active;
	// Only the admin has it: shown on the permission screen, but a role cannot be given it.
	private boolean adminOnly;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getParentKey() {
		return parentKey;
	}

	public void setParentKey(String parentKey) {
		this.parentKey = parentKey;
	}

	public boolean isAdminOnly() {
		return adminOnly;
	}

	public void setAdminOnly(boolean adminOnly) {
		this.adminOnly = adminOnly;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
