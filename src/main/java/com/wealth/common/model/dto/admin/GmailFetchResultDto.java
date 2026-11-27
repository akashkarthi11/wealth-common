package com.wealth.common.model.dto.admin;

import java.io.Serializable;
import java.util.List;

// What one Gmail read did: the bank alert emails read, the transactions added to the review list, the ones already there, and the emails that were not a transaction alert.
// balancesSeen lists balances that an alert states (for example "slice ••3731: ₹40,535.49 on 18-Nov-26"); they are shown, never saved as the account balance.
public class GmailFetchResultDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int read;
	private int added;
	private int duplicates;
	private int skipped;
	// Alerts sent to the Data quality screen because they look like a duplicate or fake (not stored until the user decides).
	private int review;

	public int getReview() {
		return review;
	}

	public void setReview(int review) {
		this.review = review;
	}
	private List<String> balancesSeen;

	public int getRead() {
		return read;
	}

	public void setRead(int read) {
		this.read = read;
	}

	public int getAdded() {
		return added;
	}

	public void setAdded(int added) {
		this.added = added;
	}

	public int getDuplicates() {
		return duplicates;
	}

	public void setDuplicates(int duplicates) {
		this.duplicates = duplicates;
	}

	public int getSkipped() {
		return skipped;
	}

	public void setSkipped(int skipped) {
		this.skipped = skipped;
	}

	public List<String> getBalancesSeen() {
		return balancesSeen;
	}

	public void setBalancesSeen(List<String> balancesSeen) {
		this.balancesSeen = balancesSeen;
	}
}
