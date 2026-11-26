package com.wealth.common.model.dto.account;

import java.io.Serializable;

public class FdTermsRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String accountId;
	private FdTermsDto fdTerms;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public FdTermsDto getFdTerms() {
		return fdTerms;
	}

	public void setFdTerms(FdTermsDto fdTerms) {
		this.fdTerms = fdTerms;
	}
}
