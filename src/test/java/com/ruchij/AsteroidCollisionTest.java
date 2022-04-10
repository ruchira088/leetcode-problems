package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsteroidCollisionTest {
    private final AsteroidCollision asteroidCollision = new AsteroidCollision();

    @Test
    void testOne() {
        int[] input = {5, 10, -5};
        assertArrayEquals(new int[]{5, 10}, asteroidCollision.asteroidCollision(input));
    }

    @Test
    void testTwo() {
        int[] input = {10, 2, -5};
        assertArrayEquals(new int[]{10}, asteroidCollision.asteroidCollision(input));
    }

    @Test
    void testThree() {
        int[] input = {8, -8};
        assertArrayEquals(new int[]{}, asteroidCollision.asteroidCollision(input));
    }

    @Test
    void testFour() {
        int[] input = {-2, -1, 1, 2};
        assertArrayEquals(new int[]{-2, -1, 1, 2}, asteroidCollision.asteroidCollision(input));
    }

}