package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumWindowSubsequenceTest {
    private final MinimumWindowSubsequence minimumWindowSubsequence = new MinimumWindowSubsequence();

    @Test
    void testOne() {
        assertEquals("bcde", minimumWindowSubsequence.minWindow("abbbbbbbbbbbbbbbbbbbcdebdde", "bde"));
    }

    @Test
    void testTwo() {
        assertEquals("", minimumWindowSubsequence.minWindow("jmeqksfrsdcmsiwvaovztaqenprpvnbstl", "u"));
    }

    @Test
    void testThree() {
        assertEquals("l", minimumWindowSubsequence.minWindow("jmeqksfrsdcmsiwvaovztaqenprpvnbstl", "l"));
    }

}