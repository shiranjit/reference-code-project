


package com.shirish.performanceMonitor.common.service;

/*
 * This job is to
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.shirish.performanceMonitor.common.AFCLogger;
import com.shirish.performanceMonitor.common.model.PerfMonRecord;

/**
 * 
 * @author shirish
 * @Oct 25, 2015
 *
 */
public class PerfMonPersistenceService extends Thread {

    private static transient AFCLogger log                = AFCLogger.getLogger( PerfMonPersistenceService.class );
    private static int                 RECORD_THRESHHOLD  = 50;

    private List <PerfMonRecord>       tSafeLogrecordList = null;

    private volatile AtomicBoolean     alive;
    private Lock                       alock;
    private Condition                  writeSignal;
    private volatile boolean           writeInProgress;
    private long                       waitTime;


    /**
	 * 
	 */
    public PerfMonPersistenceService() {

        //currentJob = this;
        //concurrentPersistQueue = new ConcurrentLinkedQueue<StopWatchRecords>();
        tSafeLogrecordList = Collections.synchronizedList( new ArrayList <PerfMonRecord>( 1000 ) );
        alock = new ReentrantLock();
        writeSignal = alock.newCondition();
        alive = new AtomicBoolean( true );
        // RECORD_THRESHHOLD = appConfig.getStopWatchRecordThreshold();
        waitTime = 30000;// appConfig.getStopWatchWriteWaitTime();
        log.info( "AFCPersistStopWatchDataJob init completed" );
    }


    /**
     * 
     */
    @Override
    public void run() {

        log.info( "AFCPersistStopWatchDataJob is executing... alive: " + alive.get() );

        while ( alive.get() ) {
            if ( tSafeLogrecordList.size() < RECORD_THRESHHOLD ) {
                log.info( "getting a lock" );
                alock.lock();
                log.info( "lock obtained" );
                try {
                    writeInProgress = false;
                    log.info( "waiting for  signal. Number of records in queue :: " + tSafeLogrecordList.size() );

                    writeSignal.await( waitTime, TimeUnit.MILLISECONDS );

                }
                catch ( InterruptedException e ) {
                    log.warn( "Ignore the InterruptedException" );
                }
                finally {
                    alock.unlock();
                }
            }

            //            log.info( "outsideif now." );
            //            int cnt = RECORD_THRESHHOLD;
            //            writeInProgress = true;
            //            list = new ArrayList <StopWatchRecords>();
            //            while ( cnt > 0 && tSafeLogrecordList.size() > 0 ) {
            //                StopWatchRecords records = tSafeLogrecordList.get( c );
            //                list.add( records );
            //                cnt--;
            //            }
            writeStopWatchRecords();
        }
        // log.info( "Write all pending records if any, before shutting down..., Number of records is queue :: " + tSafeLogrecordList.size() );


        // writeStopWatchRecords();

        log.info( "AFCPersistStopWatchDataJob is complete..." );
    }

    /**
     * 
     * @param list
     */
    private void writeStopWatchRecords() {


        try {
            StringBuilder sb = new StringBuilder();
            synchronized ( tSafeLogrecordList ) {
                
                List<PerfMonRecord> sortedList = PerfMonRecordFormatUtil.sort( tSafeLogrecordList );
                
                for ( PerfMonRecord stopWatchRecord : sortedList ) {
                    //System.out.println(" here is the rec: " + stopWatchRecords.toString());
                   sb.append( "id: " + stopWatchRecord.getId() + " --- " + stopWatchRecord.toString() + "\n");

                }                
            }
            
            log.info( "Writing records for: " + tSafeLogrecordList.size() );
            log.info("\n" +sb.toString());
        }
        catch ( Exception e2 ) {
            log.error( "Failed to create mediator", e2 );
            alive.getAndSet( false );
        }
    }

    /**
     * 
     * 
     * @param record
     *            void
     */
    public void addToPersistQueue( PerfMonRecord record ) {

        if ( !alive.get() ) {
            log.warn( "Stopwatch is shutting down, new records can not be added" );
            return;
        }

        tSafeLogrecordList.add( record );

        if ( !writeInProgress && tSafeLogrecordList.size() >= RECORD_THRESHHOLD ) {
            alock.lock();
            try {
                writeSignal.signal();
            }
            finally {
                alock.unlock();
            }
        }
    }

    public void flushRecords() {

        if ( !writeInProgress ) {
            alock.lock();
            try {
                writeSignal.signal();
                _destroyJob();
            }
            finally {
                alock.unlock();
            }
        }
    }

    public void _destroyJob() {

        alive.getAndSet( false );
    }

    public void kill() {

        _destroyJob();
    }


}
