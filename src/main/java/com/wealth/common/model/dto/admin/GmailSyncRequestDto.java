package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// Starts a Gmail read in the background. kind: alerts, statements or all (alerts first, then statements).
public class GmailSyncRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String kind;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
}
