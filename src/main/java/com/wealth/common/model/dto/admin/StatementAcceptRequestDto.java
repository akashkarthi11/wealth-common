package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// The statement whose rows the user accepts: its id, as the statement history lists it.
public class StatementAcceptRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	// Optional: the account every row belongs to (the user's own). Rows already saved without an account are given it.
	private String accountId;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
