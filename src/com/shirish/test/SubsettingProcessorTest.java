package com.shirish.test;

import junit.framework.TestCase;

public class SubsettingProcessorTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    public void testIsSubset() throws Exception {
        int arr1[] = {11, 1, 13, 21, 3, 7};
        //int arr2[] = {11, 3, 7, 1};
        int arr2[] = {33, 35, 75, 15};

        SubsettingProcessor subset = new SubsettingProcessor();
        int bool = subset.isSubset(arr1,arr2);
        System.out.println(" subset : " +bool);

    }

}