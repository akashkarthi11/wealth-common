package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// A statement PDF fetched from Gmail for the user to save: its file name and the file as base64.
public class StatementFileDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fileName;
	private String data;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
