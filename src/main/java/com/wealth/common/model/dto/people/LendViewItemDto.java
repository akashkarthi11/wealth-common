package com.wealth.common.model.dto.people;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// One line on the public page: what and when, the amount, and the remarks. entryId or shareId lets the person remark on it. No account, no transfer text.
public class LendViewItemDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String entryId;
	private String shareId;
	private String on;
	private String label;
	private BigDecimal amount;
	private String direction;
	private boolean writtenOff;
	private String note;
	private Boolean paid;
	private List<LendCommentDto> comments = new ArrayList<>();

	public String getEntryId() {
		return entryId;
	}

	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}

	public String getShareId() {
		return shareId;
	}

	public void setShareId(String shareId) {
		this.shareId = shareId;
	}

	public String getOn() {
		return on;
	}

	public void setOn(String on) {
		this.on = on;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public boolean isWrittenOff() {
		return writtenOff;
	}

	public void setWrittenOff(boolean writtenOff) {
		this.writtenOff = writtenOff;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public List<LendCommentDto> getComments() {
		return comments;
	}

	public void setComments(List<LendCommentDto> comments) {
		this.comments = comments;
	}
}
