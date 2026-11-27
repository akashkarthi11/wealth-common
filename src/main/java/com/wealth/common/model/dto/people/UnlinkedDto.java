package com.wealth.common.model.dto.people;

import java.io.Serializable;
import java.math.BigDecimal;

public class UnlinkedDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String direction;
	private BigDecimal amount;
	private String day;
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
