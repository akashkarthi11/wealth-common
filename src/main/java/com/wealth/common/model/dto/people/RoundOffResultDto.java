package com.wealth.common.model.dto.people;

import java.io.Serializable;
import java.math.BigDecimal;

// What a round-off did (or, for a dry run, would do); roundedBy is what was let go.
public class RoundOffResultDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean stored;
	private boolean dryRun;
	private String rollupId;
	private int closed;
	private String person;
	private int closedItems;
	private BigDecimal totalOwed;
	private BigDecimal alreadyBack;
	private BigDecimal newAmount;
	private String closedOn;
	private BigDecimal roundedBy;

	public boolean isStored() {
		return stored;
	}

	public void setStored(boolean stored) {
		this.stored = stored;
	}

	public boolean isDryRun() {
		return dryRun;
	}

	public void setDryRun(boolean dryRun) {
		this.dryRun = dryRun;
	}

	public String getRollupId() {
		return rollupId;
	}

	public void setRollupId(String rollupId) {
		this.rollupId = rollupId;
	}

	public int getClosed() {
		return closed;
	}

	public void setClosed(int closed) {
		this.closed = closed;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public int getClosedItems() {
		return closedItems;
	}

	public void setClosedItems(int closedItems) {
		this.closedItems = closedItems;
	}

	public BigDecimal getTotalOwed() {
		return totalOwed;
	}

	public void setTotalOwed(BigDecimal totalOwed) {
		this.totalOwed = totalOwed;
	}

	public BigDecimal getAlreadyBack() {
		return alreadyBack;
	}

	public void setAlreadyBack(BigDecimal alreadyBack) {
		this.alreadyBack = alreadyBack;
	}

	public BigDecimal getNewAmount() {
		return newAmount;
	}

	public void setNewAmount(BigDecimal newAmount) {
		this.newAmount = newAmount;
	}

	public String getClosedOn() {
		return closedOn;
	}

	public void setClosedOn(String closedOn) {
		this.closedOn = closedOn;
	}

	public BigDecimal getRoundedBy() {
		return roundedBy;
	}

	public void setRoundedBy(BigDecimal roundedBy) {
		this.roundedBy = roundedBy;
	}
}
