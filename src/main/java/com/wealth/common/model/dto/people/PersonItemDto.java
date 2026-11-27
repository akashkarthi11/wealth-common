package com.wealth.common.model.dto.people;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PersonItemDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String type;
	private String direction;
	private BigDecimal amount;
	private String on;
	private String transactionId;
	private String entryId;
	private String splitId;
	private String shareId;
	private String rollupId;
	private boolean writtenOff;
	private String label;
	private String detail;
	private String note;
	private List<LendCommentDto> comments = new ArrayList<>();
	private String account;
	private boolean paid;
	private String paidOn;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getOn() {
		return on;
	}

	public void setOn(String on) {
		this.on = on;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getEntryId() {
		return entryId;
	}

	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}

	public String getSplitId() {
		return splitId;
	}

	public void setSplitId(String splitId) {
		this.splitId = splitId;
	}

	public String getShareId() {
		return shareId;
	}

	public void setShareId(String shareId) {
		this.shareId = shareId;
	}

	public String getRollupId() {
		return rollupId;
	}

	public void setRollupId(String rollupId) {
		this.rollupId = rollupId;
	}

	public boolean isWrittenOff() {
		return writtenOff;
	}

	public void setWrittenOff(boolean writtenOff) {
		this.writtenOff = writtenOff;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<LendCommentDto> getComments() {
		return comments;
	}

	public void setComments(List<LendCommentDto> comments) {
		this.comments = comments;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public String getPaidOn() {
		return paidOn;
	}

	public void setPaidOn(String paidOn) {
		this.paidOn = paidOn;
	}
}
