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
