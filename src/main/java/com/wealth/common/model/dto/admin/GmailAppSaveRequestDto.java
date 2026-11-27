package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// The Google OAuth client every user connects through (admin), and how far back and how many mails a read looks at. A blank client id or secret keeps the saved one; a missing number keeps the saved one.
public class GmailAppSaveRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String clientId;
	private String clientSecret;
	private Integer statementDays;
	private Integer statementMax;
	private Integer alertDays;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public Integer getStatementDays() {
		return statementDays;
	}

	public void setStatementDays(Integer statementDays) {
		this.statementDays = statementDays;
	}

	public Integer getStatementMax() {
		return statementMax;
	}

	public void setStatementMax(Integer statementMax) {
		this.statementMax = statementMax;
	}

	public Integer getAlertDays() {
		return alertDays;
	}

	public void setAlertDays(Integer alertDays) {
		this.alertDays = alertDays;
	}
}
