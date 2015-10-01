package com.shirish.sortingAlgo;

import junit.framework.TestCase;

/**
 * Created by shirish on 1/25/15.
 */
public class BubbleSortTest extends TestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testBubbleSort() throws Exception {
        BubbleSort bsort = new BubbleSort();
        bsort.prepareTestList();
        bsort.bubbleSort();

    }
}
