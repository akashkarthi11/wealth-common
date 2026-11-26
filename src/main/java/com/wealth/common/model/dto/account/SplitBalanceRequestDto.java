package com.wealth.common.model.dto.account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class SplitBalanceRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String splitId;
	private BigDecimal balance;
	private Timestamp asOf;
	private String note;
	private boolean dryRun;

	public String getSplitId() {
		return splitId;
	}

	public void setSplitId(String splitId) {
		this.splitId = splitId;
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
