/**
 * 
 */
package com.shirish.sortingAlgo;

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
public class QuickSortTest {

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
     * Test method for {@link com.shirish.sortingAlgo.QuickSort#quickSort(int[])}.
     */
    @Test
    public void testQuickSort() {
        try {
            QuickSort qs = new QuickSort();
            int[] listToSort = qs.prepareAlist();
            qs.quickSort( listToSort );
        }
        catch ( Exception e ) {
            e.printStackTrace();
            fail( "Not yet implemented" );
        }
                
        
    }

}
