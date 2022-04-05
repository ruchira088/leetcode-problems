package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumSwapsGroupOneTest {
    private final MinimumSwapsGroupOne minimumSwapsGroupOne = new MinimumSwapsGroupOne();

    @Test
    void testOne() {
        int[] input = {1, 0, 1, 0, 1};
        assertEquals(1, minimumSwapsGroupOne.minSwaps(input));
    }

    @Test
    void testTwo() {
        int[] input = {0, 0, 0, 1, 0};
        assertEquals(0, minimumSwapsGroupOne.minSwaps(input));
    }

    @Test
    void testThree() {
        int[] input = {1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1};
        assertEquals(3, minimumSwapsGroupOne.minSwaps(input));
    }

}