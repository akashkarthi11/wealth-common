package com.wealth.common.model.dto.people;

import java.io.Serializable;
import java.math.BigDecimal;

// Closes everything open with a person into one round-off: what is owed now, what was already back, and one new amount carried forward. dryRun stores nothing.
public class RoundOffRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String personId;
	private BigDecimal alreadyBack;
	private BigDecimal newAmount;
	private String closedOn;
	private String note;
	private Boolean dryRun;

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getDryRun() {
		return dryRun;
	}

	public void setDryRun(Boolean dryRun) {
		this.dryRun = dryRun;
	}
}
