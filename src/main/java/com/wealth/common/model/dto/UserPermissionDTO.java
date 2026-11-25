package com.wealth.common.model.dto;

public class UserPermissionDTO {
	private int userId;
	private int groupSmeCompId;
	private int smeCompId;
	private String userType;
	private String userCode;
	private String uri;
	private String emailId;
	private String countryCode2;
	private String userSettingId;
	private String preferredLanguage;
	private String localeCode;
	private String loginPortal;
	
	public String getLoginPortal() {
		return loginPortal;
	}

	public void setLoginPortal(String loginPortal) {
		this.loginPortal = loginPortal;
	}

	private int permissionId;
	private String supportCountries;
	private String tenantId;



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCountryCode2() {
		return countryCode2;
	}

	public void setCountryCode2(String countryCode2) {
		this.countryCode2 = countryCode2;
	}

	public int getSmeCompId() {
		return smeCompId;
	}

	public void setSmeCompId(int smeCompId) {
		this.smeCompId = smeCompId;
	}
	
	
	public int getGroupSmeCompId() {
		return groupSmeCompId;
	}

	public void setGroupSmeCompId(int groupSmeCompId) {
		this.groupSmeCompId = groupSmeCompId;
	}
	

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserSettingId() {
		return userSettingId;
	}

	public void setUserSettingId(String userSettingId) {
		this.userSettingId = userSettingId;
	}

	public String getPreferredLanguage() {
		return preferredLanguage;
	}

	public void setPreferredLanguage(String preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}

	public String getLocaleCode() {
		return localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

	public String getSupportCountries() {
		return supportCountries;
	}

	public void setSupportCountries(String supportCountries) {
		this.supportCountries = supportCountries;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

}
