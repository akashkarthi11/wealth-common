package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// The passwords bank statement PDFs are locked with: pan (ABCDE1234F) and dob (DDMMYYYY). A blank value keeps the saved one.
public class GmailStatementSettingsRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String pan;
	private String dob;
	// The first four letters of the name: HDFC card statements are locked with these (capitals) and the day and month of birth (DDMM).
	private String name4;

	public String getName4() {
		return name4;
	}

	public void setName4(String name4) {
		this.name4 = name4;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
}
