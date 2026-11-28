package com.wealth.common.model.dto.people;

import java.io.Serializable;

// Changes one record of a person: a line (entryId) can be active, written_off or removed (deleted); a bill share (splitId + personId) can be active or written_off. dryRun stores nothing.
public class RecordStatusRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String entryId;
	private String splitId;
	private String personId;
	private String status;
	private Boolean dryRun;

	public String getEntryId() {
		return entryId;
	}

	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getDryRun() {
		return dryRun;
	}

	public void setDryRun(Boolean dryRun) {
		this.dryRun = dryRun;
	}
}
