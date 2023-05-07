package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReverseIntegerTest {

    @Test
    void verifyResult() {
        ReverseInteger reverseInteger = new ReverseInteger();

        Assertions.assertEquals(321, reverseInteger.reverse(123));
        Assertions.assertEquals(-321, reverseInteger.reverse(-123));
        Assertions.assertEquals(21, reverseInteger.reverse(120));
    }
}