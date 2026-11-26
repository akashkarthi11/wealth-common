package com.wealth.common.model.dto.account;

import java.io.Serializable;

public class AccountCreateRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String subtype;
	private String institution;
	private String name;
	private String maskedIdentifier;
	private String currency;
	private FdTermsDto fdTerms;

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaskedIdentifier() {
		return maskedIdentifier;
	}

	public void setMaskedIdentifier(String maskedIdentifier) {
		this.maskedIdentifier = maskedIdentifier;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public FdTermsDto getFdTerms() {
		return fdTerms;
	}

	public void setFdTerms(FdTermsDto fdTerms) {
		this.fdTerms = fdTerms;
	}
}
