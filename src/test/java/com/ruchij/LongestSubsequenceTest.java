package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubsequenceTest {
    private final LongestSubsequence longestSubsequence = new LongestSubsequence();

    @Test
    void testOne() {
        assertEquals(4, longestSubsequence.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    @Test
    void testTwo() {
        assertEquals(4, longestSubsequence.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
    }

    @Test
    void testThree() {
        assertEquals(1, longestSubsequence.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }

}