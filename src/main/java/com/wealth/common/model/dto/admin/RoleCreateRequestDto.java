package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// A new role: only its name. The key is made from the name by the BSS.
public class RoleCreateRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
