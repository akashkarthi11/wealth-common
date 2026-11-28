package com.wealth.common.model.dto.people;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// Money lent to or paid back by one person: link the suggested or chosen transfers (transactionIds: sent = lent, received = paid back) or enter an amount by hand (direction + amount). The person is personId, or a name that is added when new. dryRun stores nothing.
public class PersonEntryRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String personId;
	private String name;
	private List<String> transactionIds = new ArrayList<>();
	private String direction;
	private BigDecimal amount;
	private String occurredOn;
	private String note;
	private Boolean dryRun;

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getTransactionIds() {
		return transactionIds;
	}

	public void setTransactionIds(List<String> transactionIds) {
		this.transactionIds = transactionIds;
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

	public String getOccurredOn() {
		return occurredOn;
	}

	public void setOccurredOn(String occurredOn) {
		this.occurredOn = occurredOn;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getDryRun() {
		return dryRun;
	}

	public void setDryRun(Boolean dryRun) {
		this.dryRun = dryRun;
	}
}
