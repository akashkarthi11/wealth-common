package com.wealth.common.model.dto.people;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BillSplitDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String transactionId;
	private String title;
	private String on;
	private BigDecimal total;
	private BigDecimal tax;
	private String mode;
	private BigDecimal myShare;
	private BigDecimal othersOwe;
	private List<SplitShareDto> shares = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOn() {
		return on;
	}

	public void setOn(String on) {
		this.on = on;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public BigDecimal getMyShare() {
		return myShare;
	}

	public void setMyShare(BigDecimal myShare) {
		this.myShare = myShare;
	}

	public BigDecimal getOthersOwe() {
		return othersOwe;
	}

	public void setOthersOwe(BigDecimal othersOwe) {
		this.othersOwe = othersOwe;
	}

	public List<SplitShareDto> getShares() {
		return shares;
	}

	public void setShares(List<SplitShareDto> shares) {
		this.shares = shares;
	}
}
