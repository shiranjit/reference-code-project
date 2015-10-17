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

package com.shirish.sortingAlgo;


/**
 * Created by shirish on 1/25/15.
 */
public class BubbleSort {

    int[] listToSort = new int[7];

    public BubbleSort() {

    }

    public void prepareTestList(){
        // 5 1 4 2 8
        listToSort[0] = 5;
        listToSort[1]=8;
        listToSort[2]=4;
        listToSort[3]=2;
        listToSort[4]= 3;
        listToSort[5]= 10;
        listToSort[6]= 1;

    }

    public void bubbleSort(){
        bubbleSortAlgo(this.listToSort);

        for (int i = 0; i < this.listToSort.length; i++) {
            System.out.print(this.listToSort[i] + ", ");
        }
    }

    /**
     * When going through a list, if we did not swap at all, then we know that the list is sorted.
     * We also know that we need to go through n outer loop.
     * @param arrayToSort
     */
    private void bubbleSortAlgo(int[] arrayToSort){

        boolean isSwapped = true;
        int n = arrayToSort.length;
        int loopcount=0;
        while (isSwapped) {
            isSwapped = false;
            //inner loop.
            for (int i = 1; i < n; i++){
                if(arrayToSort[i-1]> arrayToSort[i]){
                    Integer bigElement = arrayToSort[i-1];
                    Integer smallElement = arrayToSort[i];
                    arrayToSort[i-1] = smallElement;
                    arrayToSort[i] =bigElement;
                    isSwapped = true;
                }
            }
            loopcount++;
            System.out.println(" loops: " + loopcount);
        }
    }

}
