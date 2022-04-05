package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthFactorOfNTest {
    private final KthFactorOfN kthFactorOfN = new KthFactorOfN();

    @Test
    void testOne() {
        assertEquals(3, kthFactorOfN.kthFactor(12, 3));
    }

    @Test
    void testTwo() {
        assertEquals(7, kthFactorOfN.kthFactor(7, 2));
    }

    @Test
    void testThree() {
        assertEquals(-1, kthFactorOfN.kthFactor(4, 4));
    }

}