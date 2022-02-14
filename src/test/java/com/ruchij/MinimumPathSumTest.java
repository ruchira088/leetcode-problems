package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumPathSumTest {
    private final MinimumPathSum minimumPathSum = new MinimumPathSum();

    @Test
    void testOne() {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        assertEquals(7, minimumPathSum.minPathSum(grid));
    }

}