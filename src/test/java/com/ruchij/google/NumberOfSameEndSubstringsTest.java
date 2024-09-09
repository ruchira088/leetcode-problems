package com.ruchij.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfSameEndSubstringsTest {
    private static final NumberOfSameEndSubstrings solution = new NumberOfSameEndSubstrings();

    @Test
    void verifyResults() {
        assertArrayEquals(new int[] {1,5,5,10}, solution.sameEndSubstringCount("abcaab", new int[][]{new int[]{0, 0}, new int[]{1, 4}, new int[]{2, 5}, new int[]{0, 5}}));
    }

}