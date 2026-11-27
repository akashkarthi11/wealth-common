package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// A statement PDF chosen by the user: fileName (.pdf), data (the file as base64, up to 5 MB), an optional password for this file, and keep (save that password with the user's others, only when it opens the file).
public class StatementUploadRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fileName;
	private String data;
	private String password;
	private boolean keep;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isKeep() {
		return keep;
	}

	public void setKeep(boolean keep) {
		this.keep = keep;
	}
}
