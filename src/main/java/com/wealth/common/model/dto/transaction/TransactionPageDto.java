package com.wealth.common.model.dto.transaction;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

// One page of transactions, newest first. nextCursor is null on the last page. fetchedAt and stale are set only for the cached first page.
public class TransactionPageDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<TransactionDto> items = new ArrayList<>();
	private String nextCursor;
	private Timestamp fetchedAt;
	private boolean stale;

	public List<TransactionDto> getItems() {
		return items;
	}

	public void setItems(List<TransactionDto> items) {
		this.items = items;
	}

	public String getNextCursor() {
		return nextCursor;
	}

	public void setNextCursor(String nextCursor) {
		this.nextCursor = nextCursor;
	}

	public Timestamp getFetchedAt() {
		return fetchedAt;
	}

	public void setFetchedAt(Timestamp fetchedAt) {
		this.fetchedAt = fetchedAt;
	}

	public boolean isStale() {
		return stale;
	}

	public void setStale(boolean stale) {
		this.stale = stale;
	}
}
