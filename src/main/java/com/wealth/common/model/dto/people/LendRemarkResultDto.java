package com.wealth.common.model.dto.people;

import java.io.Serializable;

// Whether the remark was stored.
public class LendRemarkResultDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean stored;

	public boolean isStored() {
		return stored;
	}

	public void setStored(boolean stored) {
		this.stored = stored;
	}
}
