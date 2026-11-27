package com.wealth.common.model.dto.transaction;

import java.io.Serializable;

// What importing bank lines did: stored as transactions straight away, matched a transaction that is already there (nothing stored), sent to review because they look like a duplicate or fake, or already imported before.
public class BankImportResultDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int stored;
	private int same;
	private int review;
	private int repeated;

	public int getStored() {
		return stored;
	}

	public void setStored(int stored) {
		this.stored = stored;
	}

	public int getSame() {
		return same;
	}

	public void setSame(int same) {
		this.same = same;
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
}
