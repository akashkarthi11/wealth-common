package com.wealth.common.model.dto.sms;

import java.io.Serializable;

// What was done with the messages: read, saved as transactions, already known, sent to Data quality review, and not a bank transaction.
public class SmsPushResultDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int read;
	private int saved;
	private int duplicates;
	private int review;
	private int skipped;

	public int getRead() {
		return read;
	}

	public void setRead(int read) {
		this.read = read;
	}

	public int getSaved() {
		return saved;
	}

	public void setSaved(int saved) {
		this.saved = saved;
	}

	public int getDuplicates() {
		return duplicates;
	}

	public void setDuplicates(int duplicates) {
		this.duplicates = duplicates;
	}

	public int getReview() {
		return review;
	}

	public void setReview(int review) {
		this.review = review;
	}

	public int getSkipped() {
		return skipped;
	}

	public void setSkipped(int skipped) {
		this.skipped = skipped;
	}
}
