package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SubstringMatchingTest {
    private final SubstringMatching substringMatching = new SubstringMatching();

    @Test
    void testOne() {
        Assertions.assertTrue(substringMatching.repeatedSubstringPattern("abab"));
    }

    @Test
    void testTwo() {
        Assertions.assertFalse(substringMatching.repeatedSubstringPattern("aba"));
    }

    @Test
    void testThree() {
        Assertions.assertTrue(substringMatching.repeatedSubstringPattern("abcabcabcabc"));
    }

}