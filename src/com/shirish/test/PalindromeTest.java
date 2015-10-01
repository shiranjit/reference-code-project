package com.shirish.test;

import junit.framework.TestCase;

public class PalindromeTest extends TestCase {

    public void testPalindromeM() throws Exception {

        Palindrome pl = new Palindrome();
        assertTrue(pl.palindromeM());
    }
}