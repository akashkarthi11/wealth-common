package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// What Google returned to the callback page: the one-time code and the state sent with the consent URL.
public class GmailFinishRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String code;
	private String state;
	private String redirectUri;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}
}
