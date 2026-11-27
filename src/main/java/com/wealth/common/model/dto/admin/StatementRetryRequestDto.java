package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// Try a locked statement received from Gmail again with a password typed for it: id (the statement's id), password, and keep (save it with the user's others, only when it opens the file).
public class StatementRetryRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String password;
	private boolean keep;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
