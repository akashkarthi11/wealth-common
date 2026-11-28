package com.wealth.common.model.dto.people;

import java.io.Serializable;
import java.math.BigDecimal;

// What marking a share paid did: already is "paid" when the share was paid before (nothing stored).
public class SharePaidResultDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean stored;
	private boolean dryRun;
	private String already;
	private BigDecimal amount;
	private String on;

	public boolean isStored() {
		return stored;
	}

	public void setStored(boolean stored) {
		this.stored = stored;
	}

	public boolean isDryRun() {
		return dryRun;
	}

	public void setDryRun(boolean dryRun) {
		this.dryRun = dryRun;
	}

	public String getAlready() {
		return already;
	}

	public void setAlready(String already) {
		this.already = already;
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
}
