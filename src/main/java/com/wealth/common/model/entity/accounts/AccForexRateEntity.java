package com.wealth.common.model.entity.accounts;

import java.math.BigDecimal;

import com.wealth.common.model.entity.GenericEntity;

import jakarta.persistence.Transient;
import lombok.Data;

@Data
public class AccForexRateEntity extends GenericEntity {
	@Transient
	private static final long serialVersionUID = 3001221796076830724L;

		private int forexRateId;

	    private String countryCode2;

	    private String debitCurrency;

	    private String creditCurrency;

	    private BigDecimal bidRate;

	    private BigDecimal offerRate;

	    private BigDecimal middleRate;

	    private Integer  bankId;

	    
		@Override
		public String tableName() {
			// TODO Auto-generated method stub
			return "GXACC_FOREX_RATE"; 
		}
		@Override
		public String primaryKey() {
			// TODO Auto-generated method stub
			return "forexRateId";
		}
	   
	
	
	

}
