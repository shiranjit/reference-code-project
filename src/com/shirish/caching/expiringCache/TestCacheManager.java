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
package com.shirish.caching.expiringCache;

import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author SRANJIT
 */
public class TestCacheManager extends TestCase {

    private GenericCacheManager caheManager;

    /**
     * Constructor for TestCacheManager.
     * 
     * @param arg0
     */
    public TestCacheManager(String arg0) {
        super(arg0);
    }

    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        //BasicConfigurator.configure();
        LoggerContext lcontext = (LoggerContext)LogManager.getContext();
        Configuration lconfig = lcontext.getConfiguration();
        lconfig.getRootLogger().setLevel( Level.DEBUG );
        caheManager = GenericCacheManager.getHandle();
    }

    /*
     * @see TestCase#tearDown()
     */
    protected void tearDown() throws Exception {

    }

    /**
     * 
     * 
     * void
     */
    public void testGetCache() {

        try {
            CachedObject value = new CachedObject("AUTX", "ABNA",200);
            caheManager.putInCache( "ABNA", value );
            for (int i = 0; i < 10; i++) {
                CachedObject bvo = caheManager.getfromCache("ABNA");
                System.out.println("This is the boject: " + bvo);
                Thread.sleep( 1000 );
            }

        }
        catch (Exception e) {
            // TODO write the exception
            e.printStackTrace();
            fail("Test failed.");
        }
    }

    /**
     * Assembles and returns a test suite for all the test methods of this test
     * case.
     * 
     * @return A non-null test suite.
     */
    public static Test suite() {
        // Reflection is used here to add all the testXXX() methods to the
        // suite.
        TestSuite suite = new TestSuite(TestCacheManager.class);
        return suite;
    }

    /**
     * Runs the test case.
     * 
     * @param args The command line arguments.
     */
    public static void main(String args[]) {
        String[] testCaseName = {TestCacheManager.class
                .getName() };
        junit.textui.TestRunner.main(testCaseName);
    }
}