package com.ruchij.canva;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddBinaryTest {
    private final AddBinary addBinary = new AddBinary();

    @Test
    void returnsExpectedResult() {
        assertEquals("100", addBinary.addBinary("11", "1"));
        assertEquals("10101", addBinary.addBinary("1010", "1011"));
    }

}