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
package com.shirish.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * @author shirish
 * @Jun 21, 2016
 *
 */
public class StringTestCaseTest {

    private StringTestCase testingString;
    /**
     * 
     * @throws java.lang.Exception
     * void
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
    }

    /**
     * 
     * @throws java.lang.Exception
     * void
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        
    }

    /**
     * 
     * @throws java.lang.Exception
     * void
     */
    @Before
    public void setUp() throws Exception {
        testingString = new StringTestCase();
    }

    /**
     * 
     * @throws java.lang.Exception
     * void
     */
    @After
    public void tearDown() throws Exception {
        testingString = null;
    }

    @Test
    public void test() {
        testingString.testStringPassCase();
        
       // fail( "Not yet implemented" );
    }

}
