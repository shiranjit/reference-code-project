package com.shirish.test;

/**
 * Created by shirish on 1/27/15.
 */
public class Palindrome {

    private String word;

    public Palindrome(){
        createData();
    }

    private void createData(){

        //word = "shirihs";
        word = "abcdeedcba";
    }

    public boolean palindromeM(){
        boolean isPalendrome = true;
        int lenghtOfword = word.length();
        for (int i = 0; i < lenghtOfword; i++) {
            if (word.charAt(i)!=word.charAt(lenghtOfword-1-i)){
                isPalendrome = false;
                break;
            }
        }
        return isPalendrome;
    }
}
