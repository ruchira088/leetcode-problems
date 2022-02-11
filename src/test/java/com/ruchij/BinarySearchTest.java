package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTest {
    private final BinarySearch binarySearch = new BinarySearch();

    @Test
    void testOne() {
        Assertions.assertEquals(4, binarySearch.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    @Test
    void testTwo() {
        Assertions.assertEquals(-1, binarySearch.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }

}