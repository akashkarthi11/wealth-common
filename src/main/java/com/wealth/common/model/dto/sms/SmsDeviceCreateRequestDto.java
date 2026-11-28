package com.wealth.common.model.dto.sms;

import java.io.Serializable;

// Links a phone: the name the user gives it (for example "My OnePlus").
public class SmsDeviceCreateRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
