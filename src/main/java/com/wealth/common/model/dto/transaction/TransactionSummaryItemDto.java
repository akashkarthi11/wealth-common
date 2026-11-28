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
	// yyyy-MM on the rows the server reads per category and month; used to build the trend and not sent on.
	private String period;
	// A category's amount in each of the months of byMonth (oldest first; income for an income category, money out otherwise); empty in other rows.
	private java.util.List<BigDecimal> trend = new java.util.ArrayList<>();

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public java.util.List<BigDecimal> getTrend() {
		return trend;
	}

	public void setTrend(java.util.List<BigDecimal> trend) {
		this.trend = trend;
	}

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
