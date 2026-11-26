package com.wealth.common.model.dto.account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class AccountBalanceDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Timestamp asOf;
	private BigDecimal balance;
	private String status;
	private String note;
	private String enteredBy;
	private Timestamp confirmedAt;
	private Timestamp rejectedAt;
	private String rejectedReason;

	public Timestamp getAsOf() {
		return asOf;
	}

	public void setAsOf(Timestamp asOf) {
		this.asOf = asOf;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
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

	public String getEnteredBy() {
		return enteredBy;
	}

	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}

	public Timestamp getConfirmedAt() {
		return confirmedAt;
	}

	public void setConfirmedAt(Timestamp confirmedAt) {
		this.confirmedAt = confirmedAt;
	}

	public Timestamp getRejectedAt() {
		return rejectedAt;
	}

	public void setRejectedAt(Timestamp rejectedAt) {
		this.rejectedAt = rejectedAt;
	}

	public String getRejectedReason() {
		return rejectedReason;
	}

	public void setRejectedReason(String rejectedReason) {
		this.rejectedReason = rejectedReason;
	}
}
