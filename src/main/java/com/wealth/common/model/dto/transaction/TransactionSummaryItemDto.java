package com.wealth.common.model.dto.transaction;

import java.io.Serializable;
import java.math.BigDecimal;

// One slice of the dashboard: a category or an account with what came in and went out, and how many transactions.
public class TransactionSummaryItemDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String label;
	// The transaction kind of a category or kind row (expense, income, investment, liability); null in the account and month rows.
	private String kind;
	private BigDecimal incoming = BigDecimal.ZERO;
	private BigDecimal outgoing = BigDecimal.ZERO;
	private int count;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public BigDecimal getIncoming() {
		return incoming;
	}

	public void setIncoming(BigDecimal incoming) {
		this.incoming = incoming;
	}

	public BigDecimal getOutgoing() {
		return outgoing;
	}

	public void setOutgoing(BigDecimal outgoing) {
		this.outgoing = outgoing;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
