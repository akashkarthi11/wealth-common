package com.wealth.common.model.dto.people;

import java.io.Serializable;

// Turns a person's share link on (a new secret replaces the old link) or off.
public class ShareUpdateRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String personId;
	private Boolean enabled;

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}
