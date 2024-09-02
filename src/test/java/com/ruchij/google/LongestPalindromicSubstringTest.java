package com.ruchij.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringTest {
    private static final LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

    @Test
    void verifyResult() {
        assertEquals("bab", longestPalindromicSubstring.longestPalindrome("babad"));
        assertEquals("bb", longestPalindromicSubstring.longestPalindrome("cbbd"));
    }

}