package com.wealth.common.model.dto.people;

import java.io.Serializable;
import java.math.BigDecimal;

// The person says they paid: sent from the public page with the link's secret in the body. method is upi, bank, cash or other.
public class LendPaidRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String token;
	private BigDecimal amount;
	private String paidOn;
	private String method;
	private String note;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
