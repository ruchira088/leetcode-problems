package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DivideTwoIntegersTest {
    private final DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();

    @Test
    void testOne() {
        Assertions.assertEquals(2147483647, divideTwoIntegers.divide(-2147483648, -1));
    }

    @Test
    void testTwo() {
        Assertions.assertEquals(-1073741824, divideTwoIntegers.divide(-2147483648, 2));
    }

    @Test
    void testThree() {
        Assertions.assertEquals(-2147483648, divideTwoIntegers.divide(-2147483648, 1));
    }

    @Test
    void testFour() {
        Assertions.assertEquals(12, divideTwoIntegers.divide(-1021989372, -82778243));
    }

}