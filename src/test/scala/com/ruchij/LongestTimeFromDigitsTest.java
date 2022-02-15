package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestTimeFromDigitsTest {
    private final LongestTimeFromDigits longestTimeFromDigits = new LongestTimeFromDigits();

    @Test
    void testOne() {
        Assertions.assertEquals("23:41", longestTimeFromDigits.largestTimeFromDigits(new int[] {1, 2, 3, 4}));
    }

    @Test
    void testTwo() {
        Assertions.assertEquals("", longestTimeFromDigits.largestTimeFromDigits(new int[] {5, 5, 5, 5}));
    }

}