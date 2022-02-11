package com.ruchij;

import org.junit.jupiter.api.Test;

class PermutationsTest {
    private final Permutations permutations = new Permutations();

    @Test
    void testOne() {
        System.out.println(permutations.permute(new int[]{1, 2, 3}));
    }

}