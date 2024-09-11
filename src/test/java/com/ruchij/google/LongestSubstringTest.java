package com.ruchij.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringTest {
    private static final LongestSubstring longestSubstring = new LongestSubstring();

    @Test
    void verifyResult() {
//        assertEquals(3, longestSubstring.lengthOfLongestSubstring("abcabcbb"));
//        assertEquals(1, longestSubstring.lengthOfLongestSubstring("bbbbb"));
//        assertEquals(3, longestSubstring.lengthOfLongestSubstring("pwwkew"));
        assertEquals(5, longestSubstring.lengthOfLongestSubstring("tmmzuxt"));
    }

}