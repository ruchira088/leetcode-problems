package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BricksFallingWhenHitTest {
    private final BricksFallingWhenHit bricksFallingWhenHit = new BricksFallingWhenHit();

    @Test
    void testOne() {
        int[][] grid = {{1, 0, 0, 0}, {1, 1, 1, 0}};
        int[][] hits = {{1, 0}};

        int[] expected = {2};

        Assertions.assertArrayEquals(expected, bricksFallingWhenHit.hitBricks(grid, hits));
    }

    @Test
    void testTwo() {
        int[][] grid = {{1, 0, 0, 0}, {1, 1, 0, 0}};
        int[][] hits = {{1, 1}, {1, 0}};

        int[] expected = {0, 0};

        Assertions.assertArrayEquals(expected, bricksFallingWhenHit.hitBricks(grid, hits));
    }

    @Test
    void testThree() {
        int[][] grid = {{1}, {1}, {1}, {1}, {1}};
        int[][] hits = {{3, 0}, {4, 0}, {1, 0}, {2, 0}, {0, 0}};

        int[] expected = {1, 0, 1, 0, 0};

        Assertions.assertArrayEquals(expected, bricksFallingWhenHit.hitBricks(grid, hits));
    }

}