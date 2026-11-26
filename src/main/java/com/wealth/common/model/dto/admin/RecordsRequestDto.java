package com.wealth.common.model.dto.admin;

import java.io.Serializable;

public class RecordsRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	// Optional search text; matches the record's name or key.
	private String q;

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}
}
