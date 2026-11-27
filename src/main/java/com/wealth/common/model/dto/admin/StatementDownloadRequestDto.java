package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// Which of the user's statements to download (its id in the statement history).
public class StatementDownloadRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
