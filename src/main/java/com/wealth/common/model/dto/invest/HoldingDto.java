package com.wealth.common.model.dto.invest;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.io.Serializable;

public class HoldingDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String accountId;
	private String bankName;
	private String accountName;
	private String instrumentId;
	private String symbol;
	private String name;
	private String assetClass;
	private String unit;
	private String currency;
	private String priceSourceSymbol;
	private String isin;
	private String exchange;
	private String product;
	private BigDecimal t1Quantity;
	private BigDecimal collateralQuantity;
	private BigDecimal haircut;
	private BigDecimal brokerClose;
	private BigDecimal brokerPnl;
	private BigDecimal brokerPnlPercent;
	private BigDecimal quantity;
	private BigDecimal investedValue;
	private BigDecimal averagePrice;
	private BigDecimal price;
	private Timestamp priceAsOf;
	private String priceSource;
	private BigDecimal currentValue;
	private BigDecimal gain;
	private BigDecimal gainPercent;
	private Timestamp holdingAsOf;
	private String status;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAssetClass() {
		return assetClass;
	}

	public void setAssetClass(String assetClass) {
		this.assetClass = assetClass;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPriceSourceSymbol() {
		return priceSourceSymbol;
	}

	public void setPriceSourceSymbol(String priceSourceSymbol) {
		this.priceSourceSymbol = priceSourceSymbol;
	}

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public BigDecimal getT1Quantity() {
		return t1Quantity;
	}

	public void setT1Quantity(BigDecimal t1Quantity) {
		this.t1Quantity = t1Quantity;
	}

	public BigDecimal getCollateralQuantity() {
		return collateralQuantity;
	}

	public void setCollateralQuantity(BigDecimal collateralQuantity) {
		this.collateralQuantity = collateralQuantity;
	}

	public BigDecimal getHaircut() {
		return haircut;
	}

	public void setHaircut(BigDecimal haircut) {
		this.haircut = haircut;
	}

	public BigDecimal getBrokerClose() {
		return brokerClose;
	}

	public void setBrokerClose(BigDecimal brokerClose) {
		this.brokerClose = brokerClose;
	}

	public BigDecimal getBrokerPnl() {
		return brokerPnl;
	}

	public void setBrokerPnl(BigDecimal brokerPnl) {
		this.brokerPnl = brokerPnl;
	}

	public BigDecimal getBrokerPnlPercent() {
		return brokerPnlPercent;
	}

	public void setBrokerPnlPercent(BigDecimal brokerPnlPercent) {
		this.brokerPnlPercent = brokerPnlPercent;
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

	public BigDecimal getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(BigDecimal averagePrice) {
		this.averagePrice = averagePrice;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Timestamp getPriceAsOf() {
		return priceAsOf;
	}

	public void setPriceAsOf(Timestamp priceAsOf) {
		this.priceAsOf = priceAsOf;
	}

	public String getPriceSource() {
		return priceSource;
	}

	public void setPriceSource(String priceSource) {
		this.priceSource = priceSource;
	}

	public BigDecimal getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(BigDecimal currentValue) {
		this.currentValue = currentValue;
	}

	public BigDecimal getGain() {
		return gain;
	}

	public void setGain(BigDecimal gain) {
		this.gain = gain;
	}

	public BigDecimal getGainPercent() {
		return gainPercent;
	}

	public void setGainPercent(BigDecimal gainPercent) {
		this.gainPercent = gainPercent;
	}

	public Timestamp getHoldingAsOf() {
		return holdingAsOf;
	}

	public void setHoldingAsOf(Timestamp holdingAsOf) {
		this.holdingAsOf = holdingAsOf;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
