package com.wealth.common.constants;

public final class CommonConstants {

	private CommonConstants() {
        // prevents instantiation
    }
	public static final String USER_CODE_PREFIX = "USR0";
	 
	public static final String GXMAS_BANK_FEATURE = "GXMAS_BANK_FEATURE";
	public static final String GXCBS_USER_CONSENT = "GXCBS_USER_CONSENT";
	public static final String GXCBS_USER_CONSENT_HIST = "GXCBS_USER_CONSENT_HIST";
	public static final String GXCOL_INVOICE_TRANSACTIONS = "GXCOL_INVOICE_TRANSACTIONS";
	public static final String GXCBS_USER_CONSENT_ACCOUNT = "GXCBS_USER_CONSENT_ACCOUNT";
	public static final String GXCBS_OPENID = "GXCBS_OPENID";
	public static final String GXEVE_SYSTEM_AUDIT = "GXEVE_SYSTEM_AUDIT";

	public static final String FIND_BANK_BY_BANK_ID_AND_SUB_FEATURE_ID = "SELECT bank_feature_id, bank_id, sub_feature_id, routing_type_code, fee_id, record_state, crtd_ip, crtd_by, crtd_dt, updt_ip, updt_by, updt_dt FROM " + GXMAS_BANK_FEATURE + " WHERE bank_id = ? AND sub_feature_id = ?";

	public static final String FIND_CONSENT_BY_USERID = "SELECT user_consent_id, user_id, sme_comp_id, consent_id, token_expires_at, consent_type, consent_usage, access_token, refresh_token, purpose_statement, direct_benefit_statement, data_request_statement, duration_period_statement, agreement, crtd_dt, crtd_ip, crtd_by, updt_dt, updt_ip, updt_by, record_state, id_token, permission_name, country_code2, base_consent_id, bank_id, health_check, cbs_permission_ids, oauth_state, code_verifier, consent_status, revoke_key, revoke_value, revoke_consent_type, delegated_userid, keep_flag, archival_status, archival_date, oauth_state_status, consent_start_datetime, consent_end_datetime, consent_usage_subtype FROM " + GXCBS_USER_CONSENT + " WHERE user_id = ? AND consent_usage = 'Bank Data Sharing' ORDER BY crtd_dt DESC LIMIT 1";

	public static final String FIND_ACTIVE_CONSENT_BY_USERID = "SELECT user_consent_id, user_id, sme_comp_id, consent_id, token_expires_at, consent_type, consent_usage, access_token, refresh_token, purpose_statement, direct_benefit_statement, data_request_statement, duration_period_statement, agreement, crtd_dt, crtd_ip, crtd_by, updt_dt, updt_ip, updt_by, record_state, id_token, permission_name, country_code2, base_consent_id, bank_id, health_check, cbs_permission_ids, oauth_state, code_verifier, consent_status, revoke_key, revoke_value, revoke_consent_type, delegated_userid, keep_flag, archival_status, archival_date, oauth_state_status, consent_start_datetime, consent_end_datetime, consent_usage_subtype FROM " + GXCBS_USER_CONSENT + " WHERE user_id = ? AND consent_type = 'Long-Lived Consent' AND record_state = 'A' ORDER BY crtd_dt DESC LIMIT 1";

	public static final String FIND_CONSENTS_BY_USERID = "SELECT user_consent_id, user_id, sme_comp_id, consent_id, token_expires_at, consent_type, consent_usage, access_token, refresh_token, purpose_statement, direct_benefit_statement, data_request_statement, duration_period_statement, agreement, crtd_dt, crtd_ip, crtd_by, updt_dt, updt_ip, updt_by, record_state, id_token, permission_name, country_code2, base_consent_id, bank_id, health_check, cbs_permission_ids, oauth_state, code_verifier, consent_status, revoke_key, revoke_value, revoke_consent_type, delegated_userid, keep_flag, archival_status, archival_date, oauth_state_status, consent_start_datetime, consent_end_datetime, consent_usage_subtype FROM " + GXCBS_USER_CONSENT + " WHERE user_id = ? AND consent_type = 'Long-Lived Consent' ORDER BY crtd_dt DESC";

	public static final String FIND_ACTIVE_CONSENTS_BY_USERID = SchemaConstants.applySchema("SELECT user_consent_id, user_id, sme_comp_id, consent_id, token_expires_at, consent_type, consent_usage, access_token, refresh_token, purpose_statement, direct_benefit_statement, data_request_statement, duration_period_statement, agreement, crtd_dt, crtd_ip, crtd_by, updt_dt, updt_ip, updt_by, record_state, id_token, permission_name, country_code2, base_consent_id, bank_id, health_check, cbs_permission_ids, oauth_state, code_verifier, consent_status, revoke_key, revoke_value, revoke_consent_type, delegated_userid, keep_flag, archival_status, archival_date, oauth_state_status, consent_start_datetime, consent_end_datetime, consent_usage_subtype FROM " + GXCBS_USER_CONSENT + " WHERE user_id = ? AND consent_type = 'Long-Lived Consent' AND record_state = 'A' ORDER BY crtd_dt DESC");

	public static final String FIND_CONSENT_BY_CONSENT_ID = "SELECT user_consent_id, user_id, sme_comp_id, consent_id, token_expires_at, consent_type, consent_usage, access_token, refresh_token, purpose_statement, direct_benefit_statement, data_request_statement, duration_period_statement, agreement, crtd_dt, crtd_ip, crtd_by, updt_dt, updt_ip, updt_by, record_state, id_token, permission_name, country_code2, base_consent_id, bank_id, health_check, cbs_permission_ids, oauth_state, code_verifier, consent_status, revoke_key, revoke_value, revoke_consent_type, delegated_userid, keep_flag, archival_status, archival_date, oauth_state_status, consent_start_datetime, consent_end_datetime, consent_usage_subtype FROM " + GXCBS_USER_CONSENT + " WHERE consent_id = ?";

	public static final String FIND_CONSENT_HIST_BY_CONSENT_ID = "SELECT user_consent_id, user_id, sme_comp_id, consent_id, token_expires_at, consent_type, consent_usage, access_token, refresh_token, purpose_statement, direct_benefit_statement, data_request_statement, duration_period_statement, agreement, id_token, permission_name, country_code2, base_consent_id, record_state, crtd_ip, crtd_by, crtd_dt, updt_ip, updt_by, updt_dt, health_check, bank_id, cbs_permission_ids, oauth_state, code_verifier, consent_status, revoke_key, revoke_value, revoke_consent_type, delegated_userid, keep_flag, archival_status, archival_date, oauth_state_status, consent_start_datetime, consent_end_datetime, consent_usage_subtype FROM " + GXCBS_USER_CONSENT_HIST + " WHERE consent_id = ?";

	public static final String FIND_CONSENT_HIST_BY_CONSENT_ID_WITH_CONSENT_STATUS = "SELECT user_consent_id, user_id, sme_comp_id, consent_id, token_expires_at, consent_type, consent_usage, access_token, refresh_token, purpose_statement, direct_benefit_statement, data_request_statement, duration_period_statement, agreement, id_token, permission_name, country_code2, base_consent_id, record_state, crtd_ip, crtd_by, crtd_dt, updt_ip, updt_by, updt_dt, health_check, bank_id, cbs_permission_ids, oauth_state, code_verifier, consent_status, revoke_key, revoke_value, revoke_consent_type, delegated_userid, keep_flag, archival_status, archival_date, oauth_state_status, consent_start_datetime, consent_end_datetime, consent_usage_subtype FROM " + GXCBS_USER_CONSENT_HIST + " WHERE consent_id = ? AND consent_status IN (?, ?)";

	public static final String FIND_CONSENT_BY_CONSENT_ID_WITH_CONSENT_STATUS = "SELECT user_consent_id, user_id, sme_comp_id, consent_id, token_expires_at, consent_type, consent_usage, access_token, refresh_token, purpose_statement, direct_benefit_statement, data_request_statement, duration_period_statement, agreement, crtd_dt, crtd_ip, crtd_by, updt_dt, updt_ip, updt_by, record_state, id_token, permission_name, country_code2, base_consent_id, bank_id, health_check, cbs_permission_ids, oauth_state, code_verifier, consent_status, revoke_key, revoke_value, revoke_consent_type, delegated_userid, keep_flag, archival_status, archival_date, oauth_state_status, consent_start_datetime, consent_end_datetime, consent_usage_subtype FROM " + GXCBS_USER_CONSENT + " WHERE consent_id = ? AND consent_status IN (?, ?)";

	public static final String FIND_CONSENT_BY_USERID_WITH_ACCOUNT = "SELECT user_consent_id, user_id, sme_comp_id, consent_id, token_expires_at, consent_type, consent_usage, access_token, refresh_token, purpose_statement, direct_benefit_statement, data_request_statement, duration_period_statement, agreement, crtd_dt, crtd_ip, crtd_by, updt_dt, updt_ip, updt_by, record_state, id_token, permission_name, country_code2, base_consent_id, bank_id, health_check, cbs_permission_ids, oauth_state, code_verifier, consent_status, revoke_key, revoke_value, revoke_consent_type, delegated_userid, keep_flag, archival_status, archival_date, oauth_state_status, consent_start_datetime, consent_end_datetime, consent_usage_subtype FROM GXCBS_USER_CONSENT uc JOIN gxcbs_user_consent_account uca ON uc.user_consent_id = uca.user_consent_id WHERE uc.user_id = ? AND uca.account_no = ? AND uc.consent_type = 'Long-Lived Consent' ORDER BY uc.crtd_dt DESC LIMIT 1";
	
	public static final String FIND_ACTIVE_CONSENT_BY_USERID_WITH_ACCOUNT = "SELECT uc.user_consent_id, user_id, sme_comp_id, consent_id, token_expires_at, consent_type, consent_usage, access_token, refresh_token, purpose_statement, direct_benefit_statement, data_request_statement, duration_period_statement, agreement, crtd_dt, crtd_ip, crtd_by, updt_dt, updt_ip, updt_by, record_state, id_token, permission_name, country_code2, base_consent_id, bank_id, health_check, cbs_permission_ids, oauth_state, code_verifier, consent_status, revoke_key, revoke_value, revoke_consent_type, delegated_userid, keep_flag, archival_status, archival_date, oauth_state_status, consent_start_datetime, consent_end_datetime, consent_usage_subtype FROM GXCBS_USER_CONSENT uc JOIN gxcbs_user_consent_account uca ON uc.user_consent_id = uca.user_consent_id WHERE uc.user_id = ? AND uca.account_no = ? AND uc.consent_type = 'Long-Lived Consent' AND uc.record_state = 'A' ORDER BY uc.crtd_dt DESC LIMIT 1";

	public static final String FIND_CONSENT_BY_USERID_GET_ACCOUNTS = "SELECT uc.user_consent_id, user_id, sme_comp_id, consent_id, token_expires_at, consent_type, consent_usage, access_token, refresh_token, purpose_statement, direct_benefit_statement, data_request_statement, duration_period_statement, agreement, crtd_dt, crtd_ip, crtd_by, updt_dt, updt_ip, updt_by, record_state, id_token, permission_name, country_code2, base_consent_id, bank_id, health_check, cbs_permission_ids, oauth_state, code_verifier, consent_status, revoke_key, revoke_value, revoke_consent_type, delegated_userid, keep_flag, archival_status, archival_date, oauth_state_status, consent_start_datetime, consent_end_datetime, consent_usage_subtype, uca.account_no FROM GXCBS_USER_CONSENT uc JOIN gxcbs_user_consent_account uca ON uc.user_consent_id = uca.user_consent_id WHERE uc.user_id = ? AND uc.consent_type = 'Long-Lived Consent' ORDER BY uc.crtd_dt";

	public static final String FIND_ACTIVE_CONSENT_BY_USERID_GET_ACCOUNTS = "SELECT uc.user_consent_id, user_id, sme_comp_id, consent_id, token_expires_at, consent_type, consent_usage, access_token, refresh_token, purpose_statement, direct_benefit_statement, data_request_statement, duration_period_statement, agreement, crtd_dt, crtd_ip, crtd_by, updt_dt, updt_ip, updt_by, record_state, id_token, permission_name, country_code2, base_consent_id, bank_id, health_check, cbs_permission_ids, oauth_state, code_verifier, consent_status, revoke_key, revoke_value, revoke_consent_type, delegated_userid, keep_flag, archival_status, archival_date, oauth_state_status, consent_start_datetime, consent_end_datetime, consent_usage_subtype, uca.account_no, uca.cbs_account_id FROM GXCBS_USER_CONSENT uc JOIN gxcbs_user_consent_account uca ON uc.user_consent_id = uca.user_consent_id WHERE uc.user_id = ? AND uc.consent_type = 'Long-Lived Consent' AND uc.record_state = 'A' ORDER BY uc.crtd_dt";

	public static final String GXMAS_BANK_CBS_CONFIG= "GXMAS_BANK_CBS_CONFIG";
	
	public static final String GXCBS_PARTICIPANTS = "GXCBS_PARTICIPANTS";
	
	public static final String FIND_CONFIG_BY_BANK_ID = "SELECT * FROM " + GXMAS_BANK_CBS_CONFIG + " WHERE bank_id = ?";

	public static final String DELETE_BANK_FEATURE_FOR_BANK = "DELETE FROM " + GXMAS_BANK_FEATURE + " WHERE bank_id = ?";

	public static final String FIND_BANK_FEATURES_BY_BANK_ID = "SELECT bank_feature_id, bank_id, sub_feature_id, routing_type_code, fee_id, record_state, crtd_ip, crtd_by, crtd_dt, updt_ip, updt_by, updt_dt FROM " + GXMAS_BANK_FEATURE + " WHERE bank_id = ?";

	public static final String DELETE_USER_CONSENT_ACC_BY_CONSENT_ID = "DELETE FROM " + GXCBS_USER_CONSENT_ACCOUNT + " A WHERE A.user_consent_id IN (SELECT C.user_consent_id FROM " + GXCBS_USER_CONSENT + " C WHERE C.consent_id = ?)";

	public static final String FIND_USER_CONSENT_BY_STATE = SchemaConstants.applySchema("SELECT user_consent_id, user_id, sme_comp_id, consent_id, token_expires_at, consent_type, consent_usage, access_token, refresh_token, purpose_statement, direct_benefit_statement, data_request_statement, duration_period_statement, agreement, crtd_dt, crtd_ip, crtd_by, updt_dt, updt_ip, updt_by, record_state, id_token, permission_name, country_code2, base_consent_id, bank_id, health_check, cbs_permission_ids, oauth_state, code_verifier, consent_status, revoke_key, revoke_value, revoke_consent_type, delegated_userid, keep_flag, archival_status, archival_date, oauth_state_status, consent_start_datetime, consent_end_datetime, consent_usage_subtype, oauth_nonce, code_challenge, app_url FROM " + GXCBS_USER_CONSENT + " WHERE oauth_state = ?");

	public static final String FIND_OIDC_CONFIG_BY_BANKID = "SELECT cbs_open_id, country_code2, config_json, record_state, crtd_dt, updt_dt, bank_id, issuer, token_endpoint, registration_endpoint, jwks_uri, user_info_endpoint, introspection_endpoint, revocation_endpoint, par_endpoint, backchannel_authentication_endpoint, crtd_ip, updt_ip, crtd_by, updt_by, authorization_endpoint, resource_base_url FROM " + GXCBS_OPENID + " WHERE bank_id = ?";

	public static final String DELETE_OIDC_CONFIG_BY_BANKID = "DELETE FROM " + GXCBS_OPENID + " WHERE bank_id = ?";

	public static final String UPDATE_OAUTH_STATE_STATUS = SchemaConstants.applySchema("UPDATE " + GXCBS_USER_CONSENT + " SET oauth_state_status = ? WHERE oauth_state = ? AND oauth_state_status = ?");

	public static final String FIND_BY_OAUTH_STATE = "SELECT * FROM " + GXCOL_INVOICE_TRANSACTIONS + " WHERE oauth_state = ?";

	public static final String FIND_BY_CONSENT_ID = "SELECT * FROM " + GXCOL_INVOICE_TRANSACTIONS + " WHERE consent_id = ?";

	public static final String UPDATE_STATE_STATUS = "UPDATE " + GXCOL_INVOICE_TRANSACTIONS + " SET oauth_state_status = ? WHERE oauth_state = ? AND oauth_state_status = ?";

	public static final String FIND_BY_INVOICE_ID = "SELECT * FROM " + GXCOL_INVOICE_TRANSACTIONS + " WHERE invoice_id = ?";

	public static final String FIND_PARTICIPANT_BY_ORGANISATION_ID = SchemaConstants.applySchema("SELECT * FROM " + GXCBS_PARTICIPANTS + " WHERE organisation_id = ?");

	public static final String GET_PERMISSION_IDS_BY_COMPANY_USER_CODE = SchemaConstants.applySchema("SELECT U.USER_ID, U.GROUP_SME_COMP_ID, U.EMAIL_ID, U.SME_COMP_ID, U.USER_TYPE, U.COUNTRY_CODE2, US.PREFERRED_LANGUAGE, US.LOCAL_CODE, UR.COMP_ROLE_ID, CRP.PERMISSION_ID, COALESCE(SPR.PERMISSION_URL_ID, 0) AS PERMISSION_URL_ID, STRING_AGG(DISTINCT CC.COUNTRY_CODE2, ',') AS SUPPORT_COUNTRIES FROM GXSME_COMP_USER U JOIN GXSME_COMP_USER_ROLE UR ON U.USER_ID = UR.USER_ID LEFT JOIN GXSYS_USER_SETTINGS US ON US.USER_ID = U.USER_ID JOIN GXSME_COMP_ROLE_PERMI CRP ON CRP.COMP_ROLE_ID = UR.COMP_ROLE_ID LEFT JOIN GXSYS_PERMISSION_URL SPR ON SPR.PERMISSION_ID = CRP.PERMISSION_ID AND SPR.RESOURCE_URL = ? LEFT JOIN GXSME_USER_COUNTRY UC ON UC.USER_ID = U.USER_ID LEFT JOIN GXSME_COMPANY_COUNTRY CC ON CC.SME_COUNTRY_ID = UC.SME_COUNTRY_ID JOIN GXSME_COMPANY GC ON GC.SME_COMP_ID = CC.SME_COMP_ID AND UC.GROUP_SME_COMP_ID = GC.GROUP_SME_COMP_ID WHERE U.USER_CODE = ? AND U.RECORD_STATE = 'A' AND UR.RECORD_STATE = 'A' AND CRP.RECORD_STATE = 'A' GROUP BY U.USER_ID, U.GROUP_SME_COMP_ID, U.EMAIL_ID, U.SME_COMP_ID, U.USER_TYPE, U.COUNTRY_CODE2, US.PREFERRED_LANGUAGE, US.LOCAL_CODE, UR.COMP_ROLE_ID, CRP.PERMISSION_ID, SPR.PERMISSION_URL_ID");

	public static final String GET_PERMISSION_DATA_BY_COMPUSERCODE = SchemaConstants.applySchema("SELECT u.user_id, u.email_id, u.group_sme_comp_id, u.sme_comp_id, u.user_type, u.country_code2, us.preferred_language, us.local_code, ur.comp_role_id, crp.permission_id, COALESCE(spr.permission_url_id, 0) AS permission_url_id, STRING_AGG(DISTINCT cc.country_code2, ',') AS support_countries FROM gxsme_comp_user u JOIN gxsme_comp_user_role ur ON u.user_id = ur.user_id LEFT JOIN gxsys_user_settings us ON us.user_id = u.user_id JOIN gxsme_comp_role_permi crp ON crp.comp_role_id = ur.comp_role_id LEFT JOIN gxsys_permission_url spr ON spr.permission_id = crp.permission_id LEFT JOIN gxsme_user_country uc ON uc.user_id = u.user_id LEFT JOIN gxsme_company_country cc ON cc.sme_comp_id = uc.sme_comp_id AND cc.sme_country_id = uc.sme_country_id WHERE u.user_code = ? AND u.record_state = 'A' AND ur.record_state = 'A' AND crp.record_state = 'A' GROUP BY u.user_id, u.email_id, u.sme_comp_id, u.user_type, u.country_code2, us.preferred_language, us.local_code, ur.comp_role_id, crp.permission_id, spr.permission_url_id");

	public static final String GET_PERMISSION_IDS_BY_URI = SchemaConstants.applySchema("SELECT PU.PERMISSION_ID, CRP.COMP_ROLE_ID, CUR.USER_ID, CUR.SME_COMP_ID,CU.GROUP_SME_COMP_ID, CU.EMAIL_ID, CU.USER_TYPE, CU.COUNTRY_CODE2, CUR.BANK_ID, CUR.CRTD_BY, CUR.CRTD_DT, CUR.CRTD_IP, COALESCE(PU.PERMISSION_URL_ID, 0) AS PERMISSION_URL_ID FROM GXSYS_PERMISSION_URL PU JOIN GXSME_COMP_ROLE_PERMI CRP ON PU.PERMISSION_ID = CRP.PERMISSION_ID LEFT JOIN GXSME_COMP_USER_ROLE CUR ON CRP.COMP_ROLE_ID = CUR.COMP_ROLE_ID LEFT JOIN GXSME_COMP_USER CU ON CU.USER_ID = CUR.USER_ID WHERE PU.RESOURCE_URL = ? AND PU.RECORD_STATE = 'A' AND CUR.RECORD_STATE = 'A' AND CRP.RECORD_STATE = 'A' GROUP BY CRP.COMP_ROLE_ID, CRP.PERMISSION_ID, PU.PERMISSION_URL_ID, CUR.USER_ID, CUR.SME_COMP_ID, CUR.BANK_ID, CUR.CRTD_BY, CUR.CRTD_DT, CUR.CRTD_IP, CU.EMAIL_ID, CU.USER_TYPE, CU.COUNTRY_CODE2");

	public static final String GET_PERMISSION_IDS_BY_USER_CODE =SchemaConstants.applySchema( "SELECT u.user_id, u.email_id, u.group_sme_comp_id, u.sme_comp_id, u.user_type, u.country_code2, us.preferred_language,rp.permission_id, us.local_code, CASE WHEN spr.permission_url_id IS NOT NULL THEN spr.permission_url_id ELSE 0 END AS permission_url_id FROM gxsme_comp_user u JOIN gxsme_comp_user_role ur ON u.user_id = ur.user_id LEFT JOIN gxsys_user_settings us ON us.user_id = u.user_id JOIN gxsme_comp_role_permi rp ON ur.comp_role_id = rp.comp_role_id LEFT JOIN gxsys_permission_url spr ON spr.permission_id = rp.permission_id AND spr.resource_url = ? WHERE u.user_code = ? AND u.record_state = 'A' AND ur.record_state = 'A' AND rp.record_state = 'A' GROUP BY u.user_id, u.email_id, u.sme_comp_id, u.user_type, u.country_code2, us.preferred_language,rp.permission_id, u.group_sme_comp_id, us.local_code, spr.permission_url_id, rp.permission_id");

	public static final String GET_PERMISSION_DATA_BY_USERCODE = SchemaConstants.applySchema("SELECT u.user_id, u.email_id, u.group_sme_comp_id, u.sme_comp_id, u.user_type, u.country_code2, us.preferred_language,rp.permission_id, us.local_code, CASE WHEN spr.permission_url_id IS NOT NULL THEN spr.permission_url_id ELSE 0 END AS permission_url_id FROM gxsme_comp_user u JOIN gxsme_comp_user_role ur ON u.user_id = ur.user_id LEFT JOIN gxsys_user_settings us ON us.user_id = u.user_id JOIN gxsme_comp_role_permi rp ON ur.comp_role_id = rp.comp_role_id LEFT JOIN gxsys_permission_url spr ON spr.permission_id = rp.permission_id WHERE u.user_code = ? AND u.record_state = 'A' AND ur.record_state = 'A' AND rp.record_state = 'A' GROUP BY u.user_id, u.email_id, u.sme_comp_id, u.user_type, u.country_code2, us.preferred_language,rp.permission_id,u.group_sme_comp_id, us.local_code, spr.permission_url_id, rp.permission_id");

	public static final String GET_USER_REGISTER_BY_USER_CODE = SchemaConstants.applySchema("SELECT u.user_id, u.email_id, u.group_sme_comp_id, u.sme_comp_id, u.user_type, u.country_code2 FROM gxsme_user_register u WHERE u.user_code = ? GROUP BY u.user_id, u.email_id, u.sme_comp_id, u.user_type, u.group_sme_comp_id,u.country_code2, u.preferred_lang");

	public static final String FIND_CURRENCY_BY_COUNTRY_CODE = "SELECT * FROM gxmas_bank_currency WHERE country_code2 = ? AND record_state = ? LIMIT 1";

	public static final String FIND_CURRENCY_BY_COUNTRY_CODE_2 = "SELECT * FROM gxsys_global_country WHERE country_code2 = ? AND record_state = ? LIMIT 1";

	public static final String FIND_COUNTRY_CODE_BY_CURRENCY = "SELECT * FROM gxmas_bank_currency WHERE currency_code = ? AND record_state = ? LIMIT 1";

	public static final String FIND_COUNTRY_CODE_BY_CURRENCY_2 = "SELECT * FROM gxsys_global_country WHERE currency_code = ? AND record_state = ? LIMIT 1";

	public static final String FIND_PAYMENT_INTEGRATION_DETAILS = "SELECT bank_feature_id, bank_id, sub_feature_id, routing_type_code, fee_id, record_state, crtd_ip, crtd_by, crtd_dt, updt_ip, updt_by, updt_dt FROM gxmas_bank_feature GBF JOIN gxsme_comp_bank GCB ON GCB.bank_id = GBF.bank_id JOIN gxsme_comp_account GCA ON GCB.comp_bank_id = GCA.comp_bank_id WHERE GBF.sub_feature_id = ? AND GCA.account_no = ?";

	public static final String FIND_FOREX_RATE_FOR_FX_CONVERSION = SchemaConstants.applySchema("SELECT * FROM gxacc_forex_rate WHERE record_state = 'A' AND bank_id = ? AND ((debit_currency = ? OR credit_currency = ?) OR (debit_currency = ? OR credit_currency = ?))");

	public static final String GET_DISTINCT_DENOMINATION_BY_DEBIT_CURRENCY = SchemaConstants.applySchema("SELECT gfr.country_code2 FROM gxacc_forex_rate gfr WHERE gfr.record_state = 'A' AND gfr.credit_currency = ? OR gfr.debit_currency = ?  LIMIT 1");

	public static final String GET_DISTINCT_DENOMINATION_BY_CREDIT_CURRENCY = SchemaConstants.applySchema("SELECT gfr.country_code2 FROM gxacc_forex_rate gfr WHERE gfr.record_state = 'A' AND gfr.credit_currency = ? OR gfr.debit_currency = ?  LIMIT 1");

//	public static final String SAVE_AUDIT_LOG = "INSERT INTO gxeve_system_audit( audit_seq_id, menu_id, permission_id, audit_action_name, audit_oldvalue, audit_newvalue, RECORD_STATE, crtd_by, crtd_by_name, crtd_ip, crtd_dt ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public static final String SAVE_AUDIT_LOG = "INSERT INTO " + GXEVE_SYSTEM_AUDIT + " (audit_id, menu_id, permission_id, audit_action_name, audit_oldvalue, audit_newvalue, sme_comp_id, bank_id, channel_system, service_name, correlation_id, trace_id, tenant_id, record_state, crtd_dt, crtd_ip, crtd_by, crtd_by_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public static final String GET_DENOMINATION_BY_CURRENCY_CODE = "SELECT denomination FROM gxmas_bank_currency WHERE currency_code = ? AND record_state = ?";

	public static final String GET_BANK_LOGO_META = "SELECT b.bank_id AS bankId, cb.comp_bank_id AS compBankId, b.bank_name AS bankName, b.bank_code AS bankCode, b.bank_colour_code AS bankColourCode, b.logo_name AS logoName, b.logo_path AS logoPath FROM gxmas_bank b LEFT JOIN gxsme_comp_bank cb ON b.bank_id = cb.bank_id WHERE b.record_state <> 'D'";

	public static final String GET_USER_IDS_BY_USER_CODE = "SELECT u.user_id, u.email_id, u.sme_comp_id, u.user_type, u.country_code2 FROM gxsme_user_register u WHERE u.user_code = ? GROUP BY u.user_id, u.sme_comp_id, u.user_type, u.country_code2";

	public static final String GET_SCHEMA_NAME_BY_APP_ID = "SELECT tenant_id , application_name AS applicationName, schema_name AS schemaName, app_description AS appDescription, BENE_PURPOSECODE_COUNTRYCODE2 AS BenePurposecodeCountrycode2, version, routing_type_code AS routingTypeCode, record_state, crtd_ip, crtd_by, crtd_dt, updt_ip, updt_by, updt_dt, two_factor_auth, last_approve FROM %s.GXSYS_TENANT WHERE tenant_id = ?";

	public static final String FIND_BY_LOOKUP_TYPE = "SELECT * FROM gxsys_global_lookup WHERE gx_lookup_type = ?";
//	public static final String FIND_PAYMENT_INTEGRATION_DETAILS_2 = "SELECT GBF.bank_feature_id, GBF.bank_id, GBF.sub_feature_id, GBF.routing_type_code, GBF.fee_id, GBF.record_state, GBF.crtd_ip, GBF.crtd_by, GBF.crtd_dt, GBF.updt_ip, GBF.updt_by, GBF.updt_dt FROM gxmas_bank_feature GBF JOIN gxsme_comp_bank GCB ON GCB.bank_id = GBF.bank_id JOIN gxsme_comp_account GCA ON GCB.comp_bank_id = GCA.comp_bank_id where GBF.sub_feature_id=? and GCA.account_no=? and GCA.sme_comp_id = ?";
	public static final String FIND_PAYMENT_INTEGRATION_DETAILS_2 = "SELECT GBF.bank_feature_id, GBF.bank_id, GBF.sub_feature_id, GBF.routing_type_code, GBF.fee_id, GBF.record_state, GBF.crtd_ip, GBF.crtd_by, GBF.crtd_dt, GBF.updt_ip, GBF.updt_by, GBF.updt_dt, GCA.account_country_code2 FROM gxmas_bank_feature GBF JOIN gxsme_comp_bank GCB ON GCB.bank_id = GBF.bank_id JOIN gxsme_comp_account GCA ON GCB.bank_id = GCA.bank_id AND GCB.sme_comp_id = GCA.sme_comp_id WHERE GBF.sub_feature_id = ? AND GCA.account_no = ? AND GCA.sme_comp_id IN (%s)";

//	private static String applySchema(String sql) {
//
//	    String[] prefixes = {
//	            "gxacc_",
//	            "gxaim_",
//	            "gxbil_",
//	            "gxcbs_",
//	            "gxcol_",
//	            "gxeve_",
//	            "gxext_",
//	            "gxmas_",
//	            "gxnot_",
//	            "gxpay_",
//	            "gxrpt_",
//	            "gxsme_",
//	            "gxsys_",
//	            "gxwps_"
//	    };
//
//	    for (String prefix : prefixes) {
//	        sql = sql.replaceAll("\\b" + prefix, RequestHeaderUtil.getAppConfig().getSchemaName() + "." + prefix);
//	    }
//
//	    return sql;
//	}
}
