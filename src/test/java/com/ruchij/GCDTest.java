package com.ruchij;

import org.junit.jupiter.api.Test;

class GCDTest {
    private final GCD gcd = new GCD();

    @Test
    void testOne() {
        System.out.println(gcd.run(357,234));
    }
}