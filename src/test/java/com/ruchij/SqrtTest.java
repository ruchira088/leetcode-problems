package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqrtTest {
    private static final Sqrt sqrt = new Sqrt();

    @Test
    void testSqrt() {
        assertEquals(46340, sqrt.mySqrt(2147395600));
    }

}