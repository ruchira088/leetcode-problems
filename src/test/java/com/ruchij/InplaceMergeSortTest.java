package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InplaceMergeSortTest {
    private static final InplaceMergeSort inplaceMergeSort = new InplaceMergeSort();

    @Test
    void expectedResult() {
        int[] input = new int[]{10, 3, 5, 2, 1, 9, 0, 4, 6, 7};
        inplaceMergeSort.sort(input);
        Assertions.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9, 10}, input);
    }

}