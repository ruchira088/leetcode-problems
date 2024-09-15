package com.ruchij.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinCostClimbingStairsTest {
    private static final MinCostClimbingStairs solution = new MinCostClimbingStairs();

    @Test
    void verifyResults() {
        assertEquals(15, solution.minCostClimbingStairs(new int[] {10, 15, 20}));
        assertEquals(6, solution.minCostClimbingStairs(new int[] {1,100,1,1,1,100,1,1,100,1}));
    }

}