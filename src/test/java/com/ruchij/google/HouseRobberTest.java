package com.ruchij.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobberTest {
    private static final HouseRobber houseRobber = new HouseRobber();

    @Test
    void verifyResults() {
        assertEquals(4, houseRobber.rob(new int[]{1, 2, 3, 1}));
        assertEquals(12, houseRobber.rob(new int[]{2, 7, 9, 3, 1}));
        assertEquals(16, houseRobber.rob(new int[]{1, 7, 1, 1, 9}));
    }

}