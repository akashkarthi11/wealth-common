package com.wealth.common.model.dto.people;

import java.io.Serializable;
import java.math.BigDecimal;

public class PeopleTotalsDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal owed;
	private BigDecimal lent;
	private BigDecimal repaid;
	private int hidden;
	private int people;
	private int overdue;
	private int splits;

	public BigDecimal getOwed() {
		return owed;
	}

	public void setOwed(BigDecimal owed) {
		this.owed = owed;
	}

	public BigDecimal getLent() {
		return lent;
	}

	public void setLent(BigDecimal lent) {
		this.lent = lent;
	}

	public BigDecimal getRepaid() {
		return repaid;
	}

	public void setRepaid(BigDecimal repaid) {
		this.repaid = repaid;
	}

	public int getHidden() {
		return hidden;
	}

	public void setHidden(int hidden) {
		this.hidden = hidden;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public int getOverdue() {
		return overdue;
	}

	public void setOverdue(int overdue) {
		this.overdue = overdue;
	}

	public int getSplits() {
		return splits;
	}

	public void setSplits(int splits) {
		this.splits = splits;
	}
}
