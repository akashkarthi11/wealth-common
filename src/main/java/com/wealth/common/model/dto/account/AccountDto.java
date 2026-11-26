package com.wealth.common.model.dto.account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class AccountDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String accountKey;
	private String bankName;
	private String accountName;
	private String subtypeCode;
	private String category;
	private String maskedIdentifier;
	private String currency;
	private String status;
	private BigDecimal balance;
	private Timestamp balanceAsOf;
	private String balanceStatus;
	private BigDecimal fdPrincipal;
	private Date fdBookedOn;
	private Date fdMaturityOn;
	private String fdPayout;
	private String fdCompounding;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountKey() {
		return accountKey;
	}

	public void setAccountKey(String accountKey) {
		this.accountKey = accountKey;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getSubtypeCode() {
		return subtypeCode;
	}

	public void setSubtypeCode(String subtypeCode) {
		this.subtypeCode = subtypeCode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Timestamp getBalanceAsOf() {
		return balanceAsOf;
	}

	public void setBalanceAsOf(Timestamp balanceAsOf) {
		this.balanceAsOf = balanceAsOf;
	}

	public String getBalanceStatus() {
		return balanceStatus;
	}

	public void setBalanceStatus(String balanceStatus) {
		this.balanceStatus = balanceStatus;
	}

	public BigDecimal getFdPrincipal() {
		return fdPrincipal;
	}

	public void setFdPrincipal(BigDecimal fdPrincipal) {
		this.fdPrincipal = fdPrincipal;
	}

	public Date getFdBookedOn() {
		return fdBookedOn;
	}

	public void setFdBookedOn(Date fdBookedOn) {
		this.fdBookedOn = fdBookedOn;
	}

	public Date getFdMaturityOn() {
		return fdMaturityOn;
	}

	public void setFdMaturityOn(Date fdMaturityOn) {
		this.fdMaturityOn = fdMaturityOn;
	}

	public String getFdPayout() {
		return fdPayout;
	}

	public void setFdPayout(String fdPayout) {
		this.fdPayout = fdPayout;
	}

	public String getFdCompounding() {
		return fdCompounding;
	}

	public void setFdCompounding(String fdCompounding) {
		this.fdCompounding = fdCompounding;
	}
}
