package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewAreaPaintedTest {
    private final NewAreaPainted newAreaPainted = new NewAreaPainted();

    @Test
    void testOne() {
        int[][] paint = {{1, 4}, {4, 7}, {5, 8}};
        assertArrayEquals(new int[]{3, 3, 1}, newAreaPainted.amountPainted(paint));
    }

}