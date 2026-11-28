package com.wealth.common.model.dto.people;

import java.io.Serializable;
import java.math.BigDecimal;

// One of the person's recent "I've paid" messages on the public page and what became of it.
public class LendViewRequestRowDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal amount;
	private String paidOn;
	private String method;
	private String status;
	private String sentAt;
	private BigDecimal acceptedAmount;

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

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSentAt() {
		return sentAt;
	}

	public void setSentAt(String sentAt) {
		this.sentAt = sentAt;
	}

	public BigDecimal getAcceptedAmount() {
		return acceptedAmount;
	}

	public void setAcceptedAmount(BigDecimal acceptedAmount) {
		this.acceptedAmount = acceptedAmount;
	}
}
