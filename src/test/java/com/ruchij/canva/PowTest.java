package com.ruchij.canva;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowTest {
    private final Pow pow = new Pow();

    @Test
    void returnsExpectedResult() {
        Assertions.assertEquals(1024, pow.myPow(2, 10));
        Assertions.assertEquals(9.261, pow.myPow(2.1000, 3));
        Assertions.assertEquals(0.25, pow.myPow(2, -2));
        Assertions.assertEquals(700.28148, pow.myPow(8.88023, 3));
        Assertions.assertEquals(5643.35434, pow.myPow(8.66731, 4));
        Assertions.assertEquals(0, pow.myPow(0.00001, 2147483647));
        Assertions.assertEquals(0, pow.myPow(2, -2147483648));
    }

}