


package com.shirish.performanceMonitor.common.service;

import java.util.HashMap;
import java.util.Map;

import com.shirish.performanceMonitor.common.AFCLogger;
import com.shirish.performanceMonitor.common.constants.AFCApplicationConstants;
import com.shirish.performanceMonitor.common.model.PerfMonRecord;

/**
 * 
 * @author shirish
 * @Oct 25, 2015
 *
 */
public class PerfMonKeeper {

    private static final AFCLogger log                = AFCLogger.getLogger( PerfMonKeeper.class );

    private boolean                isStopwatchEnabled = false;
    private long                   recordSequenceID   = 0L;
    private Map <String, Object>   mdcContext         = new HashMap <String, Object>();


    /**
     * Get an instace of local thread Stopwatch keeper. If it is not
     * instantiated then create a new one
     * 
     * @return
     */
    public static PerfMonKeeper getInstanceFromThreadLocal() {

        PerfMonKeeper afcStopWatchKeeper = PerfMonLocalThreadDataService.getAfcStopWatchKeeper();
        if ( afcStopWatchKeeper == null ) {
            //lets initialize
            log.info( "create AFCStopWatchKeeper" );
            afcStopWatchKeeper = new PerfMonKeeper();
            afcStopWatchKeeper.setStopWatchEnabled( true );
            
            PerfMonPersistenceService stopWatchPersistService = new PerfMonPersistenceService();
            //not need to start as the set will start the thread.
            PerfMonLocalThreadDataService.setAfcStopWatchPersistService( stopWatchPersistService );

          //lets put a begin marker
           // PerfMonStopWatch stopWatch = new PerfMonStopWatch( PerfMonKeeper.class, PerfMonTaskEnum.START );
            //afcStopWatchKeeper.recordDEBUG( stopWatch );
            PerfMonLocalThreadDataService.setAfcStopWatchKeeper( afcStopWatchKeeper );
        }
        return afcStopWatchKeeper;
    }

    /**
     * This method is preferred to be called at the end life of a thread
     * 
     * After called this method, you need to reCall the method
     * getInstanceFromThreadLocal() to get a new keeper instance to record the
     * StopWatch
     */
    public void finalPersist() {

        try {
            PerfMonKeeper afcStopWatchKeeper = getInstanceFromThreadLocal();
            if ( !afcStopWatchKeeper.isStopwatchEnabled ) {
                log.info( "stop watch disabled" );
                return;
            }

            //lets put the end record marker
           // PerfMonStopWatch stopWatch = new PerfMonStopWatch( PerfMonKeeper.class, PerfMonTaskEnum.END );
            //afcStopWatchKeeper.recordDEBUG( stopWatch );


            // toPersistRecordList not sort, so the data is not processed in fg
            PerfMonPersistenceService swps = PerfMonLocalThreadDataService.getAfcStopWatchPersistService();
            swps.flushRecords();
        }
        finally {
            // remove this instance from thread local
            PerfMonLocalThreadDataService.setAfcStopWatchKeeper( null );
        }
    }

    public boolean isStopwatchEnabled() {

        return isStopwatchEnabled;
    }

    public void setStopWatchEnabled( boolean isStopwatchEnabled ) {

        this.isStopwatchEnabled = isStopwatchEnabled;
    }

    /**
     *
     */
    public synchronized void enable() {

        log.info( "Stop Watch enabled." );
        setStopWatchEnabled( true );

    }

    /**
     *
     */
    public synchronized void disable() {

        log.info( "Stop Watch disabled." );
        setStopWatchEnabled( false );
    }

    public void setRequestInfo( String key, String value ) {

        mdcContext.put( key, value );
    }

    public Object getRequestInfo( String key ) {

        return mdcContext.get( key );
    }

    /**
     * Generate new ID
     * 
     * @return
     */
    private synchronized Long getNewRecordSequenceID() {

        if ( Long.MAX_VALUE == recordSequenceID ) {
            recordSequenceID = 0L;
        }
        recordSequenceID++;
        return recordSequenceID;
    }

    /**
     * Keeps the record of the time only print log when log level is bellow
     * Debug
     * 
     * @param stopWatch
     */
    public void recordDEBUG( PerfMonStopWatch stopWatch ) {

        record( stopWatch, PerfMonRecord.DEBUG );

    }

    public void record( PerfMonStopWatch stopWatch ) {

        record( stopWatch, PerfMonRecord.DEBUG );

    }

    /**
     * Keeps the record of the time only print log when log level is bellow
     * Trace
     * 
     * @param stopWatch
     */
    public void recordTRACE( PerfMonStopWatch stopWatch ) {

        record( stopWatch, PerfMonRecord.TRACE );

    }

    /**
     * Keeps the record of the time print it to log when log level is bellow
     * INFO
     * 
     * @param stopWatch
     */
    public void record( PerfMonStopWatch stopWatch, int level ) {

        // if stopwatch is not working or the the stopwatch is disabled then do
        // not do anythings.
        if ( stopWatch == null || !isStopwatchEnabled() ) {
            log.info( " stopwatch is: " + stopWatch + " and isStopWatchEnabled is " + isStopwatchEnabled );
            return;
        }
        // AFCApplicationConfig applicationConfig = AFCApplicationConfig.getInstance();

        PerfMonRecord newRecord = new PerfMonRecord();
        newRecord.setId( getNewRecordSequenceID() );
        String threadName = Thread.currentThread().getName();
        newRecord.setThreadName( threadName );
        newRecord.setStartTime( stopWatch.getFStart() );
        newRecord.setStopTime( stopWatch.getFStop() );
        newRecord.setLevel( level );
        // newRecord.setHandlerStopWatchKeeper(this);

        newRecord.setUuid( (String) this.getRequestInfo( AFCApplicationConstants.REQUEST_ID ) );
        newRecord.setClientAppId( (String) this.getRequestInfo( AFCApplicationConstants.CERTIFICATE ) );
        newRecord.setClientRqstId( (String) this.getRequestInfo( AFCApplicationConstants.CLIENT_APP_REQUEST_ID ) );
        newRecord.setUserId( (String) this.getRequestInfo( AFCApplicationConstants.USER_ID ) );

        //        newRecord.setPlatformCd( applicationConfig.getPlatformCd() );
        //        newRecord.setEnvironmentCd( applicationConfig.getAppENV() );
        //        newRecord.setContextNm( applicationConfig.getContextNm() );
        //        newRecord.setHostNm( applicationConfig.getHostName() );

        newRecord.setEntityNm( (String) this.getRequestInfo( AFCApplicationConstants.ENTITYNAME ) );
        String criteriaStr = (String) this.getRequestInfo( AFCApplicationConstants.CRITERIA );
        if ( "[null]".equalsIgnoreCase( criteriaStr ) ) {
            criteriaStr = null;
        }
        newRecord.setCriteriaCd( criteriaStr );
        newRecord.setComponentNm( stopWatch.getCalledClass().getName() );
        newRecord.setTaskNm( stopWatch.getTaskName() );

        // newRecord.setMaxResourceCnt( applicationConfig.getAllowedResourcePoolLimit() );
        newRecord.setStartTs( stopWatch.getMilliStart() );
        newRecord.setEndTs( stopWatch.getMilliStop() );
        newRecord.setArchivePurgeCd( "Y" );

        newRecord.setDescription( stopWatch.getDescription() );

        PerfMonPersistenceService swps = PerfMonLocalThreadDataService.getAfcStopWatchPersistService();
        swps.addToPersistQueue( newRecord );

    }

    /**
     * 
     * 
     * @return
     * Map<String,Object>
     */
    public Map <String, Object> getMdcContext() {

        return mdcContext;
    }

}
