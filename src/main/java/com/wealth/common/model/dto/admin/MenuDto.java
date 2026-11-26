package com.wealth.common.model.dto.admin;

import java.io.Serializable;

public class MenuDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String key;
	private String label;
	private String group;

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
}
