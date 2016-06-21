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

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.shirish.performanceMonitor.common.AFCLogger;


/**
 * @author shirish
 * @Oct 27, 2015
 *
 */
public class PerfMonKeeperTest {

    /**
     * 
     * @throws java.lang.Exception
     *             void
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }

    /**
     * 
     * @throws java.lang.Exception
     *             void
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {

    }

    /**
     * 
     * @throws java.lang.Exception
     *             void
     */
    @Before
    public void setUp() throws Exception {

    }

    /**
     * 
     * @throws java.lang.Exception
     *             void
     */
    @After
    public void tearDown() throws Exception {

    }

    /**
     * Test method for
     * {@link com.shirish.performanceMonitor.common.service.PerfMonKeeper#sortRecordList()}
     * .
     */
    @Test
    public void testRecordKeeper() {

        try {

            AFCLogger alog = AFCLogger.getLogger( getClass() );
            //System.out.println("printing here");
            alog.info( "starting now ----- " );
            //            PerfMonKeeper swk = PerfMonKeeper.getInstanceFromThreadLocal();
            //            PerfMonStopWatch sw1 = new PerfMonStopWatch( this.getClass(), PerfMonTaskEnum.APPLY_BL );
            //            sw1.start();
            //            Thread.sleep( 100 );
            //            sw1.stop();
            //            swk.record( sw1 );
            //            
            //            PerfMonStopWatch sw2 = new PerfMonStopWatch( this.getClass(), PerfMonTaskEnum.CHECK_CERTIFICATE );
            //            sw2.start();
            //            Thread.sleep( 100 );
            //            sw2.stop();
            //            swk.record( sw2 );
            //            
            //            
            //            swk.finalPersist();

            PerfMonKeeperTestThread peft1 = new PerfMonKeeperTestThread( "First" );
            peft1.start();

            PerfMonKeeperTestThread peft2 = new PerfMonKeeperTestThread( "Second" );
            peft2.start();

            for ( int i = 0; i < 5; i++ ) {
                PerfMonKeeperTestThread peft = new PerfMonKeeperTestThread( "Iteration-" +i );
                peft.start();
            }

            Thread.sleep( 10000 );

        }
        catch ( Exception e ) {
            e.printStackTrace();
            fail( "error" );

        }

    }

}
