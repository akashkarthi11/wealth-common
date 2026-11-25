package com.wealth.common.model.dto.master;

import java.io.Serializable;

import jakarta.persistence.Transient;
import lombok.Data;

@Data
public class BankDataDTO  implements Serializable {

	@Transient
	private static final long serialVersionUID = -3411024802085772179L;
	
	private int bankId;
	private int compBankId;
    private String bankName;
    private String bankCode;
    private String bankColourCode;
    private String logoName;
    private String logoPath;
	private int menuId;
    private int permissionId;
}
