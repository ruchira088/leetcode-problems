package com.ruchij;

import org.junit.jupiter.api.Test;

class SpiralMatrixTest {
    private final SpiralMatrix spiralMatrix = new SpiralMatrix();

    @Test
    void testOne() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralMatrix.spiralOrder(matrix));
    }

    @Test
    void testTwo() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralMatrix.spiralOrder(matrix));
    }

}