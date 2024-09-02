package com.ruchij.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {
    private static final ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

    @Test
    void verifyResult() {
        assertEquals(49, containerWithMostWater.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
        assertEquals(1, containerWithMostWater.maxArea(new int[] {1, 1}));
    }

}