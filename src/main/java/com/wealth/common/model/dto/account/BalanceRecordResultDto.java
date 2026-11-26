package com.wealth.common.model.dto.account;

import java.io.Serializable;

public class BalanceRecordResultDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean stored;
	private AccountBalanceDto balance;
	private String reason;

	public boolean isStored() {
		return stored;
	}

	public void setStored(boolean stored) {
		this.stored = stored;
	}

	public AccountBalanceDto getBalance() {
		return balance;
	}

	public void setBalance(AccountBalanceDto balance) {
		this.balance = balance;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
