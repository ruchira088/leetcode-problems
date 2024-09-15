package com.ruchij.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumNumberOfPointsWithCostTest {
    private static final MaximumNumberOfPointsWithCost solution = new MaximumNumberOfPointsWithCost();

    @Test
    void verifyResults() {
        assertEquals(
                9,
                solution.maxPoints(
                        new int[][]{
                                new int[]{1, 2, 3},
                                new int[]{1, 5, 1},
                                new int[]{3, 1, 1}

                        }
                )
        );

        assertEquals(
                11,
                solution.maxPoints(
                        new int[][]{
                                new int[]{1, 5},
                                new int[]{2, 3},
                                new int[]{4, 2}

                        }
                )
        );

        assertEquals(
                11,
                solution.maxPoints(
                        new int[][]{
                                new int[]{1, 5},
                                new int[]{3, 2},
                                new int[]{4, 2}

                        }
                )
        );
    }

}