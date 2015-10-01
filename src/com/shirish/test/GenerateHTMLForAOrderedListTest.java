package com.shirish.test;

import junit.framework.TestCase;

import java.util.ArrayList;

public class GenerateHTMLForAOrderedListTest extends TestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }


    public void testGenerateOrderedTable() throws Exception {
        ArrayList<String> orderedlist = new ArrayList<String>();
        orderedlist.add("a");
        orderedlist.add("b");
        orderedlist.add("c");
        orderedlist.add("d");
        orderedlist.add("e");
        orderedlist.add("f");
        orderedlist.add("g");
        orderedlist.add("h");
//        orderedlist.add("i");
//        orderedlist.add("j");

        GenerateHTMLForAOrderedList genlist = new GenerateHTMLForAOrderedList();
        genlist.generateOrderedTable(orderedlist);
    }

}