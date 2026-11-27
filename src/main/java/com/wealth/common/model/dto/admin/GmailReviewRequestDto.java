package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// The user's decision on one pending transaction: decision is "accept" or "dismiss".
public class GmailReviewRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String decision;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}
}
