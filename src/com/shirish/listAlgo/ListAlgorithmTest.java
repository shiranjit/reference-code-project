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

package com.shirish.listAlgo;

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
public class ListAlgorithmTest {
    private ListAlgorithm listAlgo;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        listAlgo = new ListAlgorithm();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        listAlgo= null;
    }

    /**
     * Test method for {@link com.shirish.listAlgo.ListAlgorithm#reverseList()}.
     */
    @Test
    public void testReverseList() {
        try {
            ListAlgorithm la = new ListAlgorithm();
            la.reverseList();
        }
        catch ( Exception e ) {
            e.printStackTrace();
            fail( "Not yet implemented" );
        }
        
        
    }
    
    @Test
    public void testReverseListInHalf(){
        try {
            listAlgo.reverseAListHalfSteps();
        }
        catch ( Exception e ) {
            e.printStackTrace();
            fail( "Not yet implemented" );
        }
        
    }
    
    @Test
    public void testStuff(){
        myMysteryMethod( 10 );        
    }

    public static void myMysteryMethod ( int max )
    {
      for ( int i = 1; i <= max; i++ ) {
        for ( int j = 1; j <= max; j++ ) {
          System.out.print ( " "+i + " " +j+ " - "+ String.format ( "%4d", j * i ) + ";    ");
        }
      System.out.println();
      }
    }

}
