package com.wealth.common.model.dto.people;

import java.io.Serializable;

// Whether the person is shared now; path is the link (/l/<secret>), returned only when it is made: the secret is never kept, only its hash.
public class ShareUpdateResultDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean shared;
	private String path;

	public boolean isShared() {
		return shared;
	}

	public void setShared(boolean shared) {
		this.shared = shared;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
