package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// Where the user's Gmail read is. stage: idle (nothing started yet), queued, reading_alerts, reading_statements, done or failed. inProgress is true while the stage is queued, reading_alerts or reading_statements.
// A read that has not moved for a few minutes counts as failed ("stopped"). alerts and statements hold what the last read of each found.
public class GmailSyncStatusDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String kind;
	private String stage;
	private boolean inProgress;
	private String note;
	private String startedAt;
	private String updatedAt;
	private GmailFetchResultDto alerts;
	private GmailStatementResultDto statements;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public boolean isInProgress() {
		return inProgress;
	}

	public void setInProgress(boolean inProgress) {
		this.inProgress = inProgress;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(String startedAt) {
		this.startedAt = startedAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public GmailFetchResultDto getAlerts() {
		return alerts;
	}

	public void setAlerts(GmailFetchResultDto alerts) {
		this.alerts = alerts;
	}

	public GmailStatementResultDto getStatements() {
		return statements;
	}

	public void setStatements(GmailStatementResultDto statements) {
		this.statements = statements;
	}
}
