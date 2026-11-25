package com.wealth.common.constants;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import com.wealth.common.utils.generic.RequestHeaderUtil;

public class SchemaConstants {

	public static final String GXREF = "REF";
	public static final String GXCBS_ACCOUNT_PARTIES = "REF";
	public static final String GXCBS_ACCOUNT_PRODUCTS = "REF";
	public static final String GXCBS_OPENID = "REF";
	public static final String GXCBS_OPENID_HIST = "REF";
	public static final String GXCBS_PARTICIPANTS = "REF";
	public static final String GXCBS_PERMISSION = "REF";
	public static final String GXCBS_USER_CONSENT = "REF";
	public static final String GXCBS_USER_CONSENT_ACC_CARDS = "REF";
	public static final String GXCBS_USER_CONSENT_ACC_CARDS_HIST = "REF";
	public static final String GXCBS_USER_CONSENT_ACCOUNT = "REF";
	public static final String GXCBS_USER_CONSENT_ACCOUNT_HIST = "REF";
	public static final String GXCBS_USER_CONSENT_ACCOUNT_PERMISSION = "REF";
	public static final String GXCBS_USER_CONSENT_ACCOUNT_PERMISSION_HIST = "REF";
	public static final String GXCBS_USER_CONSENT_HIST = "REF";
	public static final String GXMAS_APP_WKF_HISTORY = "REF";
	public static final String GXMAS_BANK = "REF";
	public static final String GXMAS_BANK_CBS_CONFIG = "REF";
	public static final String GXMAS_BANK_CURRENCY = "REF";
	public static final String GXMAS_BANK_FEATURE = "REF";
	public static final String GXMAS_BANK_FEATURE_FEE = "REF";
	public static final String GXMAS_BANK_FEE_POSTING = "REF";
	public static final String GXMAS_COUNTRY_HOLIDAY = "REF";
	public static final String GXMAS_CURRENCY_CUTOFF = "REF";
	public static final String GXMAS_CURRENCY_CUTOFF_TIME = "REF";
	public static final String GXMAS_CURRENCY_HOLIDAY = "REF";
	public static final String GXMAS_FEE = "REF";
	public static final String GXMAS_FEE_FEATURE = "REF";
	public static final String GXMAS_SME_COUNTRY = "REF";
	public static final String GXMAS_WKF_BANK = "REF";
	public static final String GXMAS_WKF_BANK_FEATURE = "REF";
	public static final String GXMAS_WKF_BANK_FEATURE_FEE = "REF";
	public static final String GXMAS_WKF_FEE = "REF";
	public static final String GXMAS_WKF_FEE_FEATURE = "REF";
	
	public static final String GXSME_COMP_ACCOUNT = "REF";
	public static final String GXSME_COMP_ACCOUNT_CARDS = "REF";
	public static final String GXSME_COMP_AUTHMATRIX = "REF";
	public static final String GXSME_COMP_BANK = "REF";
	public static final String GXSME_COMP_BANK_FEATURE = "REF";
	public static final String GXSME_COMP_FEATURE_CONFIG = "REF";
	public static final String GXSME_COMP_FEATURE_FEE = "REF";
	public static final String GXSME_COMP_ROLE = "REF";
	public static final String GXSME_COMP_ROLE_PERMI = "REF";
	public static final String GXSME_COMP_USER = "REF";
	public static final String GXSME_COMP_USER_ACCOUNT = "REF";
	public static final String GXSME_COMP_USER_BANK = "REF";
	public static final String GXSME_COMP_USER_BANK_FEATURE = "REF";
	public static final String GXSME_COMP_USER_FEATURE_ACCOUNT = "REF";
	public static final String GXSME_COMP_USER_ROLE = "REF";
	public static final String GXSME_COMPANY = "REF";
	public static final String GXSME_COMPANY_COUNTRY = "REF";
	public static final String GXSME_GROUP_COMPANY = "REF";
	public static final String GXSME_STG_COMP_ACCOUNT = "REF";
	public static final String GXSME_USER_COUNTRY = "REF";
	public static final String GXSME_USER_REGISTER = "REF";
	public static final String GXSME_USER_LAYOUT_WIDGETS = "REF";
	public static final String GXSME_USER_FEEDBACK = "REF";
	public static final String GXSME_USER_ISSUE_REPORT = "REF";
	public static final String GXSME_COMP_ACCOUNT_BALANCE = "REF";
    public static final String GXSME_COMP_DOCUMENTS = "REF";
    public static final String GXSME_COMP_AUTH_GROUP = "REF";
    public static final String GXSME_USER_NOTIFY_PREFERENCE = "REF";
    public static final String GXSME_COMP_FINANCIAL_PARTNER = "REF";
    public static final String GXSME_COMP_FINANCIAL_PROFILE = "REF";
    public static final String GXSME_COMP_FINANCIAL_COVENANT = "REF";
    
	public static final String GXSME_WKF_COMP_ACCOUNT = "REF";
	public static final String GXSME_WKF_COMP_ACCOUNT_CARDS = "REF";
	public static final String GXSME_WKF_COMP_AUTHMATRIX = "REF";
	public static final String GXSME_WKF_COMP_BANK = "REF";
	public static final String GXSME_WKF_COMP_BANK_FEATURE = "REF";
	public static final String GXSME_WKF_COMP_FEATURE_FEE = "REF";
	public static final String GXSME_WKF_COMP_ROLE = "REF";
	public static final String GXSME_WKF_COMP_ROLE_PERMI = "REF";
	public static final String GXSME_WKF_COMP_USER = "REF";
	public static final String GXSME_WKF_COMP_USER_ACCOUNT = "REF";
	public static final String GXSME_WKF_COMP_USER_BANK = "REF";
	public static final String GXSME_WKF_COMP_USER_BANK_FEATURE = "REF";
	public static final String GXSME_WKF_COMP_USER_FEATURE_ACCOUNT = "REF";
	public static final String GXSME_WKF_COMP_USER_ROLE = "REF";
	public static final String GXSME_WKF_COMPANY = "REF";
	public static final String GXSME_WKF_COMPANY_COUNTRY = "REF";
	public static final String GXSME_WKF_GROUP_COMPANY = "REF";
	public static final String GXSME_WKF_USER_COUNTRY = "REF";
    public static final String GXSME_WKF_COMP_AUTH_GROUP = "REF";
    public static final String GXSME_WKF_COMP_FINANCIAL_PARTNER = "REF";
    public static final String GXSME_WKF_COMP_FINANCIAL_PROFILE = "REF";
    public static final String GXSME_WKF_COMP_FINANCIAL_COVENANT = "REF";
	
	public static final String GXSYS_ACTIVITY = "REF";
	public static final String GXSYS_APP_STATUS_CODES = "REF";
	public static final String GXSYS_FEATURE = "REF";
	public static final String GXSYS_GLOBAL_COUNTRY = "REF";
	public static final String GXSYS_GLOBAL_LOOKUP = "REF";
	public static final String GXSYS_JOB_INSTANCES = "REF";
	public static final String GXSYS_JWT_KEYS = "REF";
	public static final String GXSYS_MENU = "REF";
	public static final String GXSYS_MENU_PERMISSION = "REF";
	public static final String GXSYS_MODULE = "REF";
	public static final String GXSYS_PERMISSION = "REF";
	public static final String GXSYS_PERMISSION_URL = "REF";
	public static final String GXSYS_PORTAL = "REF";
	public static final String GXSYS_ROUTING_TYPE = "REF";
	public static final String GXSYS_SEC_QUEST = "REF";
	public static final String GXSYS_SUB_FEATURE = "REF";
	public static final String GXSYS_SUB_FEATURE_CONFIG = "REF";
    public static final String GXSYS_PAYMENT_TYPE = "REF";
    public static final String GXSYS_USER_SETTINGS = "REF";
	public static final String GXSYS_DASHBOARD_LAYOUTS = "REF";
	public static final String GXSYS_FINANCIAL_INDUSTRIES = "REF";
	
	
    public static final String GXAIM_USER_SECUR_QUEST = "REF";
    
    public static final String GX_BANK_SERVICE_MAPPING = "REF";





    // Customer Procedure
    public static final String PR_GX_USER_VERIFY = "REF";
    public static final String PR_GX_SME_ACCOUNTS = "REF";
    public static final String PR_GX_INV_USER = "REF";
	public static final String pr_gx_usr_cnsnt_account = "REF";
	public static final String PR_GX_SME_ONBOARD = "REF";
  
	// AIM schema tables
    public static final String GXAIM_LOGIN_SESSIONS = "AIM";
    public static final String GXAIM_PWD_HISTORY = "AIM";
    public static final String GXAIM_PWD_RESET = "AIM";
    public static final String GXAIM_USER_CLAIMS = "AIM";
    public static final String GXAIM_USER_OTP = "AIM";
    public static final String GXAIM_USER_SESSIONS = "AIM";
    public static final String GXAIM_USER_SESSIONS_CHILD = "AIM";
    public static final String GXAIM_USERS = "AIM";
    public static final String GXSYS_CLIENTS = "AIM";
    public static final String GXAIM_CLIENT_TOKENS = "AIM";

 // PAY schema tables
	public static final String GXACC_CHEQUEBOOK_REQUEST = "PAY";
    public static final String GXACC_BALANCE_CONFIRMATION = "PAY";
    public static final String GXACC_DELIVERY_DETAILS = "PAY";
    public static final String GXACC_ESTATEMENT = "PAY";
    public static final String GXACC_FOREX_RATE = "PAY";
    public static final String GXACC_STATEMENT_REQUEST = "PAY";
    public static final String GXCBS_FX_QUOTE = "PAY";
    public static final String GXCBS_SO = "PAY";
    public static final String GXCBS_SO_TRANSACTIONS = "PAY";
    public static final String GXCBS_STATEMENT_HIST = "PAY";
	public static final String GXCBS_DIRECT_DEBITS = "PAY";
    public static final String GXCOL_PAYER = "PAY";
    public static final String GXCOL_PAYER_AUTHZ = "PAY";
    public static final String GXCOL_PAYER_AUTHZ_HIST = "PAY";
    public static final String GXCOL_PAYER_HIST = "PAY";
    public static final String GXCOL_PAYER_METROMAP = "PAY";
    public static final String GXCOL_RTP_METROMAP = "PAY";
    public static final String GXCOL_RTP_TRANSACTIONS = "PAY";
    public static final String GXCOL_RTP_TRANSACTIONS_CORE = "PAY";
    public static final String GXPAY_BENE_AUTHZ = "PAY";
    public static final String GXPAY_BENE_AUTHZ_HIST = "PAY";
    public static final String GXPAY_BENEFICIARY = "PAY";
    public static final String GXPAY_BENEFICIARY_HIST = "PAY";
    public static final String GXPAY_BENEFICIARY_METROMAP = "PAY";
    public static final String GXPAY_BULK_FILE_INVOICE = "PAY";
    public static final String GXPAY_BULK_FILE_RAW_DATA = "PAY";
    public static final String GXPAY_BULK_FILE_TRANSACTIONS = "PAY";
    public static final String GXPAY_BULK_METROMAP = "PAY";
    public static final String GXPAY_BULK_TRANSACTIONS_AUTHZ = "PAY";
    public static final String GXPAY_JOB_EXEC_PROCESS = "PAY";
    public static final String GXPAY_METROMAP = "PAY";
	public static final String GXSYS_BANK_BRANCH_HOLIDAY = "PAY";
    public static final String GXPAY_NONCE = "PAY";
    public static final String GXPAY_SO = "PAY";
    public static final String GXPAY_SO_TRANSACTIONS = "PAY";
    public static final String GXPAY_TRANSACTIONS = "PAY";
    public static final String GXPAY_TRANSACTIONS_AUTHZ = "PAY";
    public static final String GXPAY_TRANSACTIONS_CORE = "PAY";
    public static final String GXSYS_BULK_FILE_CONFIG = "PAY";
    public static final String GXSYS_BULK_FILE_CONFIG_PARAM = "PAY";
    public static final String GXSYS_CCIDENTIFIER = "PAY";
    public static final String GXSYS_COUNTRY_PURPOSE_CODE = "PAY";
    public static final String GXSYS_DOMESTIC_BANKS	= "PAY";
    public static final String GXSYS_GLOBAL_BANK = "PAY";
	public static final String GXSME_FEE_POSTING = "PAY";
    public static final String GXWPS_BULK_FILE_HDR_TRANSACTIONS = "PAY";
    public static final String GXWPS_BULK_FILE_TRANSACTIONS = "PAY";
    public static final String GXWPS_BULK_METROMAP = "PAY";
    public static final String GXWPS_BULK_TRANSACTIONS = "PAY";
    public static final String GXWPS_BULK_TRANSACTIONS_AUTHZ = "PAY";
    public static final String GXWPS_BULK_TRANSACTIONS_CORE = "PAY";
    public static final String GXWPS_PAYMENT_ROUTING_CODES = "PAY";
	public static final String GXSYS_BANK_GL = "PAY";
	public static final String GXBIL_BILLERS = "PAY";
	public static final String GXBIL_BILLERS_CATEGORY = "PAY";
	public static final String GXBIL_BILLERS_SERVICE = "PAY";
	public static final String GXBIL_BILLERS_SERVICE_PARAMS = "PAY";
	public static final String GXBIL_METROMAP = "PAY";
	public static final String GXBIL_PAYEE = "PAY";
	public static final String GXBIL_PAYEE_HIST = "PAY";
	public static final String GXBIL_SO = "PAY";
	public static final String GXBIL_SO_TRANSACTIONS = "PAY";
	public static final String GXBIL_TRANSACTIONS = "PAY";
	public static final String GXBIL_TRANSACTIONS_AUTHZ = "PAY";
	public static final String GXBIL_TRANSACTIONS_CORE = "PAY";
	public static final String BULK_FILE_TRANS_ID_SEQ = "PAY";
	public static final String GX_CHN_NO_SEQ = "PAY";
	public static final String GX_JOB_CHN_NO_SEQ = "PAY";
	public static final String INVOICE_FILE_ID_SEQ = "PAY";
	public static final String PR_GX_BULK_PAYMENT_VALIDATION = "PAY";
	public static final String pr_gx_bulk_file_trans_submit = "PAY";
	public static final String pr_gx_wps_bulk_submit = "PAY";
	public static final String statement_hist_id_seq = "PAY";
	public static final String BULK_HDR_TRANS_ID_SEQ = "PAY";
	public static final String BULK_UPD_TRANS_ID_SEQ = "PAY";
	public static final String bulk_trans_authz_id_seq = "PAY";
	public static final String trans_id_seq = "PAY";
	public static final String bulk_trans_id_seq = "PAY";
	public static final String bulk_trans__core_id_seq = "PAY";	
	public static final String GX_RTP_CHN_NO_SEQ = "PAY";
	public static final String rtp_metromap_id_seq = "PAY";
	public static final String bulk_metromap_id_seq = "PAY";
	public static final String bulk_wps_metromap_id_seq = "PAY";

	
	

 // RPT schema tables
    public static final String GXRPT_REPORT_JOB = "RPT";
    public static final String GXRPT_REPORT_JOB_OUTPUT = "RPT";
    public static final String GXRPT_SCHEDULED_REPORT = "RPT";
    public static final String GXSYS_REPORT_CATALOG = "RPT";
    public static final String GXSYS_REPORT_CATALOG_FORMATS = "RPT";
    public static final String GXSYS_REPORT_DESIGN = "RPT";

 // AUD schema tables
    public static final String GXEVE_USER_LOGIN_INOUT = "AUD";
    public static final String GXEVE_MESSAGE_ERROR = "AUD";
    public static final String GXEVE_EXTERNAL_APIS = "AUD";
    public static final String GXEVE_MESSAGE_ERROR_RETRY_HISTORY = "AUD";
    public static final String GXEVE_SYSTEM_AUDIT = "AUD";
    public static final String GXEVE_MESSAGE_ERROR_EVENT = "AUD";
    public static final String GXEXT_OUTBOUND_EVENT = "AUD";

 // NOT schema tables
    public static final String GXEVE_EMAIL_SMS_HIST = "NOT";
    public static final String GXNOT_NOTIFICATION_DELIVERIES = "NOT";
    public static final String GXNOT_NOTIFICATIONS = "NOT";

 // ============== Sequence=========================
	public static final String BENE_ID_SEQ = "PAY";
	public static final String BENE_METROMAP_ID_SEQ = "PAY";
	public static final String metromap_id_seq = "PAY";

	    
    
	// ============== SCHEMA  ==========================
//	public static final String santander = "santander.local";
	public static final String growx = "192.168.1.203";
	
	
	public static final String SANTANDER_LOCAL = "growx";

	public static final String DEMOLOGIN_GROWX_GLOBAL = "growx";
	public static final String SITLOGIN_GROWX_GLOBAL = "growx";
	public static final String UATLOGIN_GROWX_GLOBAL = "growx";
	
	public static final String DEMO_GROWX_GLOBAL = "growx";
	public static final String SIT_GROWX_GLOBAL = "growx";
	public static final String UAT_GROWX_GLOBAL = "growx";
	
	public static final String DEMOADMIN_GROWX_GLOBAL = "growx";
	public static final String SITADMIN_GROWX_GLOBAL = "growx";
	public static final String UATADMIN_GROWX_GLOBAL = "growx";
	
	public static final String GXSYS_TEMPLATES = "NOT";
	public static final String  pr_gx_bene_approve="PAY";
	public static final String PR_GX_FUTURE_TXN= "PAY";
	public static final String PR_GX_SO_TRANSACTIONS = "PAY";
	public static final String PR_GX_WPS_VALIDATE_BULK_FILE = "PAY";
	public static final String pr_gx_insert_transaction = "PAY";
	public static final String pr_gx_transaction_authz = "PAY";
	public static final String pr_gx_dashboard_count = "PAY";
	public static final String pr_gx_limit_check = "PAY";
	public static final String  forex_rate_id_seq = "PAY";
	public static final String trans_authz_hist_id_seq = "PAY";

	//Notification
	public static final String NOTIFICATION_ID_SEQ = "NOT";
	public static final String GXNOT_NOTIFICATION_HIST = "NOT";
	public static final String NOTIFICATION_HIST_ID_SEQ = "NOT";
	public static final String GXNOT_NOTIFY_CATEGORY = "NOT";
	public static final String GX_AUDIT_ID_SEQ = "AUD";

	    
    private static final Map<String, String> TABLE_MAP = new HashMap<>();

    static {

        try {

            Field[] fields = SchemaConstants.class.getDeclaredFields();

            for (Field field : fields) {

                if (Modifier.isStatic(field.getModifiers())
                        && field.getType().equals(String.class)) {

                    TABLE_MAP.put(
                            field.getName(),
                            (String) field.get(null)
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getValueByKey(String key) {
        return TABLE_MAP.get(key.toUpperCase());
    }

    public static String applySchema(String sql) {

        String schema = RequestHeaderUtil
                .getSchemaName();
        if (schema==null) {
        	  schema="growx";
		}
	 
        for (Map.Entry<String, String> entry : TABLE_MAP.entrySet()) {

            String table = entry.getKey();
            String schemaType = entry.getValue();

            String finalSchema =
                    schema +"_"+ schemaType.toLowerCase();

            sql = sql.replaceAll(
                    "(?i)\\b" + Pattern.quote(table) + "\\b",
                    finalSchema + "." + table
            );
        }

        return sql;
    }
    public static String getSchema(String sql) {

        String schema = RequestHeaderUtil
                .getSchemaName();
        if (schema==null) {
        	  schema="growx";
		}
	 
        for (Map.Entry<String, String> entry : TABLE_MAP.entrySet()) {

            String table = entry.getKey();
            String schemaType = entry.getValue();

            String finalSchema =
                    schema +"_"+ schemaType.toLowerCase();
            sql = sql.replaceAll(
                    "(?i)\\b" + Pattern.quote(table) + "\\b",
                    finalSchema
            );
        }

        return sql;
    }

    public static String getConstantNameByValue(String value) {
		try {
			Field[] fields = SchemaConstants.class.getDeclaredFields();
			for (Field field : fields) {
				if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
					Object fieldValue = field.get(null); // static fields => null instance
					if (fieldValue != null && fieldValue.equals(value)) {
						return field.getName();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; // Not found
}
  
}