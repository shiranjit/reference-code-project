/**
 * The MIT License (MIT)
 * 
 * Copyright (c) 2015 Shirish Ranjit
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 */



package com.shirish.appMonitor.common.stopwatch;

import java.util.Date;


/**
 * ApStopwatch to time the execution time. This is elapsed time not CPU time.
 * 
 * 
 */
public final class ApStopwatch {

	private static final double million = 1000000;
	private static final double thousand = 1000;
	
    private long      fStart;
    private long      fStop;

    private boolean   fIsRunning;
    private boolean   fHasBeenUsedOnce;
    private String    description;
    private String    taskName;
    private Class <?> calledClass;


    /**
     * 
     * @param calledClass
     * @param taskName
     */
    public ApStopwatch(Class <?> calledClass, String taskName) {

        this.calledClass = calledClass;
        this.taskName = taskName;
    }

    public ApStopwatch(Class <?> calledClass, String taskName, String description) {

        this.calledClass = calledClass;
        this.taskName = taskName;
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
            // throw new IllegalStateException( "Must stop before calling start
            // again." );
            return;
        }
        // reset both start and stop
        fStart = System.nanoTime();
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
            // throw new IllegalStateException( "Cannot stop if not currently
            // running." );
            return;
        }
        fStop = System.nanoTime();
        fIsRunning = false;
    }

    /**
     * Express the "reading" on the stopwatch.
     * 
     * @throws IllegalStateException
     *             if the ApStopwatch has never been used, or if the stopwatch is
     *             still running.
     */
    @Override
    public String toString() {

        validateIsReadable();
        StringBuffer result = new StringBuffer();

        long value = toValue();

        if ( value <= million * thousand ) {
            result.append( toValue()/million );
            result.append( " ,ms" );

        }
        else {

            double seconds = fastRoundDouble( value / (million * thousand ), 2 );

            if ( seconds <= 60 ) {

                result.append( seconds );
                result.append( " ,sec" );
            }
            else {

                double minutes = fastRoundDouble( seconds / 60, 2 );

                result.append( minutes );
                result.append( " ,min" );

            }
        }


        return result.toString();
    }

    /**
     * Express the "reading" on the stopwatch as a numeric type.
     * 
     * @throws IllegalStateException
     *             if the ApStopwatch has never been used, or if the stopwatch is
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




    /**
     * 
     * @param d
     * @param places
     * @return
     */
    private static final double fastRoundDouble(
                                                 double d, int places )
    {

        return Math.round( d * Math.pow( 10, places ) ) / Math.pow( 10, places );
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


    /**
     * description String
     * @return the description
     */
    public String getDescription() {

        return description;
    }


    /**
     * @param description the description to set
     */
    public void setDescription(
                                String description )
    {

        this.description = description;
    }


    /**
     * taskName String
     * @return the taskName
     */
    public String getTaskName() {

        return taskName;
    }


    /**
     * @param taskName the taskName to set
     */
    public void setTaskName(
                             String taskName )
    {

        this.taskName = taskName;
    }


    /**
     * calledClass Class<?>
     * @return the calledClass
     */
    public Class <?> getCalledClass() {

        return calledClass;
    }


    /**
     * @param calledClass the calledClass to set
     */
    public void setCalledClass(
                                Class <?> calledClass )
    {

        this.calledClass = calledClass;
    }

}
