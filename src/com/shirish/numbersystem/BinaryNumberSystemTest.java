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