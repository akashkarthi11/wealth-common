package com.wealth.common.model.dto;

import java.io.Serializable;

public class AccountIdRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String accountId;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
}
