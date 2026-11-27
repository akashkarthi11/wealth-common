package com.wealth.common.model.dto.invest;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

// A holding added or corrected by hand (an investment that cannot be fetched: a mutual fund, digital gold ...). The same account and symbol again replaces the quantity,
// the invested value and the price.
public class HoldingSaveRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String accountId;
	// indian_equity, indian_mutual_fund, us_equity, us_etf or precious_metal; it must fit the account's type.
	private String assetClass;
	private String name;
	// Empty: made from the name.
	private String symbol;
	// share, unit or g (grams).
	private String unit;
	private BigDecimal quantity;
	private BigDecimal investedValue;
	// Empty: now. Not in the future.
	private Timestamp asOf;
	// The price of one unit on that day, in the account's currency; it is what the holding is valued with.
	private BigDecimal price;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAssetClass() {
		return assetClass;
	}

	public void setAssetClass(String assetClass) {
		this.assetClass = assetClass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getInvestedValue() {
		return investedValue;
	}

	public void setInvestedValue(BigDecimal investedValue) {
		this.investedValue = investedValue;
	}

	public Timestamp getAsOf() {
		return asOf;
	}

	public void setAsOf(Timestamp asOf) {
		this.asOf = asOf;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
