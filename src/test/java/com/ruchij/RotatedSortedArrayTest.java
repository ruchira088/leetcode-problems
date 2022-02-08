package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RotatedSortedArrayTest {
    private final RotatedSortedArray rotatedSortedArray = new RotatedSortedArray();

    @Test
    void testOne() {
        int result = rotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        Assertions.assertEquals(4, result);
    }

    @Test
    void testTwo() {
        int result = rotatedSortedArray.search(new int[]{4, 5, 6, 7, 8, 0}, 0);
        Assertions.assertEquals(5, result);
    }

    @Test
    void testThree() {
        int result = rotatedSortedArray.search(new int[]{4, 5, 6, 7, 8, 0}, 1);
        Assertions.assertEquals(-1, result);
    }

    @Test
    void testFour() {
        int result = rotatedSortedArray.search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8);
        Assertions.assertEquals(4, result);
    }

}