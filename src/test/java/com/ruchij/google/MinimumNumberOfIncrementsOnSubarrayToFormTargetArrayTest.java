package com.ruchij.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumNumberOfIncrementsOnSubarrayToFormTargetArrayTest {
    private static final MinimumNumberOfIncrementsOnSubarrayToFormTargetArray
        solution = new MinimumNumberOfIncrementsOnSubarrayToFormTargetArray();

    @Test
    void verifyResult() {
        assertEquals(3, solution.minNumberOperations(new int[]{1,2,3,2,1}));
        assertEquals(4, solution.minNumberOperations(new int[]{3,1,1,2}));
        assertEquals(7, solution.minNumberOperations(new int[]{3,1,5,4,2}));
    }

}