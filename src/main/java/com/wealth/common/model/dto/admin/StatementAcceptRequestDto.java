package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// The statement whose rows the user accepts: its id, as the statement history lists it.
public class StatementAcceptRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
