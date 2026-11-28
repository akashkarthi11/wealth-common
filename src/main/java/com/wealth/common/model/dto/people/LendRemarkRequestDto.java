package com.wealth.common.model.dto.people;

import java.io.Serializable;

// A remark from the person on one of their own lines (entryId) or bill shares (shareId), from the public page. Exactly one of the two ids.
public class LendRemarkRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String token;
	private String entryId;
	private String shareId;
	private String body;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEntryId() {
		return entryId;
	}

	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}

	public String getShareId() {
		return shareId;
	}

	public void setShareId(String shareId) {
		this.shareId = shareId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
