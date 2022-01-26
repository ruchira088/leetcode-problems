package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArraySwapTest {
    private final ArraySwap arraySwap = new ArraySwap();

    @Test
    void testOne() {
        int[] arrayOne = {0, 4, 4, 5, 9};
        int[] arrayTwo = {0, 1, 6, 8, 10};

        Assertions.assertEquals(1, arraySwap.minSwap(arrayOne, arrayTwo));
    }

    @Test
    void testTwo() {
        int[] arrayOne = {1, 3, 5, 4};
        int[] arrayTwo = {1, 2, 3, 7};

        Assertions.assertEquals(1, arraySwap.minSwap(arrayOne, arrayTwo));
    }

    @Test
    void testThree() {
        int[] arrayOne = {0, 3, 4, 9, 10};
        int[] arrayTwo = {2, 3, 7, 5, 6};

        Assertions.assertEquals(1, arraySwap.minSwap(arrayOne, arrayTwo));
    }
}
