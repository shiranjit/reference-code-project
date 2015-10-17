/**
 The MIT License (MIT)

Copyright (c) 2015 Shirish Ranjit

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.

 */

package com.shirish.performanceMonitor;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * @author shirish
 *
 */
public class TestStopWatch {

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {

    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {

    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {

    }

    /**
     * An example of the use of this class to time the execution of String
     * manipulation code.
     */
    @Test
    public void test() {
        
        Stopwatch stopwatch = new Stopwatch();

        stopwatch.start();

        // do stuff
        StringBuffer messageOne = new StringBuffer();
        int numIterations = 5000;
        for ( int idx = 0; idx < numIterations; ++idx ) {
            messageOne.append( "blah" );
        }

        stopwatch.stop();
        // Note that there is no need to call a method to get the duration,
        // since toString is automatic here
        System.out.println( "The reading for String Buffer is: "
                            + stopwatch );

        // reuse the same stopwatch to measure an alternative implementation
        // Note that there is no need to call a reset method.
        stopwatch.start();

        // do stuff again
        String messageTwo = null;
        for ( int idx = 0; idx < numIterations; ++idx ) {
            messageTwo = messageTwo
                         + "blah";
        }

        stopwatch.stop();
        // perform a numeric comparsion
        if ( stopwatch.toValue() > 5 ) {
            System.out.println( "The reading is high: "
                                + stopwatch );
        }
        else {
            System.out.println( "The reading is low: "
                                + stopwatch );
        }

    }

}
