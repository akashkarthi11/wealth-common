package com.wealth.common.model.dto.admin;

import java.io.Serializable;
import java.math.BigDecimal;

// One transaction row read from a statement, as the statement screen lists it: the day (yyyy-MM-dd), the time when the statement has one, the description, the amount (always positive),
// whether it went out (debit) and whether the reader was sure of it. Nothing here is saved as a transaction until the user accepts the statement.
public class StatementRowDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String day;
	private String time;
	private String description;
	private BigDecimal amount;
	private boolean debit;
	private boolean sure;

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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
}
