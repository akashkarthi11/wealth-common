package com.wealth.common.model.dto.account;

import java.io.Serializable;
import java.util.List;

public class BankDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private AccountTotalsDto totals;
	private List<AccountDto> accounts;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AccountTotalsDto getTotals() {
		return totals;
	}

	public void setTotals(AccountTotalsDto totals) {
		this.totals = totals;
	}

	public List<AccountDto> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountDto> accounts) {
		this.accounts = accounts;
	}
}
