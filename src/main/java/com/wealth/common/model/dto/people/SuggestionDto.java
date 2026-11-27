package com.wealth.common.model.dto.people;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SuggestionDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String person;
	private String key;
	private BigDecimal sent;
	private BigDecimal received;
	private boolean p2p;
	private String firstDay;
	private String lastDay;
	private List<UnlinkedDto> transactions = new ArrayList<>();

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public BigDecimal getSent() {
		return sent;
	}

	public void setSent(BigDecimal sent) {
		this.sent = sent;
	}

	public BigDecimal getReceived() {
		return received;
	}

	public void setReceived(BigDecimal received) {
		this.received = received;
	}

	public boolean isP2p() {
		return p2p;
	}

	public void setP2p(boolean p2p) {
		this.p2p = p2p;
	}

	public String getFirstDay() {
		return firstDay;
	}

	public void setFirstDay(String firstDay) {
		this.firstDay = firstDay;
	}

	public String getLastDay() {
		return lastDay;
	}

	public void setLastDay(String lastDay) {
		this.lastDay = lastDay;
	}

	public List<UnlinkedDto> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<UnlinkedDto> transactions) {
		this.transactions = transactions;
	}
}
