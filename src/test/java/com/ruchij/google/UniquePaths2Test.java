package com.ruchij.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniquePaths2Test {
    private static final UniquePaths2 uniquePaths = new UniquePaths2();

    @Test
    void verifyResultsOne() {
        int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
        assertEquals(2, uniquePaths.uniquePathsWithObstacles(grid));
    }

    @Test
    void verifyResultsTwo() {
        int[][] grid = {{0,0}};
        assertEquals(1, uniquePaths.uniquePathsWithObstacles(grid));
    }

}