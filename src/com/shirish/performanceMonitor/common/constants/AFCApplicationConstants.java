/**
 *
 */
package com.shirish.performanceMonitor.common.constants;

/**
 * 
 * @author shirish
 * @Oct 24, 2015
 *
 */
public interface AFCApplicationConstants
{

    public static final String DEV = "DEV";
    public static final String DEV3 = "DEV3";
    public static final String SYS = "SYS";
    public static final String UAT = "UAT";
    public static final String UAT3 = "UAT3";
    public static final String PROD = "PROD";

    public static final String DEV1 = "DEV1";
    public static final String SYS1 = "SYS1";
    public static final String UAT1 = "UAT1";

    public static final String OEC_ENV_Key = "OEC.ENV";
    public static final String OEC_ENV_Default_Value = "UAT1";

    public static final String SERVICE_FOR = "ServiceFor";
    public static final String APP_ENV_MAPPING = "Regionmap.appEnv";
    public static final String APP_SUB_ENV_MAPPING = "Regionmap.appSubEnv";
    public static final String SETTING_CERTIFICATE_ENABLED = "Certificate.enabled";
    public static final String SETTING_CXCODEENABLED_ENABLED = "CxCodeEnabled.enabled";
    public static final String SETTING_CERTIFICATE_DUMMY = "Certificate.dummy";
    public static final String SETTING_STOPWATCH_ENABLED = "Stopwatch.enabled";
    public static final String SETTING_VERRIFYFUND_ENABLED = "VerifyFund.enabled";
    public static final String SETTING_SECURITY_ENABLED = "Security.enabled";
    public static final String SETTING_RELATIONAL_LEDGER_ENABLED = "RelationalLedger.enabled";
    //    public static final String SETTING_UPDATE_METHOD_ENABLED = "Accessmethod.update.enabled";
    public static final String SETTING_SECURITY_RACF_MOCK = "Security.RacfMock";
    public static final String SECURITY_DATA_EXPIRE = "Security.dataExpire";
    public static final String SECURITY_TIMEOUT = "Security.timeOut";
    public static final String SECURITY_ASYNC_TIMEOUT = "Security.asyncTimeOut";
    public static final String SECURITY_CACHE_EXPIRE = "Security.cacheExpire";
    public static final String SETTING_ADMIN_IDF_AUTH_ENABLED = "AdminIDFAuth.enabled";
    public static final String SETTING_DATASOUECE_PICK_ENABLED = "DataSourcePick.enabled";
    public static final String SETTING_ACCESSMETHOD_UPDATE_ENABLED = "Accessmethod.update.enabled";
    public static final String SETTING_LUW_USE_CONNCECTION_ENABLED = "LUW.useconncection.enabled";
    public static final String SETTING_PROCESS_ID_ROLE_DATA_CATEGORY = "Security.ProcessIdRoleCategory";
    public static final String SETTING_PROCESS_ID_ROLE_DATA_VALUE = "Security.ProcessIdRoleValue";
    public static final String SETTING_SECURITY_PROVIDER_ESF = "Security.QTM_ESF.security-provider-class";
    public static final String SETTING_SECURITY_PROVIDER_RACF = "Security.QTM_RACF.security-provider-class";
    public static final String SETTING_SECURITY_PROVIDER_LUW = "Security.QTM_LUW.security-provider-class";
    public static final String SAVE_STOP_WATCH_TO_FILE_ENABLED = "SaveStopWatchToFile.enabled";
    public static final String SAVE_STOP_WATCH_ENABLED = "SaveStopWatch.enabled";
    public static final String XDATA_CHANNELS_ENABLED = "xdata.channels.enabled";
    public static final String SAVE_STOP_WATCH_MEDIATOR = "SaveStopWatch.mediator";
    public static final String SAVE_STOP_WATCH_CLOUD_URL = "SaveStopWatch.cloudURL";
    public static final String DSH_CLOUD_URL = "DSH.cloudURL";
    public static final String DSH_FAILOVER_CLOUD_URL = "DSH.failOverCloudURL";
    public static final String DSH_PWM_SERVER = "DSH.PWM_SERVER";
    public static final String DSH_USER_ID = "DSH.USER_ID";
    public static final String DSH_SERVICE_USEDIRECT = "DSH_SERVICE_USEDIRECT";
    public static final String FUND_GROUP_REFRESH_TIMEOUT = "FUND_GROUP_REFRESH_TIMEOUT";
    public static final String ENTITY_ITEM_BATCH_SIZE = "ENTITY_ITEM_BATCH_SIZE";
    public static final String ENTITY_GROUP_UPDATE_BATCH_SIZE = "ENTITY_GROUP_UPDATE_BATCH_SIZE";
    public static final int ENTITY_ITEM_BATCH_SIZE_DEFAULT_VALUE = 300000;
    public static final int ENTITY_GROUP_UPDATE_BATCH_SIZE_DEFAULT_VALUE = 200;
    public static final String CLOUD_SIGNON_USERID = "CloudSignOn.user";
    public static final String CLOUD_SIGNON_SERVER = "CloudSignOn.server";
    public static final String MQ_HOSTNAME = "MQ.hostname";
    public static final String MQ_CHANNEL = "MQ.channel";
    public static final String MQ_QMANAGER = "MQ.qManager";
    public static final String MQ_DMEQUEUE = "MQ.dmeQueue";
    public static final String MQ_PORT = "MQ.port";
    public static final String THIS_CONTEXT_TYPE = "this.contextType";
    public static final String SECURITY_ASYNCHRONOUS_ENABLED = "Security.Asynchronous.enabled";
    public static final String ASYNC = "ASYNC";
    public static final String SYNC = "SYNC";

    public static final String SETTING_PROCESS_ID_ROLE_FUNCTION_CODE = "Security.ProcessIdRoleFunction";
    public static final String AFC_ALLOWED_RESOURCE_LIMIT = "AFCResourcePool.limit";
    public static final String AFC_RESOURCE_POOL_KEY = "AFC_RESOURCE_POOL_KEY";
    public static final int AFC_ALLOWED_DEFAULT_COUNT = 100;
    public static final int SECURITY_DATA_EXPIRE_DEFAULT_VALUE = 720;
    public static final long SECURITY_TIMEOUT_DEFAULT_VALUE = 720 * 60 * 1000;
    public static final long SECURITY_ASYNC_TIMEOUT_DEFAULT_VALUE = 360 * 60 * 1000;
    public static final long FUND_GROUP_REFRESH_TIMEOUT_DEFAULT_VALUE = 30 * 60 * 1000;
    public static final int SECURITY_CACHE_EXPIRE_DEFAULT_VALUE = 720;

    public static final String AFC_CONFIG_IDF_PUBLISH = "AFC.CONFIG.IDF.PUBLISH.";
    public static final String AFC_CONFIG_ENTITYNAME_PUBLISH = "AFC.CONFIG.ENTITYNAME.PUBLISH.";
    public static final String AFC_CONFIG_APPLICATION = "AFC.CONFIG.APPLICATION.";
    public static final String AFC = "AFC";
    public static final String DOT = ".";
    public static final String Y = "Y";
    public static final String YES = "YES";
    public static final String TRUE = "TRUE";
    public static final String N = "N";
    public static final String DELIMITER = "||";
    public static final String ALL = "ALL";
    public static final int RS_FETCH_SIZE = 500;

    public static final String SETTING_AFCLOG_LEVEL = "AFCLog.level";

    public static final String REGION_DATA_NOTEXISTS = "REGION_DATA_NOTEXISTS";

    //    public static final String REGION_USER_NOENTITLEMENT = "REGION_USER_NOENTITLEMENT";

    public static final String REGION_FUND_HEADER_NO_DATA = "REGION_CALL_FUND_HEADER_FAIL";

    public static final String SETTING_PLATFORM_CODE = "Platform.code";
    public static final String PLATFORM_CLOUD = "CLOUD";
    public static final String PLATFORM_NONCLOUD = "NONCLOUD";

    public static final String REQUEST_ID = "REQUEST_ID";
    public static final String USER_ID = "USER_ID";
    public static final String CLIENT_APP_REQUEST_ID = "CLIENT_APP_REQUEST_ID";
    public static final String CERTIFICATE = "CERTIFICATE";
    public static final String FAW_APP_CONTEXT = "FAW.app.context";
    public static final String FAW_APP_HOSTNAME = "FAW.app.hostname";
    public static final String ENTITYNAME = "ENTITYNAME";
    public static final String CRITERIA = "CRITERIA";

    public static final String IGNORE_WARNING = "IGNORE_WARNING";
    public static final String UNIQUE_REC_ONLY = "UNIQUE_REC_ONLY";
    public static final String SECURITY_SOURCE_CODE = "SECURITY_SOURCE_CODE";
    public static final String SETTING_QTM_CERTIFICATE = "QTM.CERTIFICATE";

    public static final String APP_TYPE = "APP_TYPE";
    public static final String APP_TYPE_DEFAULT = "DEFAULT";
    public static final String APP_TYPE_ONLINE = "ONLINE";

    public static final String APP_ID_DEFAULT = "APP_ID_DEFAULT";

    public static final String PRIMARY_DATASOURCE = "PRIMARY_DATASOURCE";

    public static final String SECONDARY_DATASOURCE = "SECONDARY_DATASOURCE";
    public static final String CD = "CD";
    public static final String MINUS_ONE = "-1";
    public static final String PD = "PD";
    public static final String NBD = "NBD";

    public static final String DATA_SOURCE_PROFILE = "DATA_SOURCE_PROFILE";
    public static final String SECURITY_PROVIDER_MAP = "SECURITY_PROVIDER_MAP";
    public static final String AFC_SECURITY_SCHEDULER = "AFC_SECURITY_SCHEDULER";
    public static final String AFC_HEARTBEAT_READ_SCHEDULER = "AFC_HEARTBEAT_READ_SCHEDULER";
    public static final String AFC_QUARTZ_JOB_USER_INPUT_CRITERIA = "AFC_QUARTZ_JOB_USER_INPUT_CRITERIA";
    public static final String AFC_QUARTZ_JOB_USER = "AFC_QUARTZ_JOB_USER";
    public static final String AFC_QUARTZ_JOB_SESSION_USER_ID = "AFC_QUARTZ_JOB_SESSION_USER_ID";
    public static final String AFC_QUARTZ_JOB_CERTIFICATE = "AFC_QUARTZ_JOB_CERTIFICATE";
    public static final String AFC_QUARTZ_JOB_REQUEST_ID = "AFC_QUARTZ_JOB_REQUEST_ID";
    public static final String AFC_QUARTZ_JOB_USER_FROM_SESSION_THREAD_DATA = "AFC_QUARTZ_JOB_USER_FROM_SESSION_THREAD_DATA";
    public static final String AFC_QUARTZ_JOB_MCH_USER_FROM_SESSION_THREAD_DATA = "AFC_QUARTZ_JOB_MCH_USER_FROM_SESSION_THREAD_DATA";
    public static final String AFC_QUARTZ_JOB_CLIENT_REQUEST_ID = "AFC_QUARTZ_JOB_CLIENT_REQUEST_ID";
    public static final String AFC_QUARTZ_JOB_PICKED_DATA_SOURCE_STATUS = "AFC_QUARTZ_JOB_PICKED_DATA_SOURCE_STATUS";

    public static final String AFC_THREAD_DATA_MAP = "AFC_THREAD_DATA_MAP";
    public static final String AFC_ACCESS_LOGIC = "AFC_ACCESS_LOGIC";
    public static final String AFC_CERTIFICATE = "AFC_CERTIFICATE";
    public static final String AFC_SESSION_USER_ID = "AFC_SESSION_USER_ID";
    public static final String AFC_SESSION_USER_PASSWORD = "AFC_SESSION_PASSWORD";
    public static final String SESSION_USER_ID = "SESSION_USER_ID";
    public static final String SESSION_USER_PASSWORD = "SESSION_USER_PASSWORD";

    public static final String NAVLAB = "NAVLAB";
    public static final String YIELD = "YIELD";
    public static final String VVDR = "VVDR";

    public static final String RATES_YIELDS_SERVICE_PROVIDER_URL = "RATES_YIELDS_SERVICE_PROVIDER_URL";
    public static final String RATES_YIELDS_SERVICE_USER_ID = "RATES_YIELDS_SERVICE_USER_ID";
    public static final String RATES_YIELDS_SERVICE_PROVIDER_PWM_SERVER = "RATES_YIELDS_SERVICE_PROVIDER_PWM_SERVER";
    public static final String RATES_YIELDS_SERVICE_USEDIRECT = "RATES_YIELDS_SERVICE_USEDIRECT";

    public static final String ESF_WEB_SERVICE_PROVIDER_URL = "esfWebServiceProvider.URL";
    public static final String ESF_WEB_SERVICE_PROVIDER_USER_ID = "esfWebServiceProvider.USER_ID";
    public static final String ESF_WEB_SERVICE_PROVIDER_PWM_SERVER = "esfWebServiceProvider.PWM_SERVER";
    public static final String SECURITY_ENTITLEMENTS_CACHE_OPTION = "Security.Entitlements.cacheOption";
    public static final String FAW_CLOUD_RESULTSET_PAGESIZE = "FAW.cloudResultSet.PageSize";
    public static final String ESF_WEB_SERVICE_PROVIDER_FETCH_SIZE = "esfWebServiceProvider.FETCH_SIZE";

    public static final String ESF_CHANNELS_IDF = "xdata.channels.rules.afc_esf_fault_tolerance_rule.pattern";
    public static final String ESF_CHANNELS_BG1_URL = "ESF.channels.bg1.url";
    public static final String ESF_CHANNELS_BG2_URL = "ESF.channels.bg2.url";
    public static final String ESF_CHANNELS_BK_URL = "ESF.channels.bk.url";
    public static final String ESF_UPDATE_LUW_DATA_TO_MCHDB2_ENABLE = "ESF.updateEntitlementFromLuwToDB2.enable";

    public static final String DSH_FETCH_SIZE = "DSH.FETCH_SIZE";
    public static final String LOCK_TIME_OUT = "DSH.lockTimeOut";
    public static final String CLIENT_PROFILE = "CLIENT_PROFILE";
    public static final String APP_CODE = "APP_CODE";

    public static final String MFA_LOCAL_CALL = "MFA.LOCAL_CALL";
    public static final String TRUSTED_ID_VALIDATION_ENABLE = "TRUSTEDID.VALIDATION.ENABLE";

    public static final String APRVD = "APRVD";
    public static final String SLV = "SLV";
    public static final String FDR = "FDR";

    public static final String LUW = "LUW_SCHEMA_CD";
    public static final String MCHDB2 = "MF_SCHEMA_CD";
    //scheduler name
    public static final String AFC_STOPWATCH_SCHEDULER = "AFC_STOPWATCH_SCHEDULER";
    public static final String AFC_ENTITY_GROUP_ITEMS_CLEAN_SCHEDULER = "AFC_ENTITY_GROUP_ITEMS_CLEAN_SCHEDULER";
    public static final String AFC_ESF_BATCH_VALIDATION_SCHEDULER = "AFC_ESF_BATCH_VALIDATION_SCHEDULER";

    public enum AFCPriceTypeEnum {
        BD, MN, OF, MP
    };

    public static final String STOPWATCH_RECORD_THRESHOLD = "Stopwatch.threshold";
    public static final int STOPWATCH_RECORD_DEFAULT_THRESHOLD = 100;

    public static final String STOPWATCH_WRITE_WAIT_TIME_MS = "Stopwatch.writeWaitTime";
    public static final long STOPWATCH_DEFAULT_WRITE_WAIT_TIME_MS = 5 * 60 * 1000;

    public static final String ENTITY_GRP_CLEAN_TRIGER_WAIT_TIME_MS = "Scheduler.AFC_ENTITY_GROUP_ITEMS_CLEAN_SCHEDULER.trigerWaitTime";
    public static final long ENTITY_GRP_DEFAULT_CLEAN_TRIGER_WAIT_TIME_MS = 20 * 60 * 1000;

    public static final String ESF_BATCH_VALIDATION_TRIGER_WAIT_TIME_MS = "Scheduler.AFC_ESF_BATCH_VALIDATION_SCHEDULER.trigerWaitTime";
    public static final long ESF_BATCH_VALIDATION_DEFAULT_TRIGER_WAIT_TIME_MS = 10 * 60 * 1000;

    public static final String ESFPROXY_ENABLE = "EsfProxy.enable";
    public static final String FAULTTOLERANCE_ENABLE = "FaultTolerance.enable";
    public static final String MAX_LOCK_AGE_IN_MINUTES = "MAX_LOCK_AGE_IN_MINUTES";
    public static final long MAX_LOCK_AGE_IN_MINUTES_DEFAULT_VALUE = 5; //default value

    public static final String ESF_ENABLE_KEY = "EsfProxyEnable"; // esf proxy clean switch
    public static final String STATISTICS_ENABLE_KEY = "entityStatisticsEnable"; //statistic clean switch
    public static final String ENTITYGROUP_ENABLE_KEY = "entityGroupEnable"; //entity group clean switch

    public static final String TASK_STATS_DELETE_DATE_KEY = "taskStatsDeleteDate";
    public static final String DEMAND_STATS_DELETE_DATE_KEY = "demandStatsDeleteDate";
    public static final String TRANS_RATE_STATS_DELETE_DATE_KEY = "transRateStatsDeleteDate";
    public static final String RESOURCE_STATS_DELETE_DATE_KEY = "resourceStatsDeleteDate";
    public static final String ENTITY_STATISTICS_DELETE_DATE_KEY = "statisticsStatsDeleteDate";

    public static final String ESF_USE_PERSISTENT_CACHE = "ESF_USE_PERSISTENT_CACHE";

    public static final Integer DEBUG_LVL = 1;
    public static final Integer THREAD_ID = 12345;
    public static final Integer API_VERSION_ID = 1;

    public static final long DAY_TO_MILLI = 24 * 60 * 60 * 1000;
    public static final long HOUR_TO_MILLI = 60 * 60 * 1000;
    public static final String DEFAULT_TIME_OF_DELETE = "30d";

    public static final String APPROVED = "APPROVED";
    public static final String LATEST = "LATEST";
    public static final String KFS = "KFS";

    public static final String RACF_BG_ENTITLEMENT_ENABLE = "RacfBg.Entitlement.Enable";
    public static final String RACF_MFA_REMOTE_CALL = "RACF_MFA_REMOTE_CALL";

    public static final String SECURITY_CLOSE_TO_EXPIRY_TIME = "SECURITY_CLOSE_TO_EXPIRY_TIME";

    public static final String SECURITY_EXTEND_HOURS = "SECURITY_EXTEND_HOURS";
    public static final int SECURITY_EXTEND_HOURS_DEFAULT_VALUE = 6;
    
    public static final String SECURITY_BATCH_USER_SIZE = "SECURITY_BATCH_USER_SIZE";
    public static final int SECURITY_BATCH_USER_SIZE_DEFAULT_VALUE = 300;
    
    public static final String SECURITY_SOURCE_TO_UPDATE = "SECURITY_SOURCE_TO_UPDATE";
    public static final String SECURITY_SOURCE_TO_UPDATE_DEFAULT_VALUE = "QTM_ESF,QTM_RACF";

}
