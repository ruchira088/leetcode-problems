package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BurstBalloonsTest {
    private final BurstBalloons burstBalloons = new BurstBalloons();

    @Test
    void testOne() {
        int[] nums = {3, 1, 5, 8};
        assertEquals(167, burstBalloons.maxCoins(nums));
    }

    @Test
    void testTwo() {
        int[] nums = {1, 5};
        assertEquals(10, burstBalloons.maxCoins(nums));
    }

    @Test
    void testThree() {
        int[] nums = {9, 76, 64, 21};
        assertEquals(116718, burstBalloons.maxCoins(nums));
    }

}