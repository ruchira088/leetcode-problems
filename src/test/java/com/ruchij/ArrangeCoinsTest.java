package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrangeCoinsTest {

    @Test
    void returnsExpectedResult() {
        ArrangeCoins arrangeCoins = new ArrangeCoins();
        assertEquals(2, arrangeCoins.arrangeCoins(5));
        assertEquals(3, arrangeCoins.arrangeCoins(8));
    }

}