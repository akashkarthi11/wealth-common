package com.wealth.common.model.dto.people;

import java.io.Serializable;

// Marks one person's share of a split bill as paid back. dryRun stores nothing.
public class SharePaidRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String splitId;
	private String personId;
	private String occurredOn;
	private String note;
	private Boolean dryRun;

	public String getSplitId() {
		return splitId;
	}

	public void setSplitId(String splitId) {
		this.splitId = splitId;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getOccurredOn() {
		return occurredOn;
	}

	public void setOccurredOn(String occurredOn) {
		this.occurredOn = occurredOn;
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
