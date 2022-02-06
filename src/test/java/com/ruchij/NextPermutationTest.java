package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NextPermutationTest {
    private final NextPermutation nextPermutation = new NextPermutation();

    @Test
    void testOne() {
        int[] input = {1,3,2};
        nextPermutation.nextPermutation(input);
        Assertions.assertArrayEquals(new int[]{2, 1, 3}, input);
    }

}