package com.wealth.common.model.dto.people;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// What the person sees through their link: their own summary, lines and recent payment messages only, nothing about anyone else.
public class LendViewDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private BigDecimal owed;
	private BigDecimal lent;
	private BigDecimal repaid;
	private String status;
	private String asOf;
	private List<LendViewItemDto> items = new ArrayList<>();
	private List<LendViewRequestRowDto> requests = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getOwed() {
		return owed;
	}

	public void setOwed(BigDecimal owed) {
		this.owed = owed;
	}

	public BigDecimal getLent() {
		return lent;
	}

	public void setLent(BigDecimal lent) {
		this.lent = lent;
	}

	public BigDecimal getRepaid() {
		return repaid;
	}

	public void setRepaid(BigDecimal repaid) {
		this.repaid = repaid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAsOf() {
		return asOf;
	}

	public void setAsOf(String asOf) {
		this.asOf = asOf;
	}

	public List<LendViewItemDto> getItems() {
		return items;
	}

	public void setItems(List<LendViewItemDto> items) {
		this.items = items;
	}

	public List<LendViewRequestRowDto> getRequests() {
		return requests;
	}

	public void setRequests(List<LendViewRequestRowDto> requests) {
		this.requests = requests;
	}
}
