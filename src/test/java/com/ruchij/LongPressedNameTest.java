package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongPressedNameTest {
    private final LongPressedName longPressedName = new LongPressedName();

    @Test
    void testOne() {
        assertTrue(longPressedName.isLongPressedName("alex", "aaleex"));
    }

    @Test
    void testTwo() {
        assertFalse(longPressedName.isLongPressedName("saeed", "ssaaedd"));
    }

    @Test
    void testThree() {
        assertTrue(longPressedName.isLongPressedName("vtkgn", "vttkgnn"));
    }

    @Test
    void testFour() {
        assertFalse(longPressedName.isLongPressedName("a", "b"));
    }

    @Test
    void testFive() {
        assertFalse(longPressedName.isLongPressedName("alexd", "alex"));
    }

    @Test
    void testSix() {
        assertFalse(longPressedName.isLongPressedName("alex", "alexxr"));
    }

}