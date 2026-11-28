package com.wealth.common.model.dto.people;

import java.io.Serializable;

// The owner's description of a line (empty clears it).
public class EntryNoteRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String entryId;
	private String note;

	public String getEntryId() {
		return entryId;
	}

	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
