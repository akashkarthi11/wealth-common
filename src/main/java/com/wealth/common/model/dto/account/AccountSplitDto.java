package com.wealth.common.model.dto.account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class AccountSplitDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String splitKey;
	private String name;
	private String kind;
	private BigDecimal goalAmount;
	private String purpose;
	private Integer sortOrder;
	private BigDecimal estimatedBalance;
	private String balanceStatus;
	private Timestamp balanceAsOf;
	private List<SplitMoveDto> moves;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSplitKey() {
		return splitKey;
	}

	public void setSplitKey(String splitKey) {
		this.splitKey = splitKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public BigDecimal getGoalAmount() {
		return goalAmount;
	}

	public void setGoalAmount(BigDecimal goalAmount) {
		this.goalAmount = goalAmount;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public BigDecimal getEstimatedBalance() {
		return estimatedBalance;
	}

	public void setEstimatedBalance(BigDecimal estimatedBalance) {
		this.estimatedBalance = estimatedBalance;
	}

	public String getBalanceStatus() {
		return balanceStatus;
	}

	public void setBalanceStatus(String balanceStatus) {
		this.balanceStatus = balanceStatus;
	}

	public Timestamp getBalanceAsOf() {
		return balanceAsOf;
	}

	public void setBalanceAsOf(Timestamp balanceAsOf) {
		this.balanceAsOf = balanceAsOf;
	}

	public List<SplitMoveDto> getMoves() {
		return moves;
	}

	public void setMoves(List<SplitMoveDto> moves) {
		this.moves = moves;
	}
}
