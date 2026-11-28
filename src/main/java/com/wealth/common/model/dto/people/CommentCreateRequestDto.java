package com.wealth.common.model.dto.people;

import java.io.Serializable;

// The owner answers a remark on a line (entryId) or a bill share (shareId): exactly one of the two ids.
public class CommentCreateRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String entryId;
	private String shareId;
	private String body;

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
