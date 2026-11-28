package com.wealth.common.model.dto.people;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// What saving a person did (or, for a dry run, would do): the fields that changed.
public class PersonSaveResultDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean stored;
	private boolean dryRun;
	private String personId;
	private List<String> changed = new ArrayList<>();

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

	public List<String> getChanged() {
		return changed;
	}

	public void setChanged(List<String> changed) {
		this.changed = changed;
	}
}
