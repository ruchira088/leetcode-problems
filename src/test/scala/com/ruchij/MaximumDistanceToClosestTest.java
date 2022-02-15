package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumDistanceToClosestTest {
    private final MaximumDistanceToClosest maximumDistanceToClosest = new MaximumDistanceToClosest();

    @Test
    void testOne() {
        int result = maximumDistanceToClosest.maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1});
        assertEquals(2, result);
    }

    @Test
    void testTwo() {
        int result = maximumDistanceToClosest.maxDistToClosest(new int[]{1, 0, 0, 0});
        assertEquals(3, result);
    }

    @Test
    void testThree() {
        int result = maximumDistanceToClosest.maxDistToClosest(new int[]{0, 0, 1});
        assertEquals(2, result);
    }

    @Test
    void testFour() {
        int result = maximumDistanceToClosest.maxDistToClosest(new int[]{1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0});
        assertEquals(5, result);
    }

    @Test
    void testFive() {
        int result = maximumDistanceToClosest.maxDistToClosest(new int[]{0, 0, 0, 0, 1, 0, 1, 0, 0});
        assertEquals(4, result);
    }

    @Test
    void testSix() {
        int result = maximumDistanceToClosest.maxDistToClosest(new int[]{0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1});
        assertEquals(3, result);
    }

}