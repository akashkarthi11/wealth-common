package com.wealth.common.model.dto.admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// What one statement read did: the statement mails found, the PDFs that opened, the PDFs that stayed locked (wrong or missing password), and the labelled figures read
// from the opened ones (for example "slice statement Oct 2026: Closing Balance ₹40,000.00"). The figures are shown to be checked and are never saved.
public class GmailStatementResultDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int read;
	private int opened;
	private int locked;
	// The transaction lines read from the opened statements: how many were stored as transactions, matched one that was already there, were sent to the Data quality screen
	// (they look like a duplicate or the reader was not sure), and were already read before. Every line is one of these four.
	private int stored;
	private int matched;
	private int review;
	private int repeated;
	// The transaction rows read from the opened statements in this read. They are kept with the statement and saved as transactions only when the user accepts the statement.
	private int rows;

	// How many of the statements with no known row layout were read by the AI provider (their personal details were hidden before sending).
	private int aiStatements;

	public int getAiStatements() {
		return aiStatements;
	}

	public void setAiStatements(int aiStatements) {
		this.aiStatements = aiStatements;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getStored() {
		return stored;
	}

	public void setStored(int stored) {
		this.stored = stored;
	}

	public int getMatched() {
		return matched;
	}

	public void setMatched(int matched) {
		this.matched = matched;
	}

	public int getReview() {
		return review;
	}

	public void setReview(int review) {
		this.review = review;
	}

	public int getRepeated() {
		return repeated;
	}

	public void setRepeated(int repeated) {
		this.repeated = repeated;
	}
	// The statements that stayed locked, by file name (long numbers hidden), so the user can tell which bank's password to check.
	private List<String> lockedNames = new ArrayList<>();

	public List<String> getLockedNames() {
		return lockedNames;
	}

	public void setLockedNames(List<String> lockedNames) {
		this.lockedNames = lockedNames;
	}
	private List<String> figures;

	public int getRead() {
		return read;
	}

	public void setRead(int read) {
		this.read = read;
	}

	public int getOpened() {
		return opened;
	}

	public void setOpened(int opened) {
		this.opened = opened;
	}

	public int getLocked() {
		return locked;
	}

	public void setLocked(int locked) {
		this.locked = locked;
	}

	public List<String> getFigures() {
		return figures;
	}

	public void setFigures(List<String> figures) {
		this.figures = figures;
	}
}
