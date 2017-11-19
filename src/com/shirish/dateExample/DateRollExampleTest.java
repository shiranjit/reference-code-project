/**
 * 
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



package com.shirish.dateExample;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



/**
 * @author shirish
 * @Nov 18, 2017
 *
 */
public class DateRollExampleTest {

    private DateRollExample dre;


    /**
     * 
     * @throws java.lang.Exception
     *             void
     */
    @Before
    public void setUp() throws Exception {

        dre = new DateRollExample();
    }

    /**
     * 
     * @throws java.lang.Exception
     *             void
     */
    @After
    public void tearDown() throws Exception {

        dre = null;
    }

    /**
     * Test method for
     * {@link com.shirish.dateExample.DateRollExample#dateRoll5Compare(java.util.Date, java.util.Date)}
     * .
     */
    @Test
    public void testDateRollEqualDates() {

        try {
            System.out.println( "Test for same dates for d1 and d2 " );
            boolean isD2FiveDayslapart = dre.dateRoll5Compare( new Date(), new Date(), 5 );
            System.out.println( "Output flag: " +isD2FiveDayslapart );
            System.out.println( "Test for same dates for d1 and d2  ===== complete \n\n" );
        }
        catch ( Exception e ) {

            e.printStackTrace();

            fail( "testDateRollEqualDates - failed" );
        }
    }

    /**
     * Test method for
     * {@link com.shirish.dateExample.DateRollExample#dateRoll5Compare(java.util.Date, java.util.Date)}
     * .
     */
    @Test
    public void testDateRollCaseA() {

        try {
            System.out.println( "Test for d1 and d2+7 " );
            Calendar cal = Calendar.getInstance();
            cal.roll( Calendar.DAY_OF_YEAR, 7 );
            boolean isD2FiveDayslapart = dre.dateRoll5Compare( new Date(), cal.getTime() , 5 );
            System.out.println( "Output flag: " +isD2FiveDayslapart );
            System.out.println( "Test for d1 and d2+7 ====== complete \n\n " );
        }
        catch ( Exception e ) {
             fail( "testDateRollCaseA - failed" );
        }
    }
    
    /**
     * Test method for
     * {@link com.shirish.dateExample.DateRollExample#dateRoll5Compare(java.util.Date, java.util.Date)}
     * .
     */
    @Test
    public void testDateRollCaseB() {

        try {
            System.out.println( "Test for d1 and d2+3 " );
            Calendar cal = Calendar.getInstance();
            cal.roll( Calendar.DAY_OF_YEAR, 3 );
            boolean isD2FiveDayslapart = dre.dateRoll5Compare( new Date(), cal.getTime() , 5 );
            System.out.println( "Output flag: " +isD2FiveDayslapart );
            System.out.println( "Test for d1 and d2+3 ====== complete \n\n " );
        }
        catch ( Exception e ) {
             fail( "testDateRollCaseB - failed" );
        }
    }
    
    /**
     * Test method for
     * {@link com.shirish.dateExample.DateRollExample#dateRoll5Compare(java.util.Date, java.util.Date)}
     * .
     */
    @Test
    public void testDateRollCaseC() {

        try {
            System.out.println( "Test for d1 and d2+5 " );
            Calendar cal = Calendar.getInstance();
            cal.roll( Calendar.DAY_OF_YEAR, 5 );
            boolean isD2FiveDayslapart = dre.dateRoll5Compare( new Date(), cal.getTime(), 5  );
            System.out.println( "Output flag: " +isD2FiveDayslapart );
            System.out.println( "Test for d1 and d2+3 ====== complete \n\n " );
        }
        catch ( Exception e ) {
             fail( "testDateRollCaseC - failed" );
        }
    }
}
