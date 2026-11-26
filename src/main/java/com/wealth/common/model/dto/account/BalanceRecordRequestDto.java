package com.wealth.common.model.dto.account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class BalanceRecordRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String accountId;
	private BigDecimal balance;
	private Timestamp asOf;
	private String status;
	private String note;
	private boolean dryRun;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Timestamp getAsOf() {
		return asOf;
	}

	public void setAsOf(Timestamp asOf) {
		this.asOf = asOf;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public boolean isDryRun() {
		return dryRun;
	}

	public void setDryRun(boolean dryRun) {
		this.dryRun = dryRun;
	}
}
