


package com.shirish.sortingAlgo;


public class QuickSort {

    public int[] prepareAlist() {

//        int[] listToSort = new int[7];
//        // 5 1 4 2 8
//        listToSort[0] = 5;
//        listToSort[1] = 8;
//        listToSort[2] = 4;
//        listToSort[3] = 2;
//        listToSort[4] = 3;
//        listToSort[5] = 10;
//        listToSort[6] = 1;
//        return listToSort;
        
         int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
         return list;
    }


    public void quickSort( int[] list ) {

        quickSort( list, 0, list.length - 1 );
        
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + ", ");
        }
    }

    private void quickSort( int[] list, int first, int last ) {

        if ( last > first ) {
            int pivotIndex = partition( list, first, last );
            quickSort( list, first, pivotIndex - 1 );
            quickSort( list, pivotIndex + 1, last );
        }
    }

    /** Partition the array list[first..last] */
    private int partition( int[] list, int first, int last ) {

        int pivot = list[first]; // Choose the first element as the pivot
        int low = first + 1; // Index for forward search
        int high = last; // Index for backward search

        while ( high > low ) {
            // Search forward from left
            while ( low <= high && list[low] <= pivot )
                low++;

            // Search backward from right
            while ( low <= high && list[high] > pivot )
                high--;

            // Swap two elements in the list
            if ( high > low ) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while ( high > first && list[high] >= pivot )
            high--;

        // Swap pivot with list[high]
        if ( pivot > list[high] ) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else {
            return first;
        }
    }

}
