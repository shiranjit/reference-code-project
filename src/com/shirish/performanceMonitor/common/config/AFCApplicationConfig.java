/**
 *
 */



package com.shirish.performanceMonitor.common.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.shirish.performanceMonitor.common.AFCLogger;
import com.shirish.performanceMonitor.common.constants.AFCApplicationConstants;


public class AFCApplicationConfig {

    private static final AFCLogger      log                           = AFCLogger.getLogger( AFCApplicationConfig.class );
    private static AFCApplicationConfig instance;
    private String                      platformCd                    = null;
    private String                      appENV                        = null;
    private String                      appSubENV                     = null;
    private String                      contextNm                     = null;
    private String                      hostName                      = null;
    private Map <String, String>        entityNameDaoMap;
    private Map <String, String>        virtualEntityNameDaoMap;

    // from database
    private Map <String, String>        dbSettingsMap                 = new HashMap <String, String>();                    // all
    private boolean                     isCertificateEnabled          = true;
    private boolean                     isSecurityEnabled             = true;
    private boolean                     isVerifyFundEnable            = false;
    private boolean                     isStopWatchEnabled            = false;
    private boolean                     isAdminIDFAuthEnabled         = false;
    private boolean                     isRelationalLedgerEnabled     = false;
    private boolean                     isSecurityRacfMockEnabled     = false;
    private boolean                     isUpdateAccessEnabled         = true;
    private boolean                     isChannelEnabled              = false;
    private boolean                     isLuwUseGenConnection         = false;
    private boolean                     isSecurityAsynchronousEnabled = true;
    private String                      securityProviderESF;
    private String                      securityProviderRACF;
    private int                         securityDataExpire            = 720;
    private long                        securityTimeout               = 720 * 60 * 1000;
    private long                        securityAsyncTimeout          = 360 * 60 * 1000;
    private long                        fundGroupRefreshTimeout       = 30 * 60 * 1000;
    private int                         securityCacheExpire           = 720;
    private int                         allowedResourcePoolLimit      = 100;
    private String                      processIdRoleDataCategory;
    private String                      processIdRoleDataValue;
    private String                      processIdRoleFunctionCode;
    private boolean                     isInitialized                 = false;
    private String                      activeAlertLevel;
    private String                      securityProviderLUW;
    private String                      ratesYieldsServiceProviderUrl;
    private String                      ratesYieldsServiceUserId;
    private int                         stopWatchRecordThreshold;
    private long                        stopWatchWriteWaitTime;
    private long                        entityGrpTrigerWaitTime;
    private long                        eSFbatchValidationTrigerWaitTime;
    private boolean                     isRatesYieldsServiceUseDirectAppCall;
    private boolean                     isDshServiceUseDirectAppCall;
    private boolean                     isEsfProxyEnable;
    private boolean                     isFaultToleranceEnable;
    private int                         entityGroupDetailBatchCount;
    private int                         entityGroupUpdatedBatchCount;
    private boolean                     isRacfBGEntitlementsEnable;
    private boolean                     isRacfMFARemoteCall;
    private String                      securityCloseToExpiryTime;
    private int                         securityExtendHours;
    private String                      securitySourceToUpdate;
    private int                         securityBatchUserSize;


    /**
     *
     */
    private AFCApplicationConfig() {

    }

    /**
     * Singleton getInstance method
     * 
     * @return
     */
    public static AFCApplicationConfig getInstance() {

        if ( instance == null || !instance.isInitialized() ) {
            synchronized ( AFCApplicationConfig.class ) {
                if ( instance == null || !instance.isInitialized() ) {
                    instance = new AFCApplicationConfig();
                    try {
                        instance.init();
                        instance.setInitialized( true );
                    }
                    catch ( Exception e ) {
                        // e = AFCException.createAFCException(FATAL_INTERNAL_ISSUE, e);
                        throw new RuntimeException( e );
                    }
                }
            }
        }
        return instance;
    }

    public synchronized void refresh() {

        setInitialized( false );
    }

    public boolean isInitialized() {

        return isInitialized;
    }

    public void setInitialized( boolean isInitialized ) {

        this.isInitialized = isInitialized;
    }

    private void init() {

        loadStaticProperties();


        loadDynamicProperties();
    }

    private void loadStaticProperties() {

        // read from setting.xml
        //        platformCd = PropertyManager.getStringProperty(AFCApplicationConstants.SETTING_PLATFORM_CODE, AFCApplicationConstants.PLATFORM_CLOUD);
        //        // read from cloud system property
        //        appENV = PropertyManager.getStringProperty(AFCApplicationConstants.APP_ENV_MAPPING, "");
        //
        //        appSubENV = PropertyManager.getStringProperty(AFCApplicationConstants.APP_SUB_ENV_MAPPING, "");
        //        // read from cloud system property
        //        contextNm = PropertyManager.getStringProperty(AFCApplicationConstants.FAW_APP_CONTEXT, "");
        //contextNm jndi:/localhost/afc4/ -> afc4
        String[] tempArray = contextNm.split( "/" );
        contextNm = tempArray[tempArray.length - 1];

        if ( contextNm.endsWith( ".war" ) ) {
            contextNm = contextNm.substring( 0, contextNm.length() - 4 );
        }
        log.info( "contextNM is :  " + contextNm );

        //        hostName = PropertyManager.getStringProperty(AFCApplicationConstants.FAW_APP_HOSTNAME, "");

        isCertificateEnabled = true;
    }

    private void loadDynamicProperties() {

        String stopwatch = getAppConfigStringValue( AFCApplicationConstants.SETTING_STOPWATCH_ENABLED, "false" );
        isStopWatchEnabled = "true".equalsIgnoreCase( stopwatch );

        isSecurityEnabled = true;

        String verifyFund = getAppConfigStringValue( AFCApplicationConstants.SETTING_VERRIFYFUND_ENABLED, "false" );
        isVerifyFundEnable = "true".equalsIgnoreCase( verifyFund );

        String adminIDFAuth = getAppConfigStringValue( AFCApplicationConstants.SETTING_ADMIN_IDF_AUTH_ENABLED, "false" );
        isAdminIDFAuthEnabled = "true".equalsIgnoreCase( adminIDFAuth );

        String updateMethod = getAppConfigStringValue( AFCApplicationConstants.SETTING_ACCESSMETHOD_UPDATE_ENABLED, "true" );
        isUpdateAccessEnabled = "true".equalsIgnoreCase( updateMethod );

        String useGenConnectionStr = getAppConfigStringValue( AFCApplicationConstants.SETTING_LUW_USE_CONNCECTION_ENABLED, "false" );
        isLuwUseGenConnection = "true".equalsIgnoreCase( useGenConnectionStr );

        String relationalLedgerEnabledStr = getAppConfigStringValue( AFCApplicationConstants.SETTING_RELATIONAL_LEDGER_ENABLED, "false" );
        isRelationalLedgerEnabled = "true".equalsIgnoreCase( relationalLedgerEnabledStr );

        securityProviderESF = getAppConfigStringValue( AFCApplicationConstants.SETTING_SECURITY_PROVIDER_ESF, "" );

        securityProviderRACF = getAppConfigStringValue( AFCApplicationConstants.SETTING_SECURITY_PROVIDER_RACF, "" );

        securityProviderLUW = getAppConfigStringValue( AFCApplicationConstants.SETTING_SECURITY_PROVIDER_LUW, "" );

        securityDataExpire = getAppConfigIntValue( AFCApplicationConstants.SECURITY_DATA_EXPIRE, AFCApplicationConstants.SECURITY_DATA_EXPIRE_DEFAULT_VALUE );

        securityCacheExpire = getAppConfigIntValue( AFCApplicationConstants.SECURITY_CACHE_EXPIRE, AFCApplicationConstants.SECURITY_CACHE_EXPIRE_DEFAULT_VALUE );

        allowedResourcePoolLimit = getAppConfigIntValue( AFCApplicationConstants.AFC_ALLOWED_RESOURCE_LIMIT, AFCApplicationConstants.AFC_ALLOWED_DEFAULT_COUNT );

        activeAlertLevel = getAppConfigStringValue( AFCApplicationConstants.SETTING_AFCLOG_LEVEL, "INFO" );

        String channelEnabledStr = getAppConfigStringValue( AFCApplicationConstants.XDATA_CHANNELS_ENABLED, "" );
        isChannelEnabled = "true".equalsIgnoreCase( channelEnabledStr );

        String securityAsynchronousEnabledStr = getAppConfigStringValue( AFCApplicationConstants.SECURITY_ASYNCHRONOUS_ENABLED, "true" );
        isSecurityAsynchronousEnabled = Boolean.parseBoolean( securityAsynchronousEnabledStr );

        securityAsyncTimeout = getAppConfigLongValue( AFCApplicationConstants.SECURITY_ASYNC_TIMEOUT, AFCApplicationConstants.SECURITY_ASYNC_TIMEOUT_DEFAULT_VALUE );
        securityTimeout = getAppConfigLongValue( AFCApplicationConstants.SECURITY_TIMEOUT, AFCApplicationConstants.SECURITY_TIMEOUT_DEFAULT_VALUE );
        fundGroupRefreshTimeout = getAppConfigLongValue( AFCApplicationConstants.FUND_GROUP_REFRESH_TIMEOUT, AFCApplicationConstants.FUND_GROUP_REFRESH_TIMEOUT_DEFAULT_VALUE );
        stopWatchRecordThreshold = getAppConfigIntValue( AFCApplicationConstants.STOPWATCH_RECORD_THRESHOLD, AFCApplicationConstants.STOPWATCH_RECORD_DEFAULT_THRESHOLD );

        stopWatchWriteWaitTime = getAppConfigLongValue( AFCApplicationConstants.STOPWATCH_WRITE_WAIT_TIME_MS, AFCApplicationConstants.STOPWATCH_DEFAULT_WRITE_WAIT_TIME_MS );

        entityGrpTrigerWaitTime = getAppConfigLongValue( AFCApplicationConstants.ENTITY_GRP_CLEAN_TRIGER_WAIT_TIME_MS, AFCApplicationConstants.ENTITY_GRP_DEFAULT_CLEAN_TRIGER_WAIT_TIME_MS );
        eSFbatchValidationTrigerWaitTime = getAppConfigLongValue( AFCApplicationConstants.ESF_BATCH_VALIDATION_TRIGER_WAIT_TIME_MS, AFCApplicationConstants.ESF_BATCH_VALIDATION_DEFAULT_TRIGER_WAIT_TIME_MS );
        entityGroupDetailBatchCount = getAppConfigIntValue( AFCApplicationConstants.ENTITY_ITEM_BATCH_SIZE, AFCApplicationConstants.ENTITY_ITEM_BATCH_SIZE_DEFAULT_VALUE );
        entityGroupUpdatedBatchCount = getAppConfigIntValue( AFCApplicationConstants.ENTITY_GROUP_UPDATE_BATCH_SIZE, AFCApplicationConstants.ENTITY_GROUP_UPDATE_BATCH_SIZE_DEFAULT_VALUE );

        ratesYieldsServiceProviderUrl = getAppConfigStringValue( AFCApplicationConstants.RATES_YIELDS_SERVICE_PROVIDER_URL );
        ratesYieldsServiceUserId = getAppConfigStringValue( AFCApplicationConstants.RATES_YIELDS_SERVICE_USER_ID );
        isRatesYieldsServiceUseDirectAppCall = getAppConfigBooleanValue( AFCApplicationConstants.RATES_YIELDS_SERVICE_USEDIRECT, isClientUseDirectAppCall() );
        isDshServiceUseDirectAppCall = getAppConfigBooleanValue( AFCApplicationConstants.DSH_SERVICE_USEDIRECT, true );
        String isEsfProxyEnablestr = getAppConfigStringValue( AFCApplicationConstants.ESFPROXY_ENABLE, "false" );
        isEsfProxyEnable = "true".equalsIgnoreCase( isEsfProxyEnablestr );
        String isFaultToleranceEnableStr = getAppConfigStringValue( AFCApplicationConstants.FAULTTOLERANCE_ENABLE, "false" );
        isFaultToleranceEnable = "true".equalsIgnoreCase( isFaultToleranceEnableStr );

        String isRacfBGEntitlementsEnableStr = getAppConfigStringValue( AFCApplicationConstants.RACF_BG_ENTITLEMENT_ENABLE, "false" );
        isRacfBGEntitlementsEnable = "true".equalsIgnoreCase( isRacfBGEntitlementsEnableStr );

        String isRacfMFARemoteCallStr = getAppConfigStringValue( AFCApplicationConstants.RACF_MFA_REMOTE_CALL, "false" );
        isRacfMFARemoteCall = "true".equalsIgnoreCase( isRacfMFARemoteCallStr );

        securityCloseToExpiryTime = getAppConfigStringValue( AFCApplicationConstants.SECURITY_CLOSE_TO_EXPIRY_TIME, "1" );//hours
        if ( "true".equalsIgnoreCase( getAppConfigStringValue( AFCApplicationConstants.ESF_USE_PERSISTENT_CACHE, "false" ) ) )
        {
            log.info( "set ESF.persistentCache.enabled property to true" );
            System.setProperty( "ESF.persistentCache.enabled", "true" );
        }
        securityExtendHours = getAppConfigIntValue( AFCApplicationConstants.SECURITY_EXTEND_HOURS, AFCApplicationConstants.SECURITY_EXTEND_HOURS_DEFAULT_VALUE );
        securitySourceToUpdate = getAppConfigStringValue( AFCApplicationConstants.SECURITY_SOURCE_TO_UPDATE, AFCApplicationConstants.SECURITY_SOURCE_TO_UPDATE_DEFAULT_VALUE );
        securityBatchUserSize = getAppConfigIntValue( AFCApplicationConstants.SECURITY_BATCH_USER_SIZE, AFCApplicationConstants.SECURITY_BATCH_USER_SIZE_DEFAULT_VALUE );
    }


    /**
     * 
     * @param key
     * @return get value from setting file.
     */
    public static String getStringProperty( String key ) {

        return getStringProperty( key, null );
    }

    /**
     * 
     * @param key
     * @param defaultValue
     * @return get value from setting file.
     */
    public static String getStringProperty( String key, String defaultValue ) {

        String val = key;//= PropertyManager.getStringProperty(key);
        if ( val == null ) {
            return defaultValue;
        }
        else if ( val != null && val.startsWith( "${" ) && val.endsWith( "}" ) ) {
            return defaultValue;
        }
        else {
            return val;
        }
    }

    private String getStringValueFromDbSettingsMap( String propertyKey, String defaultValue ) {

        if ( propertyKey == null ) {
            return null;
        }
        String value = dbSettingsMap.get( propertyKey.trim().toUpperCase() );
        if ( value == null ) {
            value = defaultValue;
        }
        return value;
    }

    public String getAppConfigStringValue( String propertyKey, String defaultValue ) {

        return getStringValueFromDbSettingsMap( "AFC_CONFIG_APPLICATION" + propertyKey, getStringProperty( propertyKey, defaultValue ) );
    }

    public String getEntityConfigStringValue( String entityName, String defaultValue ) {

        return getStringValueFromDbSettingsMap( "AFC_CONFIG_ENTITYNAME_PUBLISH" + entityName, getStringProperty( entityName, defaultValue ) );
    }

    public String getIDFConfigStringValue( String inIDFService, String defaultValue ) {

        return getStringValueFromDbSettingsMap( "AFC_CONFIG_IDF_PUBLISH" + inIDFService, getStringProperty( inIDFService, defaultValue ) );
    }

    //get string value
    public String getAppConfigStringValue( String propertyKey ) {

        return getAppConfigStringValue( propertyKey, null );
    }

    //get boolean value
    public boolean getAppConfigBooleanValue( String propertyKey, boolean defaultValue ) {

        String booleanVal = getAppConfigStringValue( propertyKey, String.valueOf( defaultValue ) );
        return AFCApplicationConstants.TRUE.equalsIgnoreCase( StringUtils.trim( booleanVal ) );
    }

    //get int value
    public int getAppConfigIntValue( String propertyKey, int defaultValue ) {

        String valStr = getAppConfigStringValue( propertyKey, "" + defaultValue );
        int intValue = defaultValue;
        try {
            intValue = Integer.parseInt( valStr );
        }
        catch ( NumberFormatException e ) {
            intValue = defaultValue;
        }
        return intValue;
    }

    //get long value
    public long getAppConfigLongValue( String propertyKey, long defaultValue ) {

        String valStr = getAppConfigStringValue( propertyKey, "" + defaultValue );
        long longValue = defaultValue;
        try {
            longValue = Long.parseLong( valStr );
        }
        catch ( NumberFormatException e ) {
            longValue = defaultValue;
        }
        return longValue;
    }

    public String getPlatformCd() {

        return platformCd;
    }

    public void setPlatformCd( String platformCd ) {

        this.platformCd = platformCd;
    }

    public String getAppENV() {

        return appENV;
    }

    public void setAppENV( String appENV ) {

        this.appENV = appENV;
    }

    public String getAppSubENV() {

        return appSubENV;
    }

    public String getContextNm() {

        return contextNm;
    }

    public void setContextNm( String contextNm ) {

        this.contextNm = contextNm;
    }

    public String getHostName() {

        return hostName;
    }

    public void setHostName( String hostName ) {

        this.hostName = hostName;
    }

    public boolean isRatesYieldsServiceUseDirectAppCall() {

        return isRatesYieldsServiceUseDirectAppCall;
    }

    public String getRatesYieldsServiceProviderUrl() {

        return ratesYieldsServiceProviderUrl;
    }

    public String getRatesYieldsServiceUserId() {

        return ratesYieldsServiceUserId;
    }

    public long getSecurityTimeout() {

        return securityTimeout;
    }

    public void setSecurityTimeout( int securityTimeout ) {

        this.securityTimeout = securityTimeout;
    }

    public long getSecurityAsyncTimeout() {

        return securityAsyncTimeout;
    }

    public boolean isSecurityAsynchronousEnabled() {

        return isSecurityAsynchronousEnabled;
    }

    public boolean isStopwatchEnabled() {

        return isStopWatchEnabled;
    }

    public void setStopWatchEnabled( boolean isStopWatchEnabled ) {

        this.isStopWatchEnabled = isStopWatchEnabled;
    }

    public boolean isCertificateEnabled() {

        return isCertificateEnabled;
    }

    public void setCertificateEnabled( boolean isCertificateEnabled ) {

        this.isCertificateEnabled = isCertificateEnabled;
    }

    public boolean isSecurityEnabled() {

        return isSecurityEnabled;
    }

    public void setSecurityEnabled( boolean isSecurityEnabled ) {

        this.isSecurityEnabled = isSecurityEnabled;
    }

    public boolean isVerifyFundEnable() {

        return isVerifyFundEnable;
    }

    public void setVerifyFundEnable( boolean isVerifyFundEnable ) {

        this.isVerifyFundEnable = isVerifyFundEnable;
    }

    public String getProcessIdRoleDataCategory() {

        return processIdRoleDataCategory;
    }

    public void setProcessIdRoleDataCategory( String processIdRoleDataCategory ) {

        this.processIdRoleDataCategory = processIdRoleDataCategory;
    }

    public String getProcessIdRoleDataValue() {

        return processIdRoleDataValue;
    }

    public void setProcessIdRoleDataValue( String processIdRoleDataValue ) {

        this.processIdRoleDataValue = processIdRoleDataValue;
    }

    public String getProcessIdRoleFunctionCode() {

        return processIdRoleFunctionCode;
    }

    public void setProcessIdRoleFunctionCode( String processIdRoleFunctionCode ) {

        this.processIdRoleFunctionCode = processIdRoleFunctionCode;
    }

    public boolean isAdminIDFAuthenticateEnabled() {

        return isAdminIDFAuthEnabled;
    }

    public void setAdminIDFAuthenticateEnabled( boolean isAdminIDFAuthenticateEnabled ) {

        this.isAdminIDFAuthEnabled = isAdminIDFAuthenticateEnabled;
    }

    public boolean isRelationalLedgerEnabled() {

        return isRelationalLedgerEnabled;
    }

    public void setRelationalLedgerEnabled( boolean isRelationalLedgerEnabled ) {

        this.isRelationalLedgerEnabled = isRelationalLedgerEnabled;
    }

    public String getSecurityProviderRACF() {

        return securityProviderRACF;
    }

    public void setSecurityProviderRACF( String securityProviderRACF ) {

        this.securityProviderRACF = securityProviderRACF;
    }

    public String getSecurityProviderESF() {

        return securityProviderESF;
    }

    public void setSecurityProviderESF( String securityProviderESF ) {

        this.securityProviderESF = securityProviderESF;
    }

    public int getSecurityDataExpire() {

        return securityDataExpire;
    }

    public void setSecurityDataExpire( int securityDataExpire ) {

        this.securityDataExpire = securityDataExpire;
    }

    public int getSecurityCacheExpire() {

        return securityCacheExpire;
    }

    public void setSecurityCacheExpire( int securityCacheExpire ) {

        this.securityCacheExpire = securityCacheExpire;
    }

    public boolean isSecurityRacfMockEnabled() {

        return isSecurityRacfMockEnabled;
    }

    public void setSecurityRacfMockEnabled( boolean isSecurityRacfMockEnabled ) {

        this.isSecurityRacfMockEnabled = isSecurityRacfMockEnabled;
    }

    public int getAllowedResourcePoolLimit() {

        return allowedResourcePoolLimit;
    }

    public void setAllowedResourcePoolLimit( int allowedResourcePoolLimit ) {

        this.allowedResourcePoolLimit = allowedResourcePoolLimit;
    }

    public boolean isUpdateAccessEnabled() {

        return isUpdateAccessEnabled;
    }

    public void setUpdateAccessEnabled( boolean isUpdateAccessEnabled ) {

        this.isUpdateAccessEnabled = isUpdateAccessEnabled;
    }

    public String getActiveAlertLevel() {

        return activeAlertLevel;
    }

    public void setActiveAlertLevel( String activeAlertLevel ) {

        this.activeAlertLevel = activeAlertLevel;
    }

    public String getSecurityProviderLUW() {

        return securityProviderLUW;
    }

    public void setSecurityProviderLUW( String securityProviderLUW ) {

        this.securityProviderLUW = securityProviderLUW;
    }

    public boolean isLuwUseGenConnection() {

        return isLuwUseGenConnection;
    }

    public List <String> getAllKeyFromDbSettings() {

        return new ArrayList <String>( dbSettingsMap.keySet() );
    }

    public boolean isChannelEnabled() {

        return isChannelEnabled;
    }

    public void setChannelEnabled( boolean isChannelEnabled ) {

        this.isChannelEnabled = isChannelEnabled;
    }

    public int getStopWatchRecordThreshold() {

        return stopWatchRecordThreshold;
    }

    public long getStopWatchWriteWaitTime() {

        return stopWatchWriteWaitTime;
    }

    public long getEntityGrpTrigerWaitTime() {

        return entityGrpTrigerWaitTime;
    }

    public void setEntityGrpTrigerWaitTime( long entityGrpTrigerWaitTime ) {

        this.entityGrpTrigerWaitTime = entityGrpTrigerWaitTime;
    }

    public long getESFbatchValidationTrigerWaitTime() {

        return eSFbatchValidationTrigerWaitTime;
    }

    public boolean isDshServiceUseDirectAppCall() {

        return isDshServiceUseDirectAppCall;
    }

    public boolean isEsfProxyEnable() {

        return isEsfProxyEnable;
    }

    @Override
    public String toString() {

        return "AFCApplicationConfig{" + "entityNameDaoMap=" + entityNameDaoMap + ", virtualEntityNameDaoMap=" + virtualEntityNameDaoMap + ", dbSettingsMap=" + dbSettingsMap + ", isCertificateEnabled=" + isCertificateEnabled + ", isSecurityEnabled=" + isSecurityEnabled + ",isVerifyFundEnable=" + isVerifyFundEnable + ", isStopWatchEnabled=" + isStopWatchEnabled + ", isAdminIDFAuthEnabled=" + isAdminIDFAuthEnabled + ", isRelationalLedgerEnabled=" + isRelationalLedgerEnabled + ", isSecurityRacfMockEnabled=" + isSecurityRacfMockEnabled + ", isUpdateAccessEnabled=" + isUpdateAccessEnabled + ", isLuwUseGenConnection=" + isLuwUseGenConnection + ", securityProviderESF='" + securityProviderESF + '\'' + ", securityProviderESF='" + securityProviderESF + '\'' + ", securityProviderRACF='" + securityProviderRACF + '\'' + ", securityDataExpire=" + securityDataExpire + ", securityCacheExpire=" + securityCacheExpire + ",securityTimeout=" + securityTimeout + ", securityAsyncTimeout=" + securityAsyncTimeout + ",isSecurityAsynchronousEnabled=" + isSecurityAsynchronousEnabled + ", allowedResourcePoolLimit=" + allowedResourcePoolLimit + ", processIdRoleDataCategory='" + processIdRoleDataCategory + '\'' + ", processIdRoleDataValue='" + processIdRoleDataValue + '\'' + ", processIdRoleFunctionCode='" + processIdRoleFunctionCode + '\'' + ", isInitialized=" + isInitialized + '}';
    }

    //------------------ get from DB, setting-----
    public String getMqHostName() {

        return getAppConfigStringValue( AFCApplicationConstants.MQ_HOSTNAME, "" );
    }

    public String getMqChannel() {

        return getAppConfigStringValue( AFCApplicationConstants.MQ_CHANNEL, "" );
    }

    public String getMqqManager() {

        return getAppConfigStringValue( AFCApplicationConstants.MQ_QMANAGER, "" );
    }

    public String getMqdmeQueue() {

        return getAppConfigStringValue( AFCApplicationConstants.MQ_DMEQUEUE, "" );
    }

    public int getMqPort() {

        return getAppConfigIntValue( AFCApplicationConstants.MQ_PORT, 0 );
    }

    public String getSaveStopWatchToDBCloudURL() {

        return getAppConfigStringValue( AFCApplicationConstants.SAVE_STOP_WATCH_CLOUD_URL, "" );
    }

    public String getDSHCloudURL() {

        return getAppConfigStringValue( AFCApplicationConstants.DSH_CLOUD_URL, "" );
    }

    public String getDSHFailOverCloudURL() {

        return getAppConfigStringValue( AFCApplicationConstants.DSH_FAILOVER_CLOUD_URL, "" );
    }

    public String getAFCCertificate() {

        return getAppConfigStringValue( AFCApplicationConstants.AFC_CERTIFICATE, "f6706ae0-c9d5-4de0-ac9f-6c25ffc01676" );
    }

    public String getCloudSignOnUserId() {

        return getAppConfigStringValue( AFCApplicationConstants.CLOUD_SIGNON_USERID, "" );
    }

    public String getCloudSignOnServer() {

        return getAppConfigStringValue( AFCApplicationConstants.CLOUD_SIGNON_SERVER, "" );
    }

    public String getDshCloudSignOnUserId() {

        return getAppConfigStringValue( AFCApplicationConstants.DSH_USER_ID, "" );
    }

    public String getDshCloudSignOnServer() {

        return getAppConfigStringValue( AFCApplicationConstants.DSH_PWM_SERVER, "" );
    }

    public String getSaveStopWatchMediator() {

        return getAppConfigStringValue( AFCApplicationConstants.SAVE_STOP_WATCH_MEDIATOR, "" );
    }

    /**
     * 
     * @return the page size of cloud client: Client client = XXXX;</br>
     *         client.setPageSize(getDefaultCloudResultSetPageSize())
     * @see Client
     */
    public static int getDefaultCloudResultSetPageSize() {

        try {
            String pageSizeStr = getStringProperty( AFCApplicationConstants.FAW_CLOUD_RESULTSET_PAGESIZE, "64" );//default value is 64
            return Integer.parseInt( pageSizeStr );
        }
        catch ( Exception e ) {
            return 64;// if throw exception return default value
        }
    }

    /**
     * 
     * @return the page size of cloud client: Client client = XXXX;</br>
     *         client.setPageSize(AFCApplicationConfig.getInstance().
     *         getEsfWebServiceProviderFetchSize())
     * @see Client
     */
    public int getEsfWebServiceProviderFetchSize() {

        return getAppConfigIntValue( AFCApplicationConstants.ESF_WEB_SERVICE_PROVIDER_FETCH_SIZE, 500 );
    }

    public int getDshWebServiceFetchSize() {

        return getAppConfigIntValue( AFCApplicationConstants.DSH_FETCH_SIZE, getDefaultCloudResultSetPageSize() );
    }

    public boolean isClientUseDirectAppCall() {

        String userDirect = "";//PropertyManager.getStringProperty( "OEC.client.useDirectAppCall" );
        return AFCApplicationConstants.TRUE.equalsIgnoreCase( StringUtils.trim( userDirect ) );
    }

    public String getSecurityEntitlementsAppCode( String appId ) {

        String key = AFCApplicationConstants.CLIENT_PROFILE + AFCApplicationConstants.DOT + appId + AFCApplicationConstants.DOT + AFCApplicationConstants.APP_CODE;
        return getAppConfigStringValue( key );
    }

    public long getLockTimeOut() {

        return getAppConfigLongValue( AFCApplicationConstants.LOCK_TIME_OUT, 5 );
    }

    public String getSecurityEntitlementsCacheOption() {

        return getAppConfigStringValue( AFCApplicationConstants.SECURITY_ENTITLEMENTS_CACHE_OPTION, "m720" );
    }

    public String getESFWebServiceProviderURL() {

        return getAppConfigStringValue( AFCApplicationConstants.ESF_WEB_SERVICE_PROVIDER_URL );
    }

    public String getESFWebServiceProviderUserId() {

        return getAppConfigStringValue( AFCApplicationConstants.ESF_WEB_SERVICE_PROVIDER_USER_ID );
    }

    public String getESFWebServiceProviderPwmServer() {

        return getAppConfigStringValue( AFCApplicationConstants.ESF_WEB_SERVICE_PROVIDER_PWM_SERVER );
    }

    public String getRatesVieldsServiceProviderPwmServer() {

        return getAppConfigStringValue( AFCApplicationConstants.RATES_YIELDS_SERVICE_PROVIDER_PWM_SERVER );
    }

    public String getEsfChannelsCallIdf() {

        return getAppConfigStringValue( AFCApplicationConstants.ESF_CHANNELS_IDF );
    }

    public String getEsfChannelsBackground1Url() {

        return getAppConfigStringValue( AFCApplicationConstants.ESF_CHANNELS_BG1_URL );
    }

    public String getEsfChannelsBackground2Url() {

        return getAppConfigStringValue( AFCApplicationConstants.ESF_CHANNELS_BG2_URL );
    }

    public String getEsfChannelsBackupUrl() {

        return getAppConfigStringValue( AFCApplicationConstants.ESF_CHANNELS_BK_URL );
    }

    public boolean isUpdateLuwDataToMCHDB2() {

        return "true".equalsIgnoreCase( getAppConfigStringValue( AFCApplicationConstants.ESF_UPDATE_LUW_DATA_TO_MCHDB2_ENABLE, "false" ) );
    }

    public boolean isMfaLocalCall() {

        return Boolean.parseBoolean( getAppConfigStringValue( AFCApplicationConstants.MFA_LOCAL_CALL, "false" ) );
    }

    public String getIDFConfigStringValue( String inIDFService ) {

        return getIDFConfigStringValue( inIDFService, null );
    }

    public String getEntityConfigStringValue( String entityName ) {

        return getEntityConfigStringValue( entityName, null );
    }

    public boolean isTrustIdValidationEnable() {

        return Boolean.parseBoolean( getAppConfigStringValue( AFCApplicationConstants.TRUSTED_ID_VALIDATION_ENABLE, "false" ) );
    }

    public long getFundGroupRefreshTimeout() {

        return fundGroupRefreshTimeout;
    }

    public long setFundGroupRefreshTimeout( long fundGroupRefreshTimeout ) {

        return this.fundGroupRefreshTimeout = fundGroupRefreshTimeout;
    }

    public boolean isFaultToleranceEnable() {

        return isFaultToleranceEnable;
    }

    public int getEntityGroupDetailBatchCount() {

        return entityGroupDetailBatchCount;
    }

    public void setEntityGroupDetailBatchCount( int entityGroupDetailBatchCount ) {

        this.entityGroupDetailBatchCount = entityGroupDetailBatchCount;
    }

    public int getEntityGroupUpdatedBatchCount() {

        return entityGroupUpdatedBatchCount;
    }

    public void setEntityGroupUpdatedBatchCount( int entityGroupUpdatedBatchCount ) {

        this.entityGroupUpdatedBatchCount = entityGroupUpdatedBatchCount;
    }

    public boolean isRacfBGEntitlementsEnable() {

        return isRacfBGEntitlementsEnable;
    }

    public void setRacfBGEntitlementsEnable( boolean isRacfBGEntitlementsEnable ) {

        this.isRacfBGEntitlementsEnable = isRacfBGEntitlementsEnable;
    }

    public boolean isRacfMFARemoteCall() {

        return isRacfMFARemoteCall;
    }

    public void setRacfMFARemoteCall( boolean isRacfMFARemoteCall ) {

        this.isRacfMFARemoteCall = isRacfMFARemoteCall;
    }

    public String getSecurityCloseToExpiryTime() {

        return securityCloseToExpiryTime;
    }

    public void setSecurityCloseToExpiryTime( String securityCloseToExpiryTime ) {

        this.securityCloseToExpiryTime = securityCloseToExpiryTime;
    }

    public String getSecuritySourceToUpdate() {

        return securitySourceToUpdate;
    }

    public void setSecuritySourceToUpdate( String securitySourceToUpdate ) {

        this.securitySourceToUpdate = securitySourceToUpdate;
    }

    public int getSecurityExtendHours() {

        return securityExtendHours;
    }

    public void setSecurityExtendHours( int securityExtendHours ) {

        this.securityExtendHours = securityExtendHours;
    }

    public int getSecurityBatchUserSize() {

        return securityBatchUserSize;
    }

    public void setSecurityBatchUserSize( int securityBatchUserSize ) {

        this.securityBatchUserSize = securityBatchUserSize;
    }


}
