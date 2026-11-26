package com.wealth.common.model.dto.account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class SplitMoveDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Timestamp occurredAt;
	private BigDecimal amount;
	private String transactionId;
	private String note;

	public Timestamp getOccurredAt() {
		return occurredAt;
	}

	public void setOccurredAt(Timestamp occurredAt) {
		this.occurredAt = occurredAt;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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
}
