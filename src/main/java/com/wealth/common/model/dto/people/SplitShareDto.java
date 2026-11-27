package com.wealth.common.model.dto.people;

import java.io.Serializable;
import java.math.BigDecimal;

public class SplitShareDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String personId;
	private String name;
	private BigDecimal base;
	private BigDecimal tax;
	private BigDecimal amount;
	private boolean paid;

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getBase() {
		return base;
	}

	public void setBase(BigDecimal base) {
		this.base = base;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}
}
