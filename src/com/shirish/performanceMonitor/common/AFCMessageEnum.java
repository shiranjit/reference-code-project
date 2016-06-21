


package com.shirish.performanceMonitor.common;

import org.apache.commons.codec.binary.StringUtils;

import com.shirish.performanceMonitor.common.constants.AFCMessageConstants;

/**
 * 
 * @author shirish
 * @Oct 24, 2015
 *
 */
public enum AFCMessageEnum {

    //@off
    /**
     * do not format this class!!! do not format this class!!! do not format
     * this class!!! do not format this class!!!
     */
    SUCCESS(0, AFCMessageConstants.INFO, "success return"),

    /**
     * 1-100 , business data related error
     */
    WARNING_GET_DATA_FAILED(1, AFCMessageConstants.WARN, "The query returned invalid data for: %s"), WARNING_NOT_A_MULTI_MANAGED_FUND(1, AFCMessageConstants.WARN, "Requested Fund is not Multi-Managed: %s"), WARNING_PARTIAL_DATA(2, AFCMessageConstants.WARN, "The query returned partial data results for: %s"), WARNING_DATA_NOT_FOUND(3, AFCMessageConstants.WARN, "No data for Input: %s"), WARNING_FUND_HEADER_NO_DATA(3, AFCMessageConstants.WARN, "Fund header not found: %s"), //not in the list
    WARNING_CONTROL_REGION_NOT_FOUND(3, AFCMessageConstants.WARN, "No control region found for fund: %s"), //not in the list
    WARNING_CONTROL_REGION_IS_INVALID(3, AFCMessageConstants.WARN, "Fund's Control region %s is invalid, criteria is %s"), //not in the list TODO
    WARNING_ACCRUAL_DAYS_NULL(3, AFCMessageConstants.WARN, "AccrualDays is null for fund: %s "), //not in the list TODO
    WARNING_ELEC_IS_NOT_SETUP_FOR_FUND(3, AFCMessageConstants.WARN, "%s service election is not setup for the fund: %s "), //not in the list TODO
    WARNING_USER_NOENTITLEMENT_FOR_FUND(3, AFCMessageConstants.WARN, "User is not entitled to fund: %s"), //not in the list
    ERROR_UNTRUSTED_DATA_FOUND(4, AFCMessageConstants.ERROR, "Data is Not Trusted"), //not in the list


    /**
     * 101-200, User input related error
     */
    ERROR_MISS_MANDATORY_PARAMS(101, AFCMessageConstants.ERROR, "Please provide all required input."), ERROR_ENTITY_IS_NOT_SUPPORTED(102, AFCMessageConstants.ERROR, "Entity %s not supported."), ERROR_TASK_IS_NOT_SUPPORTED(102, AFCMessageConstants.ERROR, "Task %s is not supported"), ERROR_ENTITY_IS_NULL_OR_EMPTY(102, AFCMessageConstants.ERROR, "Please provide entity name in input."), ERROR_ACCESS_METHOD_IS_NOT_SUPPORTED(103, AFCMessageConstants.ERROR, "Access method: %s is not supported for entity: %s"), ERROR_ACCESS_METHOD_IS_NULL_OR_EMPTY(103, AFCMessageConstants.ERROR, "Please provide entity name in input."), ERROR_ACCESS_METHOD_IS_NOT_SUPPORTED_FOR_NONCONVERTED_FUND(103, AFCMessageConstants.ERROR, "Access method: %s is not supported for non-converted fund: %s"), //TODO Access method: %s is not supported for entity: %s
    ERROR_CERTIFICATE_IS_NOT_SUPPORTED(104, AFCMessageConstants.ERROR, "Invalid certificate:%s"), ERROR_CERTIFICATE_IS_NULL_OR_EMPTY(104, AFCMessageConstants.ERROR, "Please provide certificate in input."), ERROR_CERTIFICATE_IS_EXPIRED(105, AFCMessageConstants.ERROR, "Certificate ID %s is expired or not supported"), ERROR_CRITERIA_IS_EMPTY(106, AFCMessageConstants.ERROR, "criteria is empty or null"), ERROR_CRITERIA_IS_NOT_SUPPORTED(106, AFCMessageConstants.ERROR, "criteria:( %s) is not supported for entity: %s"), ERROR_CATEGORY_NOT_SUPPORTED(106, AFCMessageConstants.ERROR, "%s is not supported"), ERROR_CRITERIA_IS_NOT_SUPPORTED_FOR_FIELD(106, AFCMessageConstants.ERROR, "criteria:( %s) is not supported for entity: %s, %s only support characters in [%s]"), ERROR_INPUT_FIELD_NOT_SUPPORTED(106, AFCMessageConstants.ERROR, "%s = %s is not supported, only %s is supported"), ERROR_CRITERIA_IS_DUPLICATED(106, AFCMessageConstants.ERROR, "Duplicate: %s"), ERROR_CRITERIA_IS_NOT_SUPPORTED_FOR_MULTIPLE_FUND(106, AFCMessageConstants.ERROR, "Multiple fund input not allowed for access method: %s for entity: %s"), ERROR_FIELD_REQUIRED_FOR_ALL_CRITERIA(106, AFCMessageConstants.ERROR, "Input field: %s required for all the criteria"), ERROR_CRITERIA_IS_NOT_SUPPORTED_FOR_MULTIPLE_CRITERIA(106, AFCMessageConstants.ERROR, "only one posting reversal is allowed in a single WS call"), ERROR_CRITERIA_NOT_RECOMMANDED_IGNORE_SVC(106, AFCMessageConstants.ERROR, "Warning: Criteria is not recommanded, ignoring Service_CD"), ERROR_CRITERIA_NOT_RECOMMANDED_DEFAULT_CLC(106, AFCMessageConstants.ERROR, "Warning: Criteria is not recommanded, default to anchor Set_of_Book"), ERROR_CRITERIA_PARSE_FAILED(107, AFCMessageConstants.ERROR, "Invalid data format: %s"), ERROR_PARAM_DATE_ISSUE(107, AFCMessageConstants.ERROR, "Unexpected data format: %s, pattern is: %s"), ERROR_DATE_ISSUE(107, AFCMessageConstants.ERROR, "End Date cannot be earlier than start date"), ERROR_TIME_REGION_OUT_OF_RANGE(108, AFCMessageConstants.ERROR, "time region out of range : %s"), ERROR_BIGDECIMAL_DATA_RANGE(108, AFCMessageConstants.ERROR, "Invalid input value: %s, should be <=1"), ERROR_APP_CODE_NOT_SET_FOR_APP_ID(110, AFCMessageConstants.ERROR, "APP_CODE not set for APP_ID: %s, certificate is %s"), ERROR_FUND_NOT_SETUP(111, AFCMessageConstants.ERROR, "Fund:%s is not set up for %s distribution"),
    /**
     * 201-300, AFC framework related error
     */
    ERROR_SQL_SP_RUN_FAILED(202, AFCMessageConstants.ERROR, "SQL or stored prcodure run fail"), ERROR_GET_STATEMENT_FAILED(202, AFCMessageConstants.ERROR, "Fail to create statement"), ERROR_SQL_SP_RUN_FAILED_MORE_MSG(202, AFCMessageConstants.ERROR, "SQL or stored prcodure run fail:%s"), ERROR_GET_RESULT_SET_FAIL(202, AFCMessageConstants.ERROR, "Fail to get data from result Set:%s"), ERROR_ENTITLEMENT_UPDATE(202, AFCMessageConstants.ERROR, "Error while updating entitlements."), ERROR_HIGH_TRAFFIC(203, AFCMessageConstants.ERROR, "AFC Webservices experiencing high traffic. Please retry after some time."), FATAL_INTERNAL_ISSUE(204, AFCMessageConstants.FATAL, "AFC internal configuration issue, system init fail", "CXOWS006", "UXOWS006"), ERROR_INTERNAL_PARAM_ISSUE(205, AFCMessageConstants.ERROR, "System error, invalid param is %s"), ERROR_CALL_IDF_FAILED(205, AFCMessageConstants.ERROR, "System error, failed to call MCH IDF: %s"), ERROR_BUILD_WSDATA_FAIL(205, AFCMessageConstants.ERROR, "System error, failed to call MCH IDF: %s"), ERROR_CALL_CLOUD_FAIL(205, AFCMessageConstants.ERROR, "System error, failed to call cloud IDF: %s"), ERROR_FAILED_TO_CLONE_REQUEST_LIST_CRITERIA(205, AFCMessageConstants.ERROR, "failed to clone RequestListCriteria: %s"), ERROR_PARAM_COLUMN_ROW_ISSUE(205, AFCMessageConstants.ERROR, "System error, column length exceeds row length. column length is: %s, row length is: %s"), WARN_ENTITLEMENT_IS_UPDATING(206, AFCMessageConstants.WARN, "This user's entitlements are being refreshed. Please retry after some time."), ERROR_ADD_JOBLISTENER(207, AFCMessageConstants.ERROR, "Error in adding job listener"), ERROR_ADD_JOB_TO_SCHEDULER(207, AFCMessageConstants.ERROR, "Error in adding job to scheduler"), ERROR_SCHEDULING_JOB(208, AFCMessageConstants.ERROR, "Error in scheduling job"), ERROR_STARTING_SCHEDULE(209, AFCMessageConstants.ERROR, "Error in starting schedule"), ERROR_TRIGER_SCHEDULE(209, AFCMessageConstants.ERROR, "Error in generate triger"), ERROR_GET_TRIGER_SCHEDULE(209, AFCMessageConstants.ERROR, "Error in get triger or job detail"), ERROR_CLASS_NOT_FOUND(209, AFCMessageConstants.ERROR, "Class not found error"), ERROR_SHUTDOWN_SCHEDULE(209, AFCMessageConstants.ERROR, "Error in shutting down schedule"), ERROR_GET_SCHEDULE_START_STATUS(209, AFCMessageConstants.ERROR, "Error in get schedule status"), ERROR_INIT_SCHEDULE_FROM_FACTORY(210, AFCMessageConstants.ERROR, "Error in init schedule from factory, config file : %s"), ERROR_FUND_IS_LOCKED(211, AFCMessageConstants.ERROR, "Fund is Locked. Please try after some time"), ERROR_APP_INIT_FAILED(212, AFCMessageConstants.ERROR, "APP %s init failed!"), ERROR_MQ_ISSUE(213, AFCMessageConstants.ERROR, "failed to call MQ "), ERROR_UPDATE_ENTITLEEMNTS(214, AFCMessageConstants.ERROR, "Error while updating the entitlements to the database for schema: %s", "CXOWS408", "UXOWS408"), ERROR_DAO_NOT_FOUND(215, AFCMessageConstants.ERROR, "can't found correct DAO for the entity: %s"), ERROR_INVALID_DATASOURCE_TYPE(215, AFCMessageConstants.ERROR, "the data source type was invalid, dataSourceType: %s"), ERROR_FUND_IS_NOT_SETUP_CORRECTLY_IN_THE_ACCT_FUND_ELECTION(216, AFCMessageConstants.ERROR, "Fund is not setup correctly in the Acct Fund Election: %s"), ERROR_CHECK_USER_TRUSTED(217, AFCMessageConstants.ERROR, "TrustedId verification failed. Detailed error is:[ %s]"), ERROR_ESF_FAULT_TOLERANCE(218, AFCMessageConstants.FATAL, "AFC ESF fault tolerance failed cause three context count are different", "CXOWS006", "UXOWS006"), ERROR_ESF_FAULT_TOLERANCE_PHYSICAL(218, AFCMessageConstants.FATAL, "AFC ESF fault tolerance failed cause background task not completed", "CXOWS006", "UXOWS006"), ERROR_ASYN_UDPATE_SECURITY(219, AFCMessageConstants.FATAL, "Asyn update security failed"), ERROR_UPDATE_ENTITY_GROUP(220, AFCMessageConstants.ERROR, "Error when update entity group"),

    /**
     * 301-400, AFC external system related error
     */
    FATAL_ESF_SYSTEM_IS_DOWN(301, AFCMessageConstants.FATAL, "Unable to get entitlemetns from eSF. Detailed error is:[ %s]", "CXOWS417", "UXOWS417"), //TODO 
    FATAL_MCH_IS_DOWN(302, AFCMessageConstants.FATAL, "Unable to call MCH. Detailed error is:[ %s]", "CXOWS412", "UXOWS412"), //TODO 
    FATAL_DB_IS_DOWN(303, AFCMessageConstants.FATAL, "Not able to get connection to the Data Source: %s", "CXOWS408", "UXOWS408"), ERROR_UPDATE_ENTITLMENT_MCH(304, AFCMessageConstants.ERROR, "User ID is not set-up in MCH"), ERROR_UPDATE_ENTITLMENT_ESF(304, AFCMessageConstants.ERROR, "User ID %s is not set-up in %s security provider"), ERROR_NO_FUND_ID_FOR_USER(305, AFCMessageConstants.ERROR, "User ID %s is not assoicated to any fund in Cache table"), ERROR_LOGIN_REGION_NOT_FOUND(306, AFCMessageConstants.ERROR, "No login region or login region not found for session sysid %s"), ERROR_SEND_DATA_TO_MQ(307, AFCMessageConstants.ERROR, "Fail to send stop watch data to MQ, ErrorCode and ErrorMsg is: "), ERROR_SET_AUTOCOMMIT_FAIL(308, AFCMessageConstants.ERROR, "failed to set autoCommit"), ERROR_CURRENT_ROW_IS_NULL(308, AFCMessageConstants.ERROR, "current row is null, please call next() first"), ERROR_UPDATE_COMAREA(309, AFCMessageConstants.ERROR, "MCH program execute fail, COMAREA UPDATE ERROR: "),

    ;


    /**
     * do not format this class!!! do not format this class!!! do not format
     * this class!!! do not format this class!!!
     */
    //@on

    private AFCMessageEnum(int code, String severity, String message) {

        this( code, severity, message, null, null );
    }

    private AFCMessageEnum(int code, String severity, String message, String cxCode, String uxCode) {

        this.code = code;
        this.severity = severity;
        this.message = message;
        this.cxCode = cxCode;
        this.uxCode = uxCode;
    }


    private int    code;
    private String severity;
    private String message;
    private String cxCode;
    private String uxCode;


    public int getCode() {

        return code;
    }

    public String getSeverity() {

        return severity;
    }

    public String getMessage( Object... args ) {

        if ( (message != null && !message.equalsIgnoreCase( "" )) && args != null && args.length != 0 ) {
            return String.format( message, args );
        }
        return message;
    }

    public String getCxCode() {

        return cxCode;
    }

    public void setCxCode( String cxCode ) {

        this.cxCode = cxCode;
    }

    public String getUxCode() {

        return uxCode;
    }

    public void setUxCode( String uxCode ) {

        this.uxCode = uxCode;
    }

    public void setSeverity( String severity ) {

        this.severity = severity;
    }

    public void setMessage( String message ) {

        this.message = message;
    }

}
