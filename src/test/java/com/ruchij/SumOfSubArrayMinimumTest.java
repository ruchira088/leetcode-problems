package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfSubArrayMinimumTest {
    private final SumOfSubArrayMinimum sumOfSubArrayMinimum = new SumOfSubArrayMinimum();

    @Test
    void testOne() {
        int[] input = {3, 1, 2, 4};
        assertEquals(17, sumOfSubArrayMinimum.sumSubarrayMins(input));
    }

    @Test
    void testTwo() {
        int[] input = {11, 81, 94, 43, 3};
        assertEquals(444, sumOfSubArrayMinimum.sumSubarrayMins(input));
    }

}