package com.wealth.common.model.dto.customer;

import java.io.Serializable;

// The user's own profile details. A blank text clears a value. dateFormat is short, numeric or iso; homeScreen is a menu key.
public class ProfileSaveRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String displayName;
	private String mobile;
	private String dateFormat;
	private String homeScreen;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getHomeScreen() {
		return homeScreen;
	}

	public void setHomeScreen(String homeScreen) {
		this.homeScreen = homeScreen;
	}
}
