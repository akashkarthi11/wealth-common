package com.wealth.common.model.dto.people;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// Split one of the caller's transactions with other people. The total is the transaction's amount; tax is the GST inside it.
public class SplitCreateRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String transactionId;
	private String mode;
	private Boolean includeMe;
	private BigDecimal tax;
	private String note;
	private List<SplitPersonRequestDto> people = new ArrayList<>();

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Boolean getIncludeMe() {
		return includeMe;
	}

	public void setIncludeMe(Boolean includeMe) {
		this.includeMe = includeMe;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<SplitPersonRequestDto> getPeople() {
		return people;
	}

	public void setPeople(List<SplitPersonRequestDto> people) {
		this.people = people;
	}
}
