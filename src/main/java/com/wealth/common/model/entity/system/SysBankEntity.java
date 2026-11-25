package com.wealth.common.model.entity.system;

import com.wealth.common.model.entity.GenericEntity;

import jakarta.persistence.Transient;
import lombok.Data;
@Data
public class SysBankEntity extends GenericEntity {
	@Transient
	private static final long serialVersionUID = -5697345921461019458L;
	private int globalBankId;
    private String bankName;
    private String bankCode;
    private String bankSwiftCode;
    private String countryCode2;
    

	@Override
    public String tableName() {
        return "GXSYS_GLOBAL_BANK";
    }

    @Override
    public String primaryKey() {
        return "globalBankId";
    }
}
