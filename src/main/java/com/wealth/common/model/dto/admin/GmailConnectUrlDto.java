package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// The Google consent page the browser is sent to.
public class GmailConnectUrlDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
