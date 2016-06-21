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
 */



package com.shirish.performanceMonitor.common.service;

import com.shirish.performanceMonitor.common.AFCLogger;


/**
 * @author shirish
 * @Oct 27, 2015
 *
 */
public class PerfMonKeeperTestThread extends Thread {


    /**
     * 
     * @param name
     */
    public PerfMonKeeperTestThread(String name) {

        super( name );
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {

        super.run();

        try {

            AFCLogger alog = AFCLogger.getLogger( getClass() );

            alog.info( "starting now ----- " + getName() );

            PerfMonKeeper swk = PerfMonKeeper.getInstanceFromThreadLocal();
            for ( int i = 0; i < 10; i++ ) {

                PerfMonStopWatch sw1 = new PerfMonStopWatch( this.getClass(), PerfMonTaskEnum.APPLY_BL, "it-"+i);
                sw1.start();

                double sleepTimed = 100 * (2 * Math.random());
                alog.info( " rand number: " + sleepTimed );
                long sleepTime = (new Double( sleepTimed )).longValue();

                alog.info( getName() + " Sleep time: " + sleepTime );
                Thread.sleep( sleepTime );
                sw1.stop();
                swk.record( sw1 );
            }
            //            PerfMonStopWatch sw2 = new PerfMonStopWatch( this.getClass(), PerfMonTaskEnum.DO_PROCCESS );
            //            sw2.start();
            //
            //            sleepTimed = 10 + (int) (2 * Math.random());
            //             sleepTime = (new Double( sleepTimed )).longValue();
            //            
            //            alog.info( getName() + " Sleep time: " + sleepTime );
            //            Thread.sleep(  sleepTime   );
            //
            //            sw2.stop();
            //            swk.record( sw2 );
            //

            swk.finalPersist();

        }
        catch ( Exception e ) {
            e.printStackTrace();


        }

    }
}
