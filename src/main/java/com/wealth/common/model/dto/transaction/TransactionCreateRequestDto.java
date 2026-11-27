package com.wealth.common.model.dto.transaction;

import java.io.Serializable;
import java.math.BigDecimal;

// kind: income, expense, transfer, investment or liability. category up to 60, description up to 180, amount above 0 and at most 10^12, date YYYY-MM-DD.
// accountId or account (a name); an unknown name leaves the entry unassigned. externalRef (up to 120): a reference already recorded is refused.
public class TransactionCreateRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String kind;
	private String category;
	private String description;
	private BigDecimal amount;
	private String accountId;
	private String account;
	private String date;
	private String externalRef;

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getExternalRef() {
		return externalRef;
	}

	public void setExternalRef(String externalRef) {
		this.externalRef = externalRef;
	}
}
