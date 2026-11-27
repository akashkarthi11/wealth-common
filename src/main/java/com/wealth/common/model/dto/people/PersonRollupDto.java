package com.wealth.common.model.dto.people;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PersonRollupDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String on;
	private BigDecimal totalOwed;
	private BigDecimal alreadyBack;
	private BigDecimal newAmount;
	private int closedItems;
	private String note;
	private List<PersonItemDto> items = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOn() {
		return on;
	}

	public void setOn(String on) {
		this.on = on;
	}

	public BigDecimal getTotalOwed() {
		return totalOwed;
	}

	public void setTotalOwed(BigDecimal totalOwed) {
		this.totalOwed = totalOwed;
	}

	public BigDecimal getAlreadyBack() {
		return alreadyBack;
	}

	public void setAlreadyBack(BigDecimal alreadyBack) {
		this.alreadyBack = alreadyBack;
	}

	public BigDecimal getNewAmount() {
		return newAmount;
	}

	public void setNewAmount(BigDecimal newAmount) {
		this.newAmount = newAmount;
	}

	public int getClosedItems() {
		return closedItems;
	}

	public void setClosedItems(int closedItems) {
		this.closedItems = closedItems;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<PersonItemDto> getItems() {
		return items;
	}

	public void setItems(List<PersonItemDto> items) {
		this.items = items;
	}
}
