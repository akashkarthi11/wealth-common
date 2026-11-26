package com.wealth.common.model.dto.invest;

import java.math.BigDecimal;
import java.util.List;
import java.io.Serializable;

public class InvestmentsDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal invested;
	private BigDecimal currentValue;
	private BigDecimal gain;
	private BigDecimal gainPercent;
	private int holdingCount;
	private int unpricedCount;
	private List<HoldingDto> holdings;

	public BigDecimal getInvested() {
		return invested;
	}

	public void setInvested(BigDecimal invested) {
		this.invested = invested;
	}

	public BigDecimal getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(BigDecimal currentValue) {
		this.currentValue = currentValue;
	}

	public BigDecimal getGain() {
		return gain;
	}

	public void setGain(BigDecimal gain) {
		this.gain = gain;
	}

	public BigDecimal getGainPercent() {
		return gainPercent;
	}

	public void setGainPercent(BigDecimal gainPercent) {
		this.gainPercent = gainPercent;
	}

	public int getHoldingCount() {
		return holdingCount;
	}

	public void setHoldingCount(int holdingCount) {
		this.holdingCount = holdingCount;
	}

	public int getUnpricedCount() {
		return unpricedCount;
	}

	public void setUnpricedCount(int unpricedCount) {
		this.unpricedCount = unpricedCount;
	}

	public List<HoldingDto> getHoldings() {
		return holdings;
	}

	public void setHoldings(List<HoldingDto> holdings) {
		this.holdings = holdings;
	}
}
