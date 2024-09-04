package com.ruchij.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {
    private static final LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

    @Test
    void verifyResults() {
        assertEquals("fl", longestCommonPrefix.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        assertEquals("", longestCommonPrefix.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        assertEquals("", longestCommonPrefix.longestCommonPrefix(new String[]{"reflower","flow","flight"}));
    }

}