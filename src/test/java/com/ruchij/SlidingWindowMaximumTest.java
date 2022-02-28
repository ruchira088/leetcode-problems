package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SlidingWindowMaximumTest {
    private final SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();

    @Test
    void testOne() {
        int[] input = {1, 3, -1, -3, 5, 3, 6, 7};
        assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, slidingWindowMaximum.maxSlidingWindow(input, 3));
    }

}