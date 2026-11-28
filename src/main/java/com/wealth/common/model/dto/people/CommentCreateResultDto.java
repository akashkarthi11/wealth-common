package com.wealth.common.model.dto.people;

import java.io.Serializable;

// Whether the owner's answer was stored.
public class CommentCreateResultDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean stored;
	private String commentId;

	public boolean isStored() {
		return stored;
	}

	public void setStored(boolean stored) {
		this.stored = stored;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
}
