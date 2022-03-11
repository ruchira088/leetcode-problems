package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumFlipsForZeroMatrixTest {
    private final MinimumFlipsForZeroMatrix minimumFlipsForZeroMatrix = new MinimumFlipsForZeroMatrix();

    @Test
    void testOne() {
        int[][] matrix = {{0, 0}, {0, 1}};
        System.out.println(minimumFlipsForZeroMatrix.minFlips(matrix));
    }

    @Test
    void testTwo() {
        int[][] matrix = {{1, 1, 1}, {1, 1, 1}, {0, 0, 0}};
        System.out.println(minimumFlipsForZeroMatrix.minFlips(matrix));
    }

}