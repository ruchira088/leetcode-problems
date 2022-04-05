package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfSubArraysTest {
    private final SumOfSubArrays sumOfSubArrays = new SumOfSubArrays();

    @Test
    void testOne() {
        int[] input = {1, 2, 3};
        long result = sumOfSubArrays.subArrayRanges(input);

        assertEquals(4, result);
    }

    @Test
    void testTwo() {
        int[] input = {1, 3, 3};
        long result = sumOfSubArrays.subArrayRanges(input);

        assertEquals(4, result);
    }

    @Test
    void testThree() {
        int[] input = {4, -2, -3, 4, 1};
        long result = sumOfSubArrays.subArrayRanges(input);

        assertEquals(59, result);
    }

}