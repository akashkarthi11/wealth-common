package com.wealth.common.model.dto.transaction;

import java.io.Serializable;
import java.math.BigDecimal;

// One line of the activity list. account is a label (name and last digits, or Unassigned); inactive = marked as a duplicate or dismissed.
public class TransactionDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String kind;
	private String category;
	private String description;
	private BigDecimal amount;
	private String accountId;
	private String account;
	private String occurredOn;
	private String externalRef;
	private String reviewStatus;
	private String duplicateOf;
	private boolean inactive;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getOccurredOn() {
		return occurredOn;
	}

	public void setOccurredOn(String occurredOn) {
		this.occurredOn = occurredOn;
	}

	public String getExternalRef() {
		return externalRef;
	}

	public void setExternalRef(String externalRef) {
		this.externalRef = externalRef;
	}

	public String getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	public String getDuplicateOf() {
		return duplicateOf;
	}

	public void setDuplicateOf(String duplicateOf) {
		this.duplicateOf = duplicateOf;
	}

	public boolean isInactive() {
		return inactive;
	}

	public void setInactive(boolean inactive) {
		this.inactive = inactive;
	}
}
