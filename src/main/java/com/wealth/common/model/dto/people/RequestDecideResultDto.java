package com.wealth.common.model.dto.people;

import java.io.Serializable;
import java.math.BigDecimal;

// What deciding a message did.
public class RequestDecideResultDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean stored;
	private String decision;
	private BigDecimal amount;
	private String paidOn;
	private boolean closeLend;

	public boolean isStored() {
		return stored;
	}

	public void setStored(boolean stored) {
		this.stored = stored;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getPaidOn() {
		return paidOn;
	}

	public void setPaidOn(String paidOn) {
		this.paidOn = paidOn;
	}

	public boolean isCloseLend() {
		return closeLend;
	}

	public void setCloseLend(boolean closeLend) {
		this.closeLend = closeLend;
	}
}
