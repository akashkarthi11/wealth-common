package com.wealth.common.model.dto.account;

import java.io.Serializable;
import java.util.List;

public class AccountsOverviewDto implements Serializable {

	private static final long serialVersionUID = 1L;

	// When these totals were read from the database (the nexus cache); stale = older than the refresh time.
	private java.sql.Timestamp fetchedAt;
	private boolean stale;

	private AccountTotalsDto totals;
	private List<BankDto> banks;
	// Accounts valued by their holdings (demat, funds, digital gold ...): not banks, listed here so a holding can be added to them.
	private List<AccountDto> investmentAccounts = new java.util.ArrayList<>();

	public List<AccountDto> getInvestmentAccounts() {
		return investmentAccounts;
	}

	public void setInvestmentAccounts(List<AccountDto> investmentAccounts) {
		this.investmentAccounts = investmentAccounts;
	}

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

	public java.sql.Timestamp getFetchedAt() {
		return fetchedAt;
	}

	public void setFetchedAt(java.sql.Timestamp fetchedAt) {
		this.fetchedAt = fetchedAt;
	}

	public boolean isStale() {
		return stale;
	}

	public void setStale(boolean stale) {
		this.stale = stale;
	}
}
