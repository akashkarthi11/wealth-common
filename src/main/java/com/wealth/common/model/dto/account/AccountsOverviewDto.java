package com.wealth.common.model.dto.account;

import java.io.Serializable;
import java.util.List;

public class AccountsOverviewDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private AccountTotalsDto totals;
	private List<BankDto> banks;

	public AccountTotalsDto getTotals() {
		return totals;
	}

	public void setTotals(AccountTotalsDto totals) {
		this.totals = totals;
	}

	public List<BankDto> getBanks() {
		return banks;
	}

	public void setBanks(List<BankDto> banks) {
		this.banks = banks;
	}
}
