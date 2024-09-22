package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GreatestCommonDivisorOfStringsTest {

    @Test
    void gcdReturnsExpectedResult() {
        GreatestCommonDivisorOfStrings greatestCommonDivisorOfStrings = new GreatestCommonDivisorOfStrings();

        Assertions.assertEquals("ABC", greatestCommonDivisorOfStrings.gcdOfStrings("ABCABC", "ABC"));
        Assertions.assertEquals("AB", greatestCommonDivisorOfStrings.gcdOfStrings("ABABAB", "ABAB"));
        Assertions.assertEquals("", greatestCommonDivisorOfStrings.gcdOfStrings("LEET", "CODE"));

        Assertions.assertEquals("", greatestCommonDivisorOfStrings.gcdOfStrings("AAAAAAAAA", "AAACCC"));
    }

}