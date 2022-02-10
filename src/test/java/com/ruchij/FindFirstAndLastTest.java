package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindFirstAndLastTest {
    private final FindFirstAndLast findFirstAndLast = new FindFirstAndLast();

    @Test
    void findFirst() {
        Assertions.assertEquals(2, findFirstAndLast.findFirst(new int[] {1, 2, 3, 4, 5}, 3));
        Assertions.assertEquals(-1, findFirstAndLast.findFirst(new int[] {1, 2, 3, 4, 5}, 6));
        Assertions.assertEquals(1, findFirstAndLast.findFirst(new int[] {1, 3, 3, 4, 5}, 3));
        Assertions.assertEquals(0, findFirstAndLast.findFirst(new int[] {3, 3, 3, 4, 5}, 3));
        Assertions.assertEquals(4, findFirstAndLast.findFirst(new int[] {3, 3, 3, 4, 5}, 5));
        Assertions.assertEquals(-1, findFirstAndLast.findFirst(new int[] {1, 3, 3, 4, 5}, 2));
    }

    @Test
    void findLast() {
        Assertions.assertEquals(2, findFirstAndLast.findLast(new int[] {1, 2, 3, 4, 5}, 3));
        Assertions.assertEquals(-1, findFirstAndLast.findLast(new int[] {1, 2, 3, 4, 5}, 6));
        Assertions.assertEquals(2, findFirstAndLast.findLast(new int[] {1, 3, 3, 4, 5}, 3));
        Assertions.assertEquals(2, findFirstAndLast.findLast(new int[] {3, 3, 3, 4, 5}, 3));
        Assertions.assertEquals(4, findFirstAndLast.findLast(new int[] {3, 3, 3, 3, 5}, 5));
        Assertions.assertEquals(-1, findFirstAndLast.findLast(new int[] {1, 3, 3, 4, 5}, 2));
    }
}