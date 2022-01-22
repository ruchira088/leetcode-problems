package com.ruchij;

import java.util.List;

public class CommonElements {
    public boolean hasCommon(List<Integer> listA, List<Integer> listB) {
        Integer[] sortedA =  listA.stream().sorted().toArray(Integer[]::new);
        Integer[] sortedB =  listB.stream().sorted().toArray(Integer[]::new);

        return sortedListHasCommon(sortedA, sortedB);
    }

    private boolean sortedListHasCommon(Integer[] arrayA, Integer[] arrayB) {
        int indexA = 0;
        int indexB = 0;

        while(indexA < arrayA.length && indexB < arrayB.length) {
            int valueA = arrayA[indexA];
            int valueB = arrayB[indexB];

            if (valueA == valueB) {
                return true;
            } else if (valueA > valueB){
                indexB++;
            } else {
                indexA++;
            }
        }

        return false;
    }
}
