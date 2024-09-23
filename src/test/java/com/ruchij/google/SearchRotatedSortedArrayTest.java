package com.ruchij.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchRotatedSortedArrayTest {
    private static final SearchRotatedSortedArray solution = new SearchRotatedSortedArray();

    @Test
    void findStart() {
        assertEquals(3, solution.findStart(new int[] {2,5,6,0,0,1,2}));
        assertEquals(2, solution.findStart(new int[] {2,6,0,0,1,2}));
        assertEquals(0, solution.findStart(new int[] {0,0,1,2,2}));
        assertEquals(6, solution.findStart(new int[]{1, 1, 1, 1, 1, 2, 1, 1}));
        assertEquals(14, solution.findStart(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}));

    }

    @Test
    void verifyResults() {
        assertTrue(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        assertFalse(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
    }

}