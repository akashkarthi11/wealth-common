package com.wealth.common.model.dto.sms;

import java.io.Serializable;

// One linked phone. The token is filled only in the answer to the link call and is never shown again; the list never carries it.
public class SmsDeviceDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String label;
	private String token;
	private String createdAt;
	private String lastSeenAt;
	private int lastRead;
	private int lastSaved;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getLastSeenAt() {
		return lastSeenAt;
	}

	public void setLastSeenAt(String lastSeenAt) {
		this.lastSeenAt = lastSeenAt;
	}

	public int getLastRead() {
		return lastRead;
	}

	public void setLastRead(int lastRead) {
		this.lastRead = lastRead;
	}

	public int getLastSaved() {
		return lastSaved;
	}

	public void setLastSaved(int lastSaved) {
		this.lastSaved = lastSaved;
	}
}
