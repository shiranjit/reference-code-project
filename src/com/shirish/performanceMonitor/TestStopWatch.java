/**
 * 
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
