package com.wealth.common.model.dto.people;

import java.io.Serializable;

// Adds a person (no personId) or changes one: only the fields that are sent change (null = unchanged; for dueOn, annualRate and note an empty text clears it). annualRate is a percentage a year (12 is 12 %), worked out daily. dryRun stores nothing.
public class PersonSaveRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String personId;
	private String name;
	private String kind;
	private String dueOn;
	private String annualRate;
	private String status;
	private String note;
	private Boolean hidden;
	private Boolean dryRun;

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

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getDueOn() {
		return dueOn;
	}

	public void setDueOn(String dueOn) {
		this.dueOn = dueOn;
	}

	public String getAnnualRate() {
		return annualRate;
	}

	public void setAnnualRate(String annualRate) {
		this.annualRate = annualRate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getHidden() {
		return hidden;
	}

	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}

	public Boolean getDryRun() {
		return dryRun;
	}

	public void setDryRun(Boolean dryRun) {
		this.dryRun = dryRun;
	}
}
