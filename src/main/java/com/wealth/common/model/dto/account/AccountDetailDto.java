package com.wealth.common.model.dto.account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class AccountDetailDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private AccountDto account;
	private List<AccountBalanceDto> balances;
	private BigDecimal monthIn;
	private BigDecimal monthOut;
	private List<AccountSplitDto> splits;

	public AccountDto getAccount() {
		return account;
	}

	public void setAccount(AccountDto account) {
		this.account = account;
	}

	public List<AccountBalanceDto> getBalances() {
		return balances;
	}

	public void setBalances(List<AccountBalanceDto> balances) {
		this.balances = balances;
	}

	public BigDecimal getMonthIn() {
		return monthIn;
	}

	public void setMonthIn(BigDecimal monthIn) {
		this.monthIn = monthIn;
	}

	public BigDecimal getMonthOut() {
		return monthOut;
	}

	public void setMonthOut(BigDecimal monthOut) {
		this.monthOut = monthOut;
	}

	public List<AccountSplitDto> getSplits() {
		return splits;
	}

	public void setSplits(List<AccountSplitDto> splits) {
		this.splits = splits;
	}
}
