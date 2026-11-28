package com.wealth.common.model.dto.people;

import java.io.Serializable;

// What a merge did (or, for a dry run, would do): the two names and the person everything is under now.
public class PersonMergeResultDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean stored;
	private boolean dryRun;
	private String from;
	private String into;
	private String personId;

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

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getInto() {
		return into;
	}

	public void setInto(String into) {
		this.into = into;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}
}
