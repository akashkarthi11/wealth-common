package com.wealth.common.model.dto.people;

import java.io.Serializable;
import java.sql.Timestamp;

public class LendCommentDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String author;
	private String body;
	private Timestamp at;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Timestamp getAt() {
		return at;
	}

	public void setAt(Timestamp at) {
		this.at = at;
	}
}
