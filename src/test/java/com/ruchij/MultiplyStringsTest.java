package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyStringsTest {

    @Test
    void returnsExpectedResult() {
        MultiplyStrings multiplyStrings = new MultiplyStrings();

        assertEquals("625", multiplyStrings.multiply("25", "25"));
        assertEquals("56088", multiplyStrings.multiply("123", "456"));
        assertEquals("891", multiplyStrings.multiply("9", "99"));
        assertEquals("0", multiplyStrings.multiply("0", "0000"));
    }

}