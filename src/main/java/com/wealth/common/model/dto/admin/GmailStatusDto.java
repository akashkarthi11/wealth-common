package com.wealth.common.model.dto.admin;

import java.io.Serializable;
import java.sql.Timestamp;

// The caller's Gmail connection for the Connections screen. The tokens and the Google client secret are never here; the email is masked.
public class GmailStatusDto implements Serializable {

	private static final long serialVersionUID = 1L;

	// The Google client id and secret are saved and the service is on, so a user can connect.
	private boolean appConfigured;
	// The labels of the extra statement passwords the user added (never the passwords).
	private java.util.List<String> extraLabels = new java.util.ArrayList<>();
	// How far back (days) and how many mails a read looks at, set in Connections > Common; null until the Google client is set up.
	// The start of the saved Google client id followed by dots, for an admin only; never the whole id or the secret.
	private String clientIdMasked;
	private Integer statementDays;
	private Integer statementMax;
	private Integer alertDays;
	private boolean connected;
	private String email;
	// "ok" or "failed" from the last read or test, null when never checked.
	private String status;
	private Timestamp checkedAt;
	// The PAN and date of birth (the statement passwords) are saved. Never the values.
	private boolean statementPasswordsSet;
	// Which of the two is saved (never the values): the PAN, and the date of birth.
	private boolean panSaved;
	// What the last read found, kept for next time (shown for reference; none of it is added to any balance): the balances in the bank alerts and the figures in the
	// statements, each with when it was read. Empty before the first read.
	private java.util.List<String> lastBalances = new java.util.ArrayList<>();
	private Timestamp lastBalancesAt;
	private java.util.List<String> lastFigures = new java.util.ArrayList<>();
	private Timestamp lastFiguresAt;
	private int lastStatementsOpened;
	private int lastStatementsLocked;

	public java.util.List<String> getLastBalances() {
		return lastBalances;
	}

	public void setLastBalances(java.util.List<String> lastBalances) {
		this.lastBalances = lastBalances;
	}

	public Timestamp getLastBalancesAt() {
		return lastBalancesAt;
	}

	public void setLastBalancesAt(Timestamp lastBalancesAt) {
		this.lastBalancesAt = lastBalancesAt;
	}

	public java.util.List<String> getLastFigures() {
		return lastFigures;
	}

	public void setLastFigures(java.util.List<String> lastFigures) {
		this.lastFigures = lastFigures;
	}

	public Timestamp getLastFiguresAt() {
		return lastFiguresAt;
	}

	public void setLastFiguresAt(Timestamp lastFiguresAt) {
		this.lastFiguresAt = lastFiguresAt;
	}

	public int getLastStatementsOpened() {
		return lastStatementsOpened;
	}

	public void setLastStatementsOpened(int lastStatementsOpened) {
		this.lastStatementsOpened = lastStatementsOpened;
	}

	public int getLastStatementsLocked() {
		return lastStatementsLocked;
	}

	public void setLastStatementsLocked(int lastStatementsLocked) {
		this.lastStatementsLocked = lastStatementsLocked;
	}
	private boolean dobSaved;
	private boolean nameSaved;

	public boolean isNameSaved() {
		return nameSaved;
	}

	public void setNameSaved(boolean nameSaved) {
		this.nameSaved = nameSaved;
	}

	public boolean isPanSaved() {
		return panSaved;
	}

	public void setPanSaved(boolean panSaved) {
		this.panSaved = panSaved;
	}

	public boolean isDobSaved() {
		return dobSaved;
	}

	public void setDobSaved(boolean dobSaved) {
		this.dobSaved = dobSaved;
	}

	public boolean isStatementPasswordsSet() {
		return statementPasswordsSet;
	}

	public void setStatementPasswordsSet(boolean statementPasswordsSet) {
		this.statementPasswordsSet = statementPasswordsSet;
	}

	public String getClientIdMasked() {
		return clientIdMasked;
	}

	public void setClientIdMasked(String clientIdMasked) {
		this.clientIdMasked = clientIdMasked;
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

	public java.util.List<String> getExtraLabels() {
		return extraLabels;
	}

	public void setExtraLabels(java.util.List<String> extraLabels) {
		this.extraLabels = extraLabels;
	}

	public boolean isAppConfigured() {
		return appConfigured;
	}

	public void setAppConfigured(boolean appConfigured) {
		this.appConfigured = appConfigured;
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCheckedAt() {
		return checkedAt;
	}

	public void setCheckedAt(Timestamp checkedAt) {
		this.checkedAt = checkedAt;
	}
}
