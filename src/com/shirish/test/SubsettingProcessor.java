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
