package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestCommonPrefixTest {
    private final LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

    @Test
    void testOne() {
        String[] input = {"flower", "flow", "flight"};

        Assertions.assertEquals("fl", longestCommonPrefix.longestCommonPrefix(input));
    }

    @Test
    void testTwo() {
        String[] input = {"dog", "racecar", "car"};

        Assertions.assertEquals("", longestCommonPrefix.longestCommonPrefix(input));
    }

}