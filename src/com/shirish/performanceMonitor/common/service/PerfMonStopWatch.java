


package com.shirish.performanceMonitor.common.service;

import java.util.Date;

/**
 * 
 * @author shirish
 * @Oct 25, 2015
 *
 */
public class PerfMonStopWatch {

    private static final long MINUTES_DIV = 60 * 1000 * 1000 * 1000l;
    private static final long SEC_DIV     = 1000 * 1000 * 1000l;
    private static final long MS_DIV      = 1000 * 1000l;
    private String            taskName;
    private long              fStart;                                 //nanoTime
    private long              fStop;                                  //nanoTime
    private long              milliStart;
    private long              milliStop;

    private boolean           fIsRunning;
    private boolean           fHasBeenUsedOnce;
    private String            description;

    private Class <?>         calledClass;


    public PerfMonStopWatch(Class <?> calledClass, PerfMonTaskEnum taskName) {

        this.calledClass = calledClass;
        this.taskName = taskName.getTaskName();
    }

    public PerfMonStopWatch(Class <?> calledClass, PerfMonTaskEnum taskName, String description) {

        this.calledClass = calledClass;
        this.taskName = taskName.getTaskName();
        this.description = description;
    }

    /**
     * Start the stopwatch.
     * 
     * @throws IllegalStateException
     *             if the stopwatch is already running.
     */
    public void start() {

        if ( fIsRunning ) {
            return;
            // throw new
            // IllegalStateException("Must stop before calling start again.");
        }
        // reset both start and stop
        fStart = System.nanoTime();
        milliStart = System.currentTimeMillis();
        fStop = 0;
        milliStop = 0;
        fIsRunning = true;
        fHasBeenUsedOnce = true;
    }

    /**
     * Stop the stopwatch.
     * 
     * @throws IllegalStateException
     *             if the stopwatch is not already running.
     */
    public void stop() {

        if ( !fIsRunning ) {
            return;
            // throw new
            // IllegalStateException("Cannot stop if not currently running.");
        }
        fStop = System.nanoTime();
        milliStop = System.currentTimeMillis();
        fIsRunning = false;
    }

    /**
     * Express the "reading" on the stopwatch.
     * 
     * @throws IllegalStateException
     *             if the Stopwatch has never been used, or if the stopwatch is
     *             still running.
     */
    @Override
    public String toString() {

        validateIsReadable();
        StringBuffer result = new StringBuffer();

        long value = toValue();

        long mm = value / MINUTES_DIV;

        if ( mm > 0 ) {
            result.append( mm ).append( " minutes " );
            value -= mm * MINUTES_DIV;
        }

        long ss = value / SEC_DIV;
        if ( ss > 0 ) {
            result.append( ss ).append( " sec " );
            value -= ss * SEC_DIV;
        }

        long ms = Math.round( value * 1.0 / MS_DIV );
        if ( ms > 0 ) {
            result.append( ms ).append( " ms" );
        }

        return result.toString();
    }

    public long getMilliStart() {

        return milliStart;
    }

    public void setMilliStart( long milliStart ) {

        this.milliStart = milliStart;
    }



    public Class <?> getCalledClass() {

        return calledClass;
    }

    public void setCalledClass( Class <?> calledClass ) {

        this.calledClass = calledClass;
    }

    public long getMilliStop() {

        return milliStop;
    }

    public void setMilliStop( long milliStop ) {

        this.milliStop = milliStop;
    }

    /**
     * Express the "reading" on the stopwatch as a numeric type.
     * 
     * @throws IllegalStateException
     *             if the Stopwatch has never been used, or if the stopwatch is
     *             still running.
     */
    public long toValue() {

        validateIsReadable();
        return fStop - fStart;
    }

    /**
     * Throws IllegalStateException if the watch has never been started, or if
     * the watch is still running.
     */
    private void validateIsReadable() {

        if ( fIsRunning ) {
            String message = "Cannot read a stopwatch which is still running.";
            throw new IllegalStateException( message );
        }
        if ( !fHasBeenUsedOnce ) {
            String message = "Cannot read a stopwatch which has never been started.";
            throw new IllegalStateException( message );
        }
    }

    //    /**
    //     * 
    //     * @param d
    //     * @param places
    //     * @return
    //     */
    //    private static final double fastRoundDouble(double d, int places)
    //    {
    //
    //        return Math.round(d * Math.pow(10, places)) / Math.pow(10, places);
    //    }

    /**
     * @return the fStart
     */
    public long getFStart() {

        return fStart;
    }

    /**
     * @return the fStop
     */
    public long getFStop() {

        return fStop;
    }

    /**
     * @return
     */
    public Date getStartDate() {

        return new Date( milliStart );
    }

    /**
     * @return
     */
    public Date getStopDate() {

        return new Date( milliStop );
    }

    /**
     * @return the watchName
     */
    public String getTaskName() {

        return taskName;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription( String description ) {

        this.description = description;
    }


}
