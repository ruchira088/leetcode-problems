package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TrappingRainWaterTest {
    private final TrappingRainWater trappingRainWater = new TrappingRainWater();

    @Test
    void testOne() {
        int[] input = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        Assertions.assertEquals(6, trappingRainWater.trap(input));
    }

    @Test
    void testTwo() {
        int[] input = {4,2,0,3,2,5};

        Assertions.assertEquals(9, trappingRainWater.trap(input));
    }

    @Test
    void testThree() {
        int[] input = {4,2,3};

        Assertions.assertEquals(1, trappingRainWater.trap(input));
    }

}