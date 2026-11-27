package com.wealth.common.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;

// A value read through the nexus cache: the data, when it was read from the database, and whether it is older than the refresh time (a refresh was requested).
public class CachedValueDto<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private T data;
	private Timestamp fetchedAt;
	private boolean stale;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
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
