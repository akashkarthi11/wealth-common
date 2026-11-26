package com.wealth.common.model.dto.account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class SplitMoveRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String splitId;
	private BigDecimal amount;
	private Timestamp occurredAt;
	private String transactionId;
	private String note;
	private boolean dryRun;

	public String getSplitId() {
		return splitId;
	}

	public void setSplitId(String splitId) {
		this.splitId = splitId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Timestamp getOccurredAt() {
		return occurredAt;
	}

	public void setOccurredAt(Timestamp occurredAt) {
		this.occurredAt = occurredAt;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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
