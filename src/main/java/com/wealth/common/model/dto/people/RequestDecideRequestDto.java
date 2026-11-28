package com.wealth.common.model.dto.people;

import java.io.Serializable;
import java.math.BigDecimal;

// The owner accepts (decision accept) or declines (decline) a waiting "I've paid" message. Accepting records the money as paid back in cash: amount and paidOn default to the message's; closeLend defaults to whether it covers what is owed.
public class RequestDecideRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String requestId;
	private String decision;
	private BigDecimal amount;
	private String paidOn;
	private Boolean closeLend;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
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

	public Boolean getCloseLend() {
		return closeLend;
	}

	public void setCloseLend(Boolean closeLend) {
		this.closeLend = closeLend;
	}
}
