package com.wealth.common.model.dto.admin;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

// One statement received from Gmail or uploaded. status: opened, locked (the saved passwords did not open it) or failed. origin: gmail or upload. figures are what was read from it (empty when it did not open).
public class StatementHistoryDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String fileName;
	private String origin;
	private String status;
	private Timestamp receivedAt;
	private Timestamp readAt;
	private Map<String, String> figures = new HashMap<>();
	// The transaction rows read from the statement and waiting for the user's Accept, and when they were accepted (null = not yet).
	private int rowCount;
	private Timestamp acceptedAt;

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public Timestamp getAcceptedAt() {
		return acceptedAt;
	}

	public void setAcceptedAt(Timestamp acceptedAt) {
		this.acceptedAt = acceptedAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getReceivedAt() {
		return receivedAt;
	}

	public void setReceivedAt(Timestamp receivedAt) {
		this.receivedAt = receivedAt;
	}

	public Timestamp getReadAt() {
		return readAt;
	}

	public void setReadAt(Timestamp readAt) {
		this.readAt = readAt;
	}

	public Map<String, String> getFigures() {
		return figures;
	}

	public void setFigures(Map<String, String> figures) {
		this.figures = figures;
	}
}
