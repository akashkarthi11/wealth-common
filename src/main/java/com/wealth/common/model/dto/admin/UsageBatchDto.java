package com.wealth.common.model.dto.admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// One report of the BFF's API usage to the BSS (service to service, with the shared service key): up to 500 names, counts since the last report.
public class UsageBatchDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<UsageCountDto> counts = new ArrayList<>();

	public List<UsageCountDto> getCounts() {
		return counts;
	}

	public void setCounts(List<UsageCountDto> counts) {
		this.counts = counts;
	}
}
