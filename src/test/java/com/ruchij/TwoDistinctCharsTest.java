package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoDistinctCharsTest {
    private final TwoDistinctChars twoDistinctChars = new TwoDistinctChars();

    @Test
    void testOne() {
        Assertions.assertEquals(3, twoDistinctChars.lengthOfLongestSubstringTwoDistinct("eceba"));
    }

    @Test
    void testTwo() {
        Assertions.assertEquals(5, twoDistinctChars.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }

}