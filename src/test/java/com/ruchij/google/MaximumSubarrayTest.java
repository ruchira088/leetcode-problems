package com.ruchij.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSubarrayTest {
    private static final MaximumSubarray solution = new MaximumSubarray();

    @Test
    void verifyResult() {
        assertEquals(6, solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        assertEquals(1, solution.maxSubArray(new int[]{1}));
        assertEquals(23, solution.maxSubArray(new int[]{5,4,-1,7,8}));
        assertEquals(-10, solution.maxSubArray(new int[]{-12, -10}));

    }

}