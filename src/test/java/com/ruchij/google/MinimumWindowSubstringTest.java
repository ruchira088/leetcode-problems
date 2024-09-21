package com.ruchij.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumWindowSubstringTest {
    private static final MinimumWindowSubstring solution = new MinimumWindowSubstring();

    @Test
    void verifyResults() {
        assertEquals("", solution.minWindow("babb", "baba"));
        assertEquals("bca", solution.minWindow("ancbbbcaa", "abc"));
        assertEquals("bca", solution.minWindow("adobecodebancbbcaa", "abc"));
        assertEquals("ba", solution.minWindow("bba", "ab"));
        assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("a", solution.minWindow("a", "a"));
        assertEquals("", solution.minWindow("a", "aa"));
        assertEquals("", solution.minWindow("a", "b"));
    }

}