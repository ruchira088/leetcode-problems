package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateImageTest {
    private final RotateImage rotateImage = new RotateImage();

    @Test
    void testOne() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotateImage.print(matrix);

        System.out.println("\n");

        rotateImage.rotate(matrix);
        rotateImage.print(matrix);
    }

}