package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountBinarySubstringsTest {
    private final CountBinarySubstrings countBinarySubstrings = new CountBinarySubstrings();

    @Test
    void testOne() {
        assertEquals(6, countBinarySubstrings.countBinarySubstrings("00110011"));
    }

    @Test
    void testTwo() {
        assertEquals(4, countBinarySubstrings.countBinarySubstrings("10101"));
    }

    @Test
    void testThree() {
        assertEquals(0, countBinarySubstrings.countBinarySubstrings("1"));
    }

    @Test
    void testFour() {
        assertEquals(0, countBinarySubstrings.countBinarySubstrings(""));
    }

    @Test
    void testFive() {
        assertEquals(2, countBinarySubstrings.countBinarySubstrings("00100"));
    }

}