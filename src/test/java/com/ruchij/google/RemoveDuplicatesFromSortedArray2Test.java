package com.ruchij.google;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RemoveDuplicatesFromSortedArray2Test {
    private static final RemoveDuplicatesFromSortedArray2 solution = new RemoveDuplicatesFromSortedArray2();

    @Test
    void verifyResult() {
        verifyResult(new int[]{1, 1, 1, 2, 2, 3}, new int[]{1, 1, 2, 2, 3});
        verifyResult(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 3, 3});

    }

    void verifyResult(int[] input, int[] output) {
        int result = solution.removeDuplicates(input);

        Assertions.assertEquals(result, output.length);

        for (int i = 0; i < output.length; i++) {
            assert input[i] == output[i];
        }
    }

}