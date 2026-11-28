package com.wealth.common.model.dto.transaction;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// The dashboard for the transactions the filters select (all of them, not one page): what came in and went out, the net, the count, and the same split by category, by account
// and by month (month is yyyy-MM, oldest first). Transfers, copies and dismissed entries are left out, as in the list. byAccount is largest outgoing first, at most 8.
// byCategory holds the biggest 12 categories of each kind (kind on every row); byKind has one row per kind with its totals.
public class TransactionSummaryDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal incoming = BigDecimal.ZERO;
	private BigDecimal outgoing = BigDecimal.ZERO;
	private BigDecimal net = BigDecimal.ZERO;
	private int count;
	private List<TransactionSummaryItemDto> byCategory = new ArrayList<>();
	private List<TransactionSummaryItemDto> byAccount = new ArrayList<>();
	private List<TransactionSummaryItemDto> byKind = new ArrayList<>();
	private List<TransactionSummaryItemDto> byMonth = new ArrayList<>();

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

	public BigDecimal getNet() {
		return net;
	}

	public void setNet(BigDecimal net) {
		this.net = net;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<TransactionSummaryItemDto> getByCategory() {
		return byCategory;
	}

	public void setByCategory(List<TransactionSummaryItemDto> byCategory) {
		this.byCategory = byCategory;
	}

	public List<TransactionSummaryItemDto> getByAccount() {
		return byAccount;
	}

	public void setByAccount(List<TransactionSummaryItemDto> byAccount) {
		this.byAccount = byAccount;
	}

	public List<TransactionSummaryItemDto> getByKind() {
		return byKind;
	}

	public void setByKind(List<TransactionSummaryItemDto> byKind) {
		this.byKind = byKind;
	}

	public List<TransactionSummaryItemDto> getByMonth() {
		return byMonth;
	}

	public void setByMonth(List<TransactionSummaryItemDto> byMonth) {
		this.byMonth = byMonth;
	}
}
