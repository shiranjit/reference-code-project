/**
 * Teeznar Corp
 * All rights reserved
 *
 * 2014
 */
package com.shirish.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 *
 */
public class TestMapTest {

    private TestMap testM;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
	testM = new TestMap();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
	testM = null;
    }

    /**
     * Test method for {@link com.shirish.test.TestMap#mapTesting()}.
     */
    @Test
    public void testMapTesting() {
	try {
	    testM.mapTesting();
	}
	catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();

	    fail("Not yet implemented");
	}
    }

}
