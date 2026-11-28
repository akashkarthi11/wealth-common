package com.wealth.common.model.dto.people;

import java.io.Serializable;

// What changing a record did (or, for a dry run, would do): from and to are its status before and after; nothing is stored when they are the same.
public class RecordStatusResultDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean stored;
	private boolean dryRun;
	private String from;
	private String to;

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

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
}
