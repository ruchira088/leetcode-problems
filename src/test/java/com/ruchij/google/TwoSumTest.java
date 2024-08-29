package com.ruchij.google;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TwoSumTest {
    private static final TwoSum twoSum = new TwoSum();

    @Test
    void verifyResult() {
        int[] result = twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        Assertions.assertArrayEquals(new int[]{0, 1}, result);

        result = twoSum.twoSum(new int[] {3, 2, 4}, 6);
        Assertions.assertArrayEquals(new int[]{1, 2}, result);

        result = twoSum.twoSum(new int[] {3, 3}, 6);
        Assertions.assertArrayEquals(new int[]{0, 1}, result);
    }

}