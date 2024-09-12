package com.ruchij.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesFromSortedArrayTest {
    private static final RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();

    @Test
    void verifyResults() {
        verifyResult(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, new int[]{0, 1, 2, 3, 4});
        verifyResult(new int[]{1, 1, 2}, new int[]{1, 2});
    }

    void verifyResult(int[] input, int[] expected) {
        int count = solution.removeDuplicates(input);

        assertEquals(expected.length, count);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], input[i]);
        }
    }

}