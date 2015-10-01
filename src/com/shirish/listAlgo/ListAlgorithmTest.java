/**
 * 
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
