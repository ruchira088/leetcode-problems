package com.ruchij.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestConsecutiveSequenceTest {
    private static final LongestConsecutiveSequence solution = new LongestConsecutiveSequence();

    @Test
    void verifyResults() {
//        assertEquals(4, solution.longestConsecutive(new int[] {100,4,200,1,3,2}));
        assertEquals(9, solution.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));
    }

}