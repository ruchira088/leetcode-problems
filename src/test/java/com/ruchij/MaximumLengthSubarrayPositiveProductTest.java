package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumLengthSubarrayPositiveProductTest {
    private final MaximumLengthSubarrayPositiveProduct maximumLengthSubarrayPositiveProduct =
            new MaximumLengthSubarrayPositiveProduct();

    @Test
    void testOne() {
        assertEquals(4, maximumLengthSubarrayPositiveProduct.getMaxLen(new int[]{1, -2, -3, 4}));
    }

    @Test
    void testTwo() {
        assertEquals(3, maximumLengthSubarrayPositiveProduct.getMaxLen(new int[]{0, 1, -2, -3, -4}));
    }

    @Test
    void testThree() {
        assertEquals(2, maximumLengthSubarrayPositiveProduct.getMaxLen(new int[]{-1, -2, -3, 0, 1}));
    }

    @Test
    void testFour() {
        assertEquals(1, maximumLengthSubarrayPositiveProduct.getMaxLen(new int[]{-1, 2}));
    }

}