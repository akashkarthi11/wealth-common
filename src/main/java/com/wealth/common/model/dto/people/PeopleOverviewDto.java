package com.wealth.common.model.dto.people;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PeopleOverviewDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String asOf;
	private PeopleTotalsDto totals;
	private List<LendRequestDto> requests = new ArrayList<>();
	private List<PersonDto> people = new ArrayList<>();
	private List<BillSplitDto> splits = new ArrayList<>();
	private List<SuggestionDto> suggestions = new ArrayList<>();
	private Timestamp fetchedAt;
	private boolean stale;

	public String getAsOf() {
		return asOf;
	}

	public void setAsOf(String asOf) {
		this.asOf = asOf;
	}

	public PeopleTotalsDto getTotals() {
		return totals;
	}

	public void setTotals(PeopleTotalsDto totals) {
		this.totals = totals;
	}

	public List<LendRequestDto> getRequests() {
		return requests;
	}

	public void setRequests(List<LendRequestDto> requests) {
		this.requests = requests;
	}

	public List<PersonDto> getPeople() {
		return people;
	}

	public void setPeople(List<PersonDto> people) {
		this.people = people;
	}

	public List<BillSplitDto> getSplits() {
		return splits;
	}

	public void setSplits(List<BillSplitDto> splits) {
		this.splits = splits;
	}

	public List<SuggestionDto> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<SuggestionDto> suggestions) {
		this.suggestions = suggestions;
	}

	public Timestamp getFetchedAt() {
		return fetchedAt;
	}

	public void setFetchedAt(Timestamp fetchedAt) {
		this.fetchedAt = fetchedAt;
	}

	public boolean isStale() {
		return stale;
	}

	public void setStale(boolean stale) {
		this.stale = stale;
	}
}
