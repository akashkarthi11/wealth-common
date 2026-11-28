package com.wealth.common.model.dto.transaction;

import java.io.Serializable;

// cursor: from the last page. size: 1 to 200, default 50. q: words in the description, category or account. kind, accountId, from and to (YYYY-MM-DD) narrow the list; empty = all.
public class TransactionPageRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cursor;
	private Integer size;
	private String q;
	private String kind;
	// Only this category (exactly as the dashboard names it); empty = every category.
	private String category;
	private String accountId;
	private String from;
	private String to;

	public String getCursor() {
		return cursor;
	}

	public void setCursor(String cursor) {
		this.cursor = cursor;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
}
