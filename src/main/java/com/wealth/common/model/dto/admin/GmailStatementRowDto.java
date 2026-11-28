package com.wealth.common.model.dto.admin;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;

// One statement read from Gmail for the Statements table: where it came from (the file name, long digit runs hidden), when it was read, and its figures as label to value
// (for example "Total Amount Due" to "₹830.00"). Each bank has different labels, so the screen builds its columns from whatever labels the rows carry.
public class GmailStatementRowDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String source;
	private Timestamp receivedAt;
	private Timestamp readAt;
	private Map<String, String> figures = new LinkedHashMap<>();
	// So the table can offer Accept: the statement's id, how many transaction rows it kept, and when the user accepted them (null = not yet).
	private String id;
	private int rowCount;
	private Timestamp acceptedAt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
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
