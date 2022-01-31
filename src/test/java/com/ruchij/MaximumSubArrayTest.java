package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumSubArrayTest {
    private final MaximumSubArray maximumSubArray = new MaximumSubArray();

    @Test
    void testOne() {
        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        Assertions.assertEquals(6, maximumSubArray.maxSubArray(input));
    }

    @Test
    void testTwo() {
        int[] input = {5, 4, -1, 7, 8};

        Assertions.assertEquals(23, maximumSubArray.maxSubArray(input));
    }

    @Test
    void testThree() {
        int[] input = {1};

        Assertions.assertEquals(1, maximumSubArray.maxSubArray(input));
    }

    @Test
    void testFour() {
        int[] input = {1, 2};

        Assertions.assertEquals(3, maximumSubArray.maxSubArray(input));
    }

}