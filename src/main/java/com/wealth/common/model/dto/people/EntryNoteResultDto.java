package com.wealth.common.model.dto.people;

import java.io.Serializable;

// What the line's description is now.
public class EntryNoteResultDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean stored;
	private String note;

	public boolean isStored() {
		return stored;
	}

	public void setStored(boolean stored) {
		this.stored = stored;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
