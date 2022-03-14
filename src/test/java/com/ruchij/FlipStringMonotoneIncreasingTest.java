package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlipStringMonotoneIncreasingTest {
    private final FlipStringMonotoneIncreasing flipStringMonotoneIncreasing = new FlipStringMonotoneIncreasing();

    @Test
    void testOne() {
        assertEquals(1, flipStringMonotoneIncreasing.minFlipsMonoIncr("00110"));
        assertEquals(2, flipStringMonotoneIncreasing.minFlipsMonoIncr("010110"));
        assertEquals(10, flipStringMonotoneIncreasing.minFlipsMonoIncr("0110011010001010011100011"));
    }

}