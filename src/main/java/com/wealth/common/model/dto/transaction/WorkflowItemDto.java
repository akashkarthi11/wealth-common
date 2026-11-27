package com.wealth.common.model.dto.transaction;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// A bank line waiting for the user's decision, with the transactions it may be a copy of. source: alert or statement. reason: possible_duplicate, parse_unsure or suspicious. direction: debit or credit.
public class WorkflowItemDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String source;
	private String reason;
	private String occurredOn;
	private String description;
	private BigDecimal amount;
	private String direction;
	private String accountId;
	private String account;
	private List<TransactionDto> candidates = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getOccurredOn() {
		return occurredOn;
	}

	public void setOccurredOn(String occurredOn) {
		this.occurredOn = occurredOn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public List<TransactionDto> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<TransactionDto> candidates) {
		this.candidates = candidates;
	}
}
