/*
 * Copyright (c) 2015. Shirish Ranjit all rights reserved. Please contact the author for licensing details.
 */

package com.shirish.numbersystem;

import junit.framework.TestCase;

public class BinaryNumberSystemTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    public void testGetDecimalFromBinary() throws Exception {

        BinaryNumberSystem bd = new BinaryNumberSystem();
        System.out.println("11 ===> "+bd.getDecimalFromBinary(11));
        System.out.println("110 ===> "+bd.getDecimalFromBinary(110));
        System.out.println("100110 ===> "+bd.getDecimalFromBinary(100110));

    }

    public void testHexa(){
        try {
            BinaryNumberSystem bd = new BinaryNumberSystem();
            System.out.println("10000 ===>" + bd.toHex(10000));
            System.out.println("10000 ===>" + bd.toHex(10000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}