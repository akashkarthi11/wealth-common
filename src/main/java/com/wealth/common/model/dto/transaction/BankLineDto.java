package com.wealth.common.model.dto.transaction;

import java.io.Serializable;
import java.math.BigDecimal;

// One bank transaction read from a mail alert or a statement, before it is stored. ref identifies it (the same one read again has the same ref); bank and accountDigits (last digits) place it on one of the user's accounts; kind (income, expense, transfer ...) and category are optional, otherwise they follow debit (money out); sure is false when the reader was not sure of the amount, the day or the direction; suspicious is true when it looks fake (for example dated in the future).
public class BankLineDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ref;
	private String bank;
	private String accountDigits;
	private String day;
	private String description;
	private String category;
	private String kind;
	private BigDecimal amount;
	private boolean debit;
	private boolean sure;
	private boolean suspicious;

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccountDigits() {
		return accountDigits;
	}

	public void setAccountDigits(String accountDigits) {
		this.accountDigits = accountDigits;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public boolean isDebit() {
		return debit;
	}

	public void setDebit(boolean debit) {
		this.debit = debit;
	}

	public boolean isSure() {
		return sure;
	}

	public void setSure(boolean sure) {
		this.sure = sure;
	}

	public boolean isSuspicious() {
		return suspicious;
	}

	public void setSuspicious(boolean suspicious) {
		this.suspicious = suspicious;
	}
}
