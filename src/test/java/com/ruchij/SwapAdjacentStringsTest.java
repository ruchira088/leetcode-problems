package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SwapAdjacentStringsTest {
    private final SwapAdjacentStrings swapAdjacentStrings = new SwapAdjacentStrings();

    @Test
    void testOne() {
        Assertions.assertTrue(swapAdjacentStrings.canTransform("RXXLRXRXL", "XRLXXRRLX"));
    }

    @Test
    void testTwo() {
        Assertions.assertFalse(swapAdjacentStrings.canTransform("X", "L"));
    }

}