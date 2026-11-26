package com.wealth.common.model.dto.account;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountTotalsDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal casa;
	private BigDecimal investment;
	private BigDecimal liability;
	private BigDecimal netWorth;

	public BigDecimal getCasa() {
		return casa;
	}

	public void setCasa(BigDecimal casa) {
		this.casa = casa;
	}

	public BigDecimal getInvestment() {
		return investment;
	}

	public void setInvestment(BigDecimal investment) {
		this.investment = investment;
	}

	public BigDecimal getLiability() {
		return liability;
	}

	public void setLiability(BigDecimal liability) {
		this.liability = liability;
	}

	public BigDecimal getNetWorth() {
		return netWorth;
	}

	public void setNetWorth(BigDecimal netWorth) {
		this.netWorth = netWorth;
	}
}
