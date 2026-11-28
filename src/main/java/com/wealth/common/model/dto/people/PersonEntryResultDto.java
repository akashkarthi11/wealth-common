package com.wealth.common.model.dto.people;

import java.io.Serializable;

// What adding entries did (or, for a dry run, would do).
public class PersonEntryResultDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean stored;
	private boolean dryRun;
	private String personId;
	private String person;
	private int entries;

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

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public int getEntries() {
		return entries;
	}

	public void setEntries(int entries) {
		this.entries = entries;
	}
}
