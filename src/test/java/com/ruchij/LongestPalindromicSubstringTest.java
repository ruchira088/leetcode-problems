package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestPalindromicSubstringTest {

    @Test
    void checkIfWordIsPalindrome() {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

        Assertions.assertTrue(longestPalindromicSubstring.isPalindrome("abba"));
        Assertions.assertFalse(longestPalindromicSubstring.isPalindrome("abbac"));
    }

    @Test
    void checkLongestPalindrome() {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

        Assertions.assertEquals("bab", longestPalindromicSubstring.longestPalindrome("babad"));
        Assertions.assertEquals("bb", longestPalindromicSubstring.longestPalindrome("cbbd"));
    }

}