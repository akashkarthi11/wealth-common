package com.wealth.common.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wealth.common.constants.CommonConstants;
import com.wealth.common.generic.BaseError;
import com.wealth.common.generic.GrowxException;
import com.wealth.common.logger.GrowxLogger;
import com.wealth.common.model.dto.UserPermissionDTO;
import com.wealth.common.model.dto.accounts.AccBankDetailDTO;
import com.wealth.common.model.dto.master.BankDataDTO;
import com.wealth.common.model.entity.GxsysApplicationConfig;
import com.wealth.common.model.entity.accounts.AccForexRateEntity;
import com.wealth.common.utils.generic.RequestHeaderUtil;

@Repository
public class CommonRepository {

    private final GrowxLogger logger = new GrowxLogger(this.getClass());
    protected final JdbcTemplate jdbcTemplate;

    @Value("${growx.appmaster-schema}")
    private String appMasterSchema;
    private final Map<String, GxsysApplicationConfig> schemaCache = new ConcurrentHashMap<>();

    public CommonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /* ===================== PERMISSION ===================== */

    public UserPermissionDTO getPermissionIdsByCompanyUserCode(String userCode, String url) {
        try {
            List<Map<String, Object>> rows =
                    jdbcTemplate.queryForList(
                            CommonConstants.GET_PERMISSION_IDS_BY_COMPANY_USER_CODE,
                            url, userCode
                    );
            return rows.isEmpty() ? null : mapPermission(rows);
        } catch (DataAccessException e) {
            throw new GrowxException(BaseError.PERMISSION_IDS_BY_USER_CODE, e);
        }
    }
    
    
    
//    public UserPermissionDTO getPermissionByCompUsers(String userCode) {
//        try {
//            List<Map<String, Object>> rows =
//                    jdbcTemplate.queryForList(
//                            CommonConstants.GET_PERMISSION_DATA_BY_COMPUSERCODE,
//                            userCode
//                    );
//            return rows.isEmpty() ? null : mapPermission(rows);
//        } catch (DataAccessException e) {
//            throw new GrowxException(BaseError.PERMISSION_IDS_BY_USER_CODE, e);
//        }
//    }
//    public UserPermissionDTO getPermissionDetailsByUri(String url) {
//        try {
//            List<Map<String, Object>> rows =
//                    jdbcTemplate.queryForList(
//                            CommonConstants.GET_PERMISSION_IDS_BY_URI,
//                            url
//                    );
//            return rows.isEmpty() ? null : mapPermission(rows);
//        } catch (DataAccessException e) {
//            throw new GrowxException(BaseError.PERMISSION_NOT_FOUND, e);
//        }
//    }
    public String getDistinctDenominationByCreditCurrency(String creditCurrency) {
        try {
            return jdbcTemplate.query(
                    CommonConstants.GET_DISTINCT_DENOMINATION_BY_CREDIT_CURRENCY,
                    (rs, rowNum) -> rs.getString(1),
                    creditCurrency,
                    creditCurrency
            ).stream().findFirst().orElse(null);

        } catch (DataAccessException e) {
            logger.error(
                    "Error fetching distinct denomination for creditCurrency={}",
                    creditCurrency,
                    e
            );
            throw new GrowxException(BaseError.DATABASE_ERROR, e);
        }
    }

    public String getDistinctDenominationByDebitCurrency(String debitCurrency) {
        try {
            return jdbcTemplate.query(
                    CommonConstants.GET_DISTINCT_DENOMINATION_BY_DEBIT_CURRENCY,
                    (rs, rowNum) -> rs.getString(1),
                    debitCurrency,
                    debitCurrency
            ).stream().findFirst().orElse(null);

        } catch (DataAccessException e) {
            logger.error("Error fetching distinct denomination for debitCurrency={}", debitCurrency, e);
            throw new GrowxException(BaseError.DATABASE_ERROR, e);
        }
    }
//
    public UserPermissionDTO getPermissionIdsByUserCode(String userCode, String url) {
        try {
            List<Map<String, Object>> rows =
                    jdbcTemplate.queryForList(
                            CommonConstants.GET_PERMISSION_IDS_BY_USER_CODE,
                            url, userCode
                    );
            return rows.isEmpty() ? null : mapPermission(rows);
        } catch (DataAccessException e) {
            throw new GrowxException(BaseError.PERMISSION_IDS_BY_USER_CODE, e);
        }
    }
//    
//    public UserPermissionDTO getPermissionDataByUserCode(String userCode) {
//        try {
//            List<Map<String, Object>> rows =
//                    jdbcTemplate.queryForList(
//                            CommonConstants.GET_PERMISSION_DATA_BY_USERCODE,
//                            userCode
//                    );
//            return rows.isEmpty() ? null : mapPermission(rows);
//        } catch (DataAccessException e) {
//            throw new GrowxException(BaseError.PERMISSION_IDS_BY_USER_CODE, e);
//        }
//    }
//
    public UserPermissionDTO getUserRegisterByUserCode(String userCode) {
        try {
            List<Map<String, Object>> rows =
                    jdbcTemplate.queryForList(
                            CommonConstants.GET_USER_REGISTER_BY_USER_CODE,
                            userCode
                    );
            return rows.isEmpty() ? null : mapPermission(rows);
        } catch (DataAccessException e) {
            throw new GrowxException(BaseError.PERMISSION_IDS_BY_USER_CODE, e);
        }
    }

//    public UserPermissionDTO getUserIdsByUserCode(String userCode) {
//        try {
//            List<Map<String, Object>> rows =
//                    jdbcTemplate.queryForList(
//                            CommonConstants.GET_USER_IDS_BY_USER_CODE,
//                            userCode
//                    );
//            if (rows.isEmpty()) {
//                return null;
//            }
//            Map<String, Object> row = rows.get(0);
//            UserPermissionDTO dto = new UserPermissionDTO();
//            dto.setUserId(((Number) row.get("user_id")).intValue());
//            dto.setSmeCompId(((Number) row.get("sme_comp_id")).intValue());
//            dto.setCountryCode2((String) row.get("country_code2"));
//            dto.setEmailId((String) row.get("email_id"));
//            return dto;
//        } catch (DataAccessException e) {
//            throw new GrowxException(BaseError.USER_DATA_NULL_OR_EMPTY, e);
//        }
//    }

    private UserPermissionDTO mapPermission(List<Map<String, Object>> rows) {
        Map<String, Object> row = rows.get(0);
        UserPermissionDTO dto = new UserPermissionDTO();

        dto.setUserId(((Number) row.get("user_id")).intValue());
        dto.setSmeCompId(((Number) row.get("sme_comp_id")).intValue());
        dto.setUserType((String) row.get("user_type"));
        dto.setCountryCode2((String) row.get("country_code2"));
        dto.setEmailId((String) row.get("email_id"));
        dto.setSupportCountries((String) row.get("support_countries"));
        dto.setGroupSmeCompId(((Number) row.get("group_sme_comp_id")).intValue());
        rows.forEach(r -> {
            Number permUrlId = (Number) r.get("permission_url_id");
            if (permUrlId != null && permUrlId.intValue() > 0) {
                dto.setPermissionId(((Number) r.get("permission_id")).intValue());
            }
        });
        return dto;
    }

    /* ===================== LOOKUPS ===================== */

//    public SysCurrencyEntity findCurrencyByCountryCode(String code) {
//        return queryOne(CommonConstants.FIND_CURRENCY_BY_COUNTRY_CODE, SysCurrencyEntity.class, code, "A");
//    }
//
//    public CountryEntity findCurrencyByCountryCode2(String code) {
//        return queryOne(CommonConstants.FIND_CURRENCY_BY_COUNTRY_CODE_2, CountryEntity.class, code, "A");
//    }
//
//    public CountryEntity findCountryCodeByCurrency(String code) {
//        return queryOne(CommonConstants.FIND_COUNTRY_CODE_BY_CURRENCY, CountryEntity.class, code, "A");
//    }
//
//    public SysCurrencyEntity findCountryCodeByCurrency2(String code) {
//        return queryOne(CommonConstants.FIND_COUNTRY_CODE_BY_CURRENCY_2, SysCurrencyEntity.class, code, "A");
//    }
//
    public int getDenominationByCurrencyCode(String currencyCode) {
        Integer value =
                jdbcTemplate.queryForObject(
                        CommonConstants.GET_DENOMINATION_BY_CURRENCY_CODE,
                        Integer.class,
                        currencyCode, "A"
                );
        return value == null ? 0 : value;
    }

    /* ===================== BANK / FOREX ===================== */

//    public AccBankDetailDTO findPaymentIntegrationDetails(int subFeatureId, String accountNo) {
//        return queryOne(CommonConstants.FIND_PAYMENT_INTEGRATION_DETAILS, AccBankDetailDTO.class, subFeatureId, accountNo);
//    }
//
//    public AccBankDetailDTO findPaymentIntegrationDetails2(int subFeatureId, String accountNo, int smeCompId) {
//        return queryOne(CommonConstants.FIND_PAYMENT_INTEGRATION_DETAILS_2,
//                AccBankDetailDTO.class, subFeatureId, accountNo, smeCompId);
//    }
    
    public AccBankDetailDTO findPaymentIntegrationDetails2(int subFeatureId, String accountNo, List<Integer> smeCompIds) {
        if (smeCompIds == null || smeCompIds.isEmpty()) {
            throw new GrowxException(BaseError.SME_NOT_AUTHENTICATED_OR_AUTHORIZED);
        }

        // Build placeholders for IN clause
        String placeholders = smeCompIds.stream()
                .map(id -> "?")
                .collect(Collectors.joining(","));
        String sql = String.format(CommonConstants.FIND_PAYMENT_INTEGRATION_DETAILS_2, placeholders);

        // Build parameter list: subFeatureId, accountNo, smeCompIds
        List<Object> params = new ArrayList<>();
        params.add(subFeatureId);
        params.add(accountNo);
        params.addAll(smeCompIds);

        return queryOne(sql, AccBankDetailDTO.class, params.toArray());
    }


    public List<AccForexRateEntity> findForexRateForFxConversion(
            int bankId, String debitCurrency, String creditCurrency) {

        List<AccForexRateEntity> list =
                jdbcTemplate.query(
                        CommonConstants.FIND_FOREX_RATE_FOR_FX_CONVERSION,
                        new BeanPropertyRowMapper<>(AccForexRateEntity.class),
                        bankId, debitCurrency, creditCurrency, creditCurrency, debitCurrency
                );
        return list.isEmpty() ? Collections.emptyList() : list;
    }
//
//    public MasBankFeatureEntity findBankByBankIdAndSubFeatureId(int bankId, int subFeatureId) {
//        return queryOne(CommonConstants.FIND_BANK_BY_BANK_ID_AND_SUB_FEATURE_ID,
//                MasBankFeatureEntity.class, bankId, subFeatureId);
//    }

    public BankDataDTO getBankLogoMeta(BankDataDTO bankDataDTO) {
        String sql = CommonConstants.GET_BANK_LOGO_META;

        if (bankDataDTO.getBankId() != 0) {
            return queryOne(sql + " AND b.bank_id = ? LIMIT 1",
                    BankDataDTO.class, bankDataDTO.getBankId());
        }
        if (bankDataDTO.getCompBankId() != 0) {
            return queryOne(sql + " AND cb.comp_bank_id = ? LIMIT 1",
                    BankDataDTO.class, bankDataDTO.getCompBankId());
        }
        return null;
    }

    /* ===================== AUDIT ===================== */

//    public void saveAuditLog(SystemAuditEntity entity) {
//
//        Long nextId = jdbcTemplate.queryForObject("SELECT NEXTVAL('audit_id_seq')", Long.class);
//        if (nextId == null) {
//            throw new GrowxException(BaseError.UNKNOWN_QUESTION);
//        }
//
//        entity.setAuditId(nextId.intValue());
//
//        Timestamp now = new Timestamp(System.currentTimeMillis());
//
//        int userId = RequestHeaderUtil.getUserId() != 0 ? RequestHeaderUtil.getUserId() : 1;
//        int smeCompId = RequestHeaderUtil.getSmeCompId() != 0 ? RequestHeaderUtil.getSmeCompId() : 0;
//        String userName = RequestHeaderUtil.getUserCode() != null ? RequestHeaderUtil.getUserCode() : "system";
//        String ip = RequestHeaderUtil.getIp() != null ? RequestHeaderUtil.getIp() : "127.0.0.1";
//
////        jdbcTemplate.update(
////                CommonConstants.SAVE_AUDIT_LOG,
////                entity.getAuditId(),
////                entity.getMenuId(),
////                entity.getPermissionId(),
////                entity.getAuditActionName(),
////                entity.getAuditOldValue(),
////                entity.getAuditNewValue(),
////                'A',
////                userId,
////                userName,
////                ip,
////                now,
////                'N'
////        );
//        
//        jdbcTemplate.update(
//        	    CommonConstants.SAVE_AUDIT_LOG,
//        	    entity.getAuditId(),          // audit_id
//        	    entity.getMenuId(),           // menu_id
//        	    entity.getPermissionId(),     // permission_id
//        	    entity.getAuditActionName(),  // audit_action_name
//        	    entity.getAuditOldValue(),    // audit_oldvalue
//        	    entity.getAuditNewValue(),    // audit_newvalue
//        	    smeCompId,                    // sme_comp_id
//        	    entity.getBankId(),           // bank_id
//        	    entity.getChannelSystem(),    // channel_system
//        	    entity.getServiceName(),      // service_name
//        	    entity.getCorrelationId(),    // correlation_id
//        	    entity.getTraceId(),          // trace_id
//        	    entity.getTenantId(),         // tenant_id
//        	    'A',                          // record_state
//        	    now,         				  // crtd_dt
//        	    ip,                           // crtd_ip
//        	    userId,                       // crtd_by
//        	    userName                      // crtd_by_name
//        	);
//    }

    /* ===================== SCHEMA ===================== */

    public GxsysApplicationConfig getSchemaNameByAppId(String appId) {

        if (schemaCache.containsKey(appId)) {
            return schemaCache.get(appId);
        }

        GxsysApplicationConfig schema =
                queryOne(
                        CommonConstants.GET_SCHEMA_NAME_BY_APP_ID.formatted(appMasterSchema),
                        GxsysApplicationConfig.class,
                        appId
                );

        schemaCache.put(appId, schema);
        return schema;
    }

    public GxsysApplicationConfig resolveCurrentSchema() {
        return getSchemaNameByAppId(RequestHeaderUtil.getAppId());
    }

    /* ===================== GENERIC (NO Object exposed) ===================== */

//	public List<SysLookupDTO> findByLookupType(String type) {
//		String sql = String.format(CommonConstants.FIND_BY_LOOKUP_TYPE);
//		return jdbcTemplate.query(
//	        sql,
//	        new BeanPropertyRowMapper<>(SysLookupDTO.class),
//	        type
//	    );
//
//	}
    private <T> T queryOne(String sql, Class<T> type, Object... params) {
        try {
            return jdbcTemplate
                    .query(sql, new BeanPropertyRowMapper<>(type), params)
                    .stream()
                    .findFirst()
                    .orElse(null);
        } catch (DataAccessException e) {
            throw new GrowxException(BaseError.DATABASE_ERROR, e);
        }
    }
//    public SysCountryEntity getCountryDataByCountryCode2(String countryCode2) {
//    	PaginationDto pgDto=new PaginationDto();
//    	pgDto.setType(countryCode2);
//    	ResponseEntity<ApiResponse<SysCountryEntity, Void>> SysCountryEntityObjRes = customerClient.getCountryDataByCountryCode2(pgDto,RequestHeaderUtil.getScope(),RequestHeaderUtil.getUserCode());
//		SysCountryEntity SysCountryEntityObj = SysCountryEntityObjRes.getBody().getData();
//		return SysCountryEntityObj;
//
//	}
}
