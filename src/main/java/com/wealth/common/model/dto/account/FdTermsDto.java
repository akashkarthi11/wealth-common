package com.wealth.common.model.dto.account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FdTermsDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal principal;
	private Date bookedOn;
	private Date maturityOn;
	private String payout;
	private String compounding;

	public BigDecimal getPrincipal() {
		return principal;
	}

	public void setPrincipal(BigDecimal principal) {
		this.principal = principal;
	}

	public Date getBookedOn() {
		return bookedOn;
	}

	public void setBookedOn(Date bookedOn) {
		this.bookedOn = bookedOn;
	}

	public Date getMaturityOn() {
		return maturityOn;
	}

	public void setMaturityOn(Date maturityOn) {
		this.maturityOn = maturityOn;
	}

	public String getPayout() {
		return payout;
	}

	public void setPayout(String payout) {
		this.payout = payout;
	}

	public String getCompounding() {
		return compounding;
	}

	public void setCompounding(String compounding) {
		this.compounding = compounding;
	}
}
