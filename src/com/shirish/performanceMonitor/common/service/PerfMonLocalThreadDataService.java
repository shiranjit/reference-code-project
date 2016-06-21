


package com.shirish.performanceMonitor.common.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.shirish.performanceMonitor.common.model.AFCAbstractTDataModel;

/**
 * 
 * @author shirish
 * @Oct 24, 2015
 *
 */
public class PerfMonLocalThreadDataService {

    private static final String                       STOP_WATCH                = "STOP_WATCH";

    private static final String                       STOP_WATCH_PERSIT_SERVICE = "STOP_WATCH_PERSIT_SERVICE";

    private static final String                       IDF_USER_ID               = "IDF_USER_ID";

    private static final String                       SESSION_USER_ID           = "SESSION_USER_ID";

    private static final String                       SESSION_USER_PWD          = "SESSION_USER_PWD";

    private static final String                       IDF_SESSION_ID            = "IDF_SESSION_ID";

    private static final String                       SESSION_ID                = "SESSION_ID";

    private static final String                       USER_TYPE                 = "USER_ID_TYPE";

    private static final String                       SESSION_SYSID             = "SESSION_SYSID";

    private static final String                       SESSION_CONTROL_REGION_CD = "SESSION_CONTROL_REGION_CD";

    private static final String                       USER_TYPE_PROCESS_ID      = "USER_TYPE_PROCESS_ID";

    private static final String                       USER_TYPE_USER_ID         = "USER_TYPE_USER_ID";

    private static final String                       IDF_INPUT_RAW_DATA        = "IDF_INPUT_RAW_DATA";

    private static final String                       USER_INPUT_CRITERIA       = "USER_INPUT_CRITERIA";

    private static final String                       SECURITY_SOURCE_CODE      = "SECURITY_SOURCE_CODE";

    private static final String                       CLIENT_PROFILE            = "CLIENT_PROFILE";

    private static final String                       REQUEST_ID                = "REQUEST_ID";

    private static final String                       RESOURCE_ALLOCATED_SW     = "RESOURCE_ALLOCATED_SW";

    private static final String                       PICKED_DATA_SOURCE_STATUS = "PICKED_DATA_SOURCE_STATUS";

    private static final String                       CLIENT_REQUST_ID          = "CLIENT_REQUST_ID";

    private static final String                       TRUSTED_ID                = "TRUSTED_ID";

    private static ThreadLocal <Map <String, Object>> threadLocal               = new ThreadLocal <Map <String, Object>>();


    /**
     * 
     * 
     * 
     */
    public static void cleanThreadData() {

        Map <String, Object> map = threadLocal.get();
        if ( map != null ) {
            map.clear();
        }
        threadLocal.remove();
    }

    /**
     * 
     * 
     * @return Map<String,Object>
     */
    private static synchronized Map <String, Object> getMap() {

        Map <String, Object> map = threadLocal.get();
        if ( map == null ) {
            map = new HashMap <String, Object>();
            threadLocal.set( map );
        }
        return map;
    }

    /**
     * 
     * 
     * @return Map<String,Object>
     */
    @SuppressWarnings("unchecked")
    public static Map <String, Object> getCloneMap() {

        HashMap <String, Object> map = (HashMap <String, Object>) getMap();
        return (Map <String, Object>) map.clone();
    }

    public static void setThreadDataFromMap( Map <String, Object> threadDataMap ) {

        Map <String, Object> map = getMap();
        for ( Map.Entry <String, Object> entry : threadDataMap.entrySet() ) {
            if ( !STOP_WATCH.equals( entry.getKey() ) ) {
                map.put( entry.getKey(), entry.getValue() );
            }
        }
    }

    /**
     * 
     * 
     * @return
     * AFCStopWatchKeeper
     */
    public static PerfMonKeeper getAfcStopWatchKeeper() {

        Object stopWatchKeeper = getValue( STOP_WATCH );
        if ( stopWatchKeeper != null && stopWatchKeeper instanceof PerfMonKeeper ) {

            return (PerfMonKeeper) stopWatchKeeper;
        }
        else {
            return null;
        }

    }

    /**
     * 
     * 
     * @return
     * AFCStopWatchPersistService
     */
    public static PerfMonPersistenceService getAfcStopWatchPersistService() {

        Object stopWatchKeeperPersist = getValue( STOP_WATCH_PERSIT_SERVICE );
        if ( stopWatchKeeperPersist != null && stopWatchKeeperPersist instanceof PerfMonPersistenceService ) {

            return (PerfMonPersistenceService) stopWatchKeeperPersist;
        }
        else {
            return null;
        }

    }

    /**
     * 
     * 
     * @param afcStopWatchKeeper
     * void
     */
    public static void setAfcStopWatchKeeper( PerfMonKeeper afcStopWatchKeeper ) {

        setValue( STOP_WATCH, afcStopWatchKeeper );
    }

    public static void setAfcStopWatchPersistService( PerfMonPersistenceService persistService ) {

        setValue( STOP_WATCH_PERSIT_SERVICE, persistService );
        persistService.start();
    }

    public static void setIDFInputRawData( AFCAbstractTDataModel inBo ) {

        setValue( IDF_INPUT_RAW_DATA, inBo );
    }


    public static AFCAbstractTDataModel getUserCriteria() {

        return (AFCAbstractTDataModel) getValue( USER_INPUT_CRITERIA );
    }

    public static void setUserCriteria( AFCAbstractTDataModel threadData ) {

        setValue( USER_INPUT_CRITERIA, threadData );
    }

    public static String getIDFUserId() {

        Object userId = getValue( IDF_USER_ID );
        if ( userId != null && userId instanceof String ) {
            return (String) userId;
        }
        else {
            return null;
        }
    }

    public static void setIDFUserId( String idfUserId ) {

        setValue( IDF_USER_ID, idfUserId );
    }

    public static String getSessionUserId() {

        Object userId = getValue( SESSION_USER_ID );
        if ( userId != null && userId instanceof String ) {
            return (String) userId;
        }
        else {
            return null;
        }
    }

    public static String getSessionUserPwd() {

        Object userPwd = getValue( SESSION_USER_PWD );
        if ( userPwd != null && userPwd instanceof String ) {
            return (String) userPwd;
        }
        else {
            return null;
        }
    }

    /**
     * 
     * 
     * @param sessionUserId
     *            void
     */
    public static void setSessionUserId( String sessionUserId ) {

        setValue( SESSION_USER_ID, sessionUserId );
    }

    public static void setSessionUserPwd( String sessionUserPwd ) {

        setValue( SESSION_USER_PWD, sessionUserPwd );
    }

    public static String getSessionId() {

        Object sessionId = getValue( SESSION_ID );

        if ( sessionId != null && sessionId instanceof String ) {
            return (String) sessionId;
        }
        else {
            return null;
        }

    }

    public static void setSessionId( String sessionId ) {

        setValue( SESSION_ID, sessionId );
    }

    public static String getIDFSessionId() {

        Object idfSessionId = getValue( IDF_SESSION_ID );

        if ( idfSessionId != null && idfSessionId instanceof String ) {
            return (String) idfSessionId;
        }
        else {
            return null;
        }
    }

    public static void setIDFSessionId( String idfSessionId ) {

        setValue( IDF_SESSION_ID, idfSessionId );
    }

    private static Object getValue( String key ) {

        return getMap().get( key );
    }

    private static void setValue( String key, Object value ) {

        getMap().put( key, value );
    }

    public static void setProcessIdUser( boolean isProcessIdUser ) {

        if ( isProcessIdUser ) {
            setValue( USER_TYPE, USER_TYPE_PROCESS_ID );
        }
        else {
            setValue( USER_TYPE, USER_TYPE_USER_ID );
        }
    }

    public static boolean isProcessIdUser() {

        Object value = getValue( USER_TYPE );
        if ( value != null && value instanceof String ) {
            return USER_TYPE_PROCESS_ID.equals( value );
        }
        else {
            return false;
        }
    }

    public static String getSecuritySourceCode() {

        return (String) getValue( SECURITY_SOURCE_CODE );
    }

    public static void setSecuritySourceCode( String source ) {

        setValue( SECURITY_SOURCE_CODE, source );
    }


    /**
     * 
     * 
     * @return String
     */
    public static String echo() {

        Map <String, Object> threadMap = getMap();
        Iterator <Map.Entry <String, Object>> i = threadMap.entrySet().iterator();
        StringBuilder sb = (new StringBuilder()).append( "AFCThreadData-> " );
        if ( !i.hasNext() )
            return sb.append( "{}" ).toString();

        sb.append( '{' );
        while ( true ) {
            Map.Entry <String, Object> e = i.next();
            String key = e.getKey();
            Object value = e.getValue();
            sb.append( key );
            sb.append( '=' );
            sb.append( SESSION_USER_PWD.equals( key ) ? "******" : (value == threadMap ? "(this Map)" : value) );
            if ( !i.hasNext() )
                return sb.append( '}' ).toString();
            sb.append( ", " );
        }
    }


    public void setTrustedId( boolean isTrustedId ) {

        setValue( TRUSTED_ID, isTrustedId );
    }

    public boolean isTrustedId() {

        Boolean value = (Boolean) getValue( TRUSTED_ID );
        if ( value == null ) {
            return false;
        }
        return value.booleanValue();
    }

}
