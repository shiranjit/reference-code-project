/*
 * Copyright (c) 2015. Shirish Ranjit all rights reserved. Please contact the author for licensing details.
 */

package com.shirish.numbersystem;

/**
 * Created by shirish on 2/10/15.
 */
public class BinaryNumberSystem {

        public int getDecimalFromBinary(int binary){

            int decimal = 0;
            int power = 0;
            while(binary!=0){

                    int tmp = binary%10;
                    decimal += tmp*Math.pow(2, power);
                    binary = binary/10;
                    power++;

            }
            return decimal;
        }

    public String toHex(int d) {
        int r = d % 16;
        String result;
        if (d-r == 0)
            result = toChar(r);
        else
            result = toHex( (d-r)/16 ) + toChar(r);
        return result;
    }

    private String toChar(int n) {
        String alpha = "0123456789ABCDEF";
        return ""+alpha.charAt(n);
    }
}
