package com.ruchij.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeIITest {
    private static final CoinChangeII coinChangeIITest = new CoinChangeII();

    @Test
    void verifyResults() {
        assertEquals(2, coinChangeIITest.change(3, new int[]{1, 2}));
        assertEquals(4, coinChangeIITest.change(5, new int[]{1, 2, 5}));
        assertEquals(0, coinChangeIITest.change(3, new int[]{2}));
        assertEquals(1, coinChangeIITest.change(10, new int[]{10}));
    }

    @Test
    void verifyBigResults() {
        coinChangeIITest.change(500, new int[]{1, 2, 5});
        coinChangeIITest.change(500, new int[]{3,5,7,8,9,10,11});
    }

}