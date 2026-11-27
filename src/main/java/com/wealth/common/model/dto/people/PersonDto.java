package com.wealth.common.model.dto.people;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PersonDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String kind;
	private Timestamp sharedSince;
	private boolean hidden;
	private List<String> aliases = new ArrayList<>();
	private List<UnlinkedDto> unlinked = new ArrayList<>();
	private int unlinkedCount;
	private int requests;
	private String dueOn;
	private BigDecimal annualRate;
	private String status;
	private String note;
	private BigDecimal lent;
	private BigDecimal repaid;
	private BigDecimal interest;
	private BigDecimal owed;
	private BigDecimal overpaid;
	private String lastMovement;
	private boolean overdue;
	private int bills;
	private int unpaidShares;
	private BigDecimal writtenOff;
	private boolean history;
	private List<PersonItemDto> items = new ArrayList<>();
	private List<PersonRollupDto> rollups = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Timestamp getSharedSince() {
		return sharedSince;
	}

	public void setSharedSince(Timestamp sharedSince) {
		this.sharedSince = sharedSince;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public List<String> getAliases() {
		return aliases;
	}

	public void setAliases(List<String> aliases) {
		this.aliases = aliases;
	}

	public List<UnlinkedDto> getUnlinked() {
		return unlinked;
	}

	public void setUnlinked(List<UnlinkedDto> unlinked) {
		this.unlinked = unlinked;
	}

	public int getUnlinkedCount() {
		return unlinkedCount;
	}

	public void setUnlinkedCount(int unlinkedCount) {
		this.unlinkedCount = unlinkedCount;
	}

	public int getRequests() {
		return requests;
	}

	public void setRequests(int requests) {
		this.requests = requests;
	}

	public String getDueOn() {
		return dueOn;
	}

	public void setDueOn(String dueOn) {
		this.dueOn = dueOn;
	}

	public BigDecimal getAnnualRate() {
		return annualRate;
	}

	public void setAnnualRate(BigDecimal annualRate) {
		this.annualRate = annualRate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public BigDecimal getLent() {
		return lent;
	}

	public void setLent(BigDecimal lent) {
		this.lent = lent;
	}

	public BigDecimal getRepaid() {
		return repaid;
	}

	public void setRepaid(BigDecimal repaid) {
		this.repaid = repaid;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	public BigDecimal getOwed() {
		return owed;
	}

	public void setOwed(BigDecimal owed) {
		this.owed = owed;
	}

	public BigDecimal getOverpaid() {
		return overpaid;
	}

	public void setOverpaid(BigDecimal overpaid) {
		this.overpaid = overpaid;
	}

	public String getLastMovement() {
		return lastMovement;
	}

	public void setLastMovement(String lastMovement) {
		this.lastMovement = lastMovement;
	}

	public boolean isOverdue() {
		return overdue;
	}

	public void setOverdue(boolean overdue) {
		this.overdue = overdue;
	}

	public int getBills() {
		return bills;
	}

	public void setBills(int bills) {
		this.bills = bills;
	}

	public int getUnpaidShares() {
		return unpaidShares;
	}

	public void setUnpaidShares(int unpaidShares) {
		this.unpaidShares = unpaidShares;
	}

	public BigDecimal getWrittenOff() {
		return writtenOff;
	}

	public void setWrittenOff(BigDecimal writtenOff) {
		this.writtenOff = writtenOff;
	}

	public boolean isHistory() {
		return history;
	}

	public void setHistory(boolean history) {
		this.history = history;
	}

	public List<PersonItemDto> getItems() {
		return items;
	}

	public void setItems(List<PersonItemDto> items) {
		this.items = items;
	}

	public List<PersonRollupDto> getRollups() {
		return rollups;
	}

	public void setRollups(List<PersonRollupDto> rollups) {
		this.rollups = rollups;
	}
}
