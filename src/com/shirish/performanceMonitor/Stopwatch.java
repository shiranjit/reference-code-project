


package com.shirish.performanceMonitor;

import java.util.Date;


/**
 * Stopwatch to time the execution time. This is elapsed time not CPU time.
 * 
 * 
 */
public final class Stopwatch {

    private long    fStart;
    private long    fStop;

    private boolean fIsRunning;
    private boolean fHasBeenUsedOnce;




    /**
     * Start the stopwatch.
     * 
     * @throws IllegalStateException
     *             if the stopwatch is already running.
     */
    public void start() {

        if ( fIsRunning ) {
            throw new IllegalStateException( "Must stop before calling start again." );
        }
        // reset both start and stop
        fStart = System.currentTimeMillis();
        fStop = 0;
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
            throw new IllegalStateException( "Cannot stop if not currently running." );
        }
        fStop = System.currentTimeMillis();
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

        if ( value <= 1000 ) {
            result.append( toValue() );
            result.append( " ms" );

        }
        else {

            double seconds = fastRoundDouble( value / 1000,
                                              2 );

            if ( seconds <= 60 ) {

                result.append( seconds );
                result.append( " sec" );
            }
            else {

                double minutes = fastRoundDouble( seconds / 60,
                                                  2 );

                result.append( minutes );
                result.append( " min" );

            }
        }


        return result.toString();
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
        return fStop
               - fStart;
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



    

    /**
     * 
     * @param d
     * @param places
     * @return
     */
    private static final double fastRoundDouble( double d,
                                                 int places )
    {

        return Math.round( d
                           * Math.pow( 10,
                                       places ) )
               / Math.pow( 10,
                           places );
    }


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

        return new Date( fStart );
    }

    /**
     * @return
     */
    public Date getStopDate() {

        return new Date( fStop );
    }

}
