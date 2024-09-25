package com.ruchij.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestRectangleInHistogramTest {
    private static final LargestRectangleInHistogram solution = new LargestRectangleInHistogram();

    @Test
    void verifyResults() {
        assertEquals(2, solution.largestRectangleArea(new int[] {1, 1}));
//        assertEquals(10, solution.largestRectangleArea(new int[] {2,1,5,6,2,3}));
//        assertEquals(4, solution.largestRectangleArea(new int[] {2,4}));
    }

}