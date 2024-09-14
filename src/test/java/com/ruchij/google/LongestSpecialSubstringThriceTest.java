package com.ruchij.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSpecialSubstringThriceTest {
    private static final LongestSpecialSubstringThrice solution = new LongestSpecialSubstringThrice();

    @Test
    void verifyResults() {
        assertEquals(2, solution.maximumLength("aaaa"));
        assertEquals(-1, solution.maximumLength("abcdef"));
        assertEquals(1, solution.maximumLength("abcaba"));
    }

}