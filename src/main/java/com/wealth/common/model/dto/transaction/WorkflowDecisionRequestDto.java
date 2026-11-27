package com.wealth.common.model.dto.transaction;

import java.io.Serializable;

// decision: merge (it is the same payment as the candidate: nothing is added), accept (it is a real new transaction: it is added) or dismiss (ignore it for good).
public class WorkflowDecisionRequestDto implements Serializable {

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
