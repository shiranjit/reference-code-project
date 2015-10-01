/**
 * 
 */



package com.shirish.listAlgo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * @author shirish
 *
 */
public class ListMergeAlgorithTest {

    private ListMergeAlgorith lmAlgo;


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

        lmAlgo = new ListMergeAlgorith();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {

        lmAlgo = null;
    }

    /**
     * Test method for
     * {@link com.shirish.listAlgo.ListMergeAlgorith#mergeLists(java.util.HashMap, java.util.List)}
     * .
     */
    @Test
    public void testMergeLists() {

        System.out.println("Test one");
        try {
            List <DataItem> sourceTwo = new ArrayList <DataItem>();

            for ( int i = 0; i < 15; i++ ) {
                DataItem di = create( "srctwo" + i );
                di.setFromSourceTwo( true );
                sourceTwo.add( di );
            }

            HashMap <String, DataItem> sourceOneMap = new HashMap <String, DataItem>();

            for ( int i = 0; i < 15; i++ ) {
                String diId = "srcOne" + i;
                DataItem di = create( diId );
                sourceOneMap.put( diId, di );
            }

            List <DataItem> results = lmAlgo.mergeLists( sourceOneMap, sourceTwo );

            printList( results );
        }
        catch ( Exception e ) {
            e.printStackTrace();
            fail( "Not yet implemented" );
        }
    }
    
    
    /**
     * 
     */
    @Test
    public void testMergeWithSameSourceIdsLists() {

        System.out.println("Test three");
        try {
            List <DataItem> sourceTwo = new ArrayList <DataItem>();

            for ( int i = 0; i < 15; i++ ) {
                DataItem di = create( "srctwo" + i );
                di.setFromSourceTwo( true );
                sourceTwo.add( di );
            }

            HashMap <String, DataItem> sourceOneMap = new HashMap <String, DataItem>();

            for ( int i = 0; i < 15; i++ ) {
                String diId = "srctwo" + i;
                DataItem di = create( diId );
                sourceOneMap.put( diId, di );
            }

            List <DataItem> results = lmAlgo.mergeLists( sourceOneMap, sourceTwo );

            printList( results );
        }
        catch ( Exception e ) {
            e.printStackTrace();
            fail( "Not yet implemented" );
        }
    }

    /**
     * 
     */
    @Test
    public void testMergeWithOnlySourceTwoLists() {

        System.out.println("Test two");
        try {
            List <DataItem> sourceTwo = new ArrayList <DataItem>();


            HashMap <String, DataItem> sourceOneMap = new HashMap <String, DataItem>();

            for ( int i = 0; i < 15; i++ ) {
                String diId = "srcOne" + i;
                DataItem di = create( diId );
                sourceOneMap.put( diId, di );
            }

            List <DataItem> results = lmAlgo.mergeLists( sourceOneMap, sourceTwo );

            printList( results );
        }
        catch ( Exception e ) {
            e.printStackTrace();
            fail( "Not yet implemented" );
        }
    }

    /**
     * Prints the list..
     * @param results
     */
    private void printList( List <DataItem> results ) {

        for ( DataItem dataItem : results ) {
            System.out.println( "V:" + dataItem.toString() );
        }
        System.out.println("total size: " + results.size());
    }

    /**
     * create a test data item.
     * @param id
     * @return
     */
    private DataItem create( String id ) {

        DataItem di = new DataItem();
        di.setDataId( id );
        return di;
    }
}
