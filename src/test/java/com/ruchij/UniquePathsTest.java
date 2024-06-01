package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniquePathsTest {
    private static final UniquePaths uniquePaths = new UniquePaths();

    @Test
    void shouldReturnUniquePaths() {
        assertEquals(28, uniquePaths.uniquePaths(3, 7));
        for (int x = 2; x < 15; x++) {
            for (int y = 2; y < 15; y++) {
                System.out.println("x=%s, y=%s, area=%s, paths=%s".formatted(x, y, x * y, uniquePaths.uniquePaths(x, y)));
            }
        }
    }

}