package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayDoubledPairsTest {
    private final ArrayDoubledPairs arrayDoubledPairs = new ArrayDoubledPairs();

    @Test
    void testOne() {
        Assertions.assertTrue(arrayDoubledPairs.canReorderDoubled(new int[]{4, -2, 2, -4}));
    }

}