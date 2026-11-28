package com.wealth.common.model.dto.people;

import java.io.Serializable;

// The same person entered twice: everything of fromId moves to intoId, and fromId's name becomes one of intoId's other names. dryRun stores nothing.
public class PersonMergeRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fromId;
	private String intoId;
	private Boolean dryRun;

	public String getFromId() {
		return fromId;
	}

	public void setFromId(String fromId) {
		this.fromId = fromId;
	}

	public String getIntoId() {
		return intoId;
	}

	public void setIntoId(String intoId) {
		this.intoId = intoId;
	}

	public Boolean getDryRun() {
		return dryRun;
	}

	public void setDryRun(Boolean dryRun) {
		this.dryRun = dryRun;
	}
}
