package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// Where Google sends the browser back to (the UI callback page). Google only accepts an address registered on the OAuth client.
public class GmailConnectRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String redirectUri;

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}
}
