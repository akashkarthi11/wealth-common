package com.wealth.common.model.dto.people;

import java.io.Serializable;
import java.math.BigDecimal;

// One person in a new split: an existing person (personId) or a name (added when new), and the amount before GST in "amounts" mode.
public class SplitPersonRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String personId;
	private String name;
	private BigDecimal base;

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

	public BigDecimal getBase() {
		return base;
	}

	public void setBase(BigDecimal base) {
		this.base = base;
	}
}
