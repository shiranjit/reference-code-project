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

package com.shirish.test;

/**
 * Created by shirish on 12/23/14.
 */
public class SubsettingProcessor {

    /**
     * Return 1 if arr2[] is a subset of arr1[]
     */
    public int isSubset(int arr1[], int arr2[]) {
        int i = 0;
        int j = 0;
        for (i = 0; i < arr2.length; i++) {
            for (j = 0; j < arr1.length; j++) {
                if (arr2[i] == arr1[j]) {
                    break;
                }
            }
        /* If the above inner loop was not broken at all then
           arr2[i] is not present in arr1[] */
            if (j == arr1.length)
                return 0;
        }
        /* If we reach here then all elements of arr2[]  are present in arr1[] */
        return 1;
    }

}
