package com.wealth.common.model.dto.admin;

import java.io.Serializable;
import java.math.BigDecimal;

// One transaction read from a bank alert, waiting for the user to accept or dismiss it. kind is "income" or "expense"; date is yyyy-MM-dd.
// account is the matched account's label, or empty when no single account matched (Unassigned).
public class GmailPendingItemDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String kind;
	private BigDecimal amount;
	private String date;
	private String description;
	private String account;

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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
}
