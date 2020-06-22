package com.example.test.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Adopted
 */
public class SockLaundry {

    //Do not delete or edit this method, you can only modify the block
    public static int getMaximumPairOfSocks(int noOfWashes, Integer[] cleanPile, Integer[] dirtyPile) {
        return calculateDifference(cleanPile, dirtyPile, noOfWashes);
    }

    private static int calculateDifference(Integer[] arrA, Integer[] arrB, int limitArrB) {
        ArrayList<Integer> resultArrList = new ArrayList<>();
        Integer[] newArrB = new Integer[limitArrB];
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        System.arraycopy(arrB, 0, newArrB, 0, limitArrB);
        for (int i = 0; i < newArrB.length; i++) {
            if (Arrays.binarySearch(arrA, newArrB[i]) >= 0) {
                resultArrList.add(newArrB[i]);
            } else {
                resultArrList.add(newArrB[i]);
            }
        }
        resultArrList.addAll(Arrays.asList(arrA));
        
        java.util.Arrays.sort(arrA);
        Collections.sort(resultArrList);
        int index = (int) resultArrList.get(0);
        int count = 1;
        Double maxPairs = 0.0;
        for (int i = 0; i < resultArrList.size(); i++) {
            if (!resultArrList.get(i).equals(index)) {
                count = 1;
            }
            Double currentCount = Math.floor((count++) / 2);
            if (currentCount != 0.0) {
                if ((i <= (resultArrList.size() - 1))) {
                    if ((i + 1) != (int)resultArrList.size() && (int)resultArrList.get(i) < (int)resultArrList.get(i + 1)) {
                        maxPairs = maxPairs + currentCount;
                    }
                    if (i == resultArrList.size() - 1) {
                        maxPairs = maxPairs + currentCount;
                    }
                }
            }
            index = (int)resultArrList.get(i);
        }
        return (int) maxPairs.doubleValue();
    }
}
