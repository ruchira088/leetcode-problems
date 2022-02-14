package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeTest {
    private final ValidPalindrome validPalindrome = new ValidPalindrome();

    @Test
    void testOne() {
        assertTrue(validPalindrome.validPalindrome("aba"));
    }

    @Test
    void testTwo() {
        assertTrue(validPalindrome.validPalindrome("abca"));
    }

    @Test
    void testThree() {
        assertFalse(validPalindrome.validPalindrome("abc"));
    }

    @Test
    void testFour() {
        assertTrue(validPalindrome.validPalindrome("abbbbac"));
    }

}