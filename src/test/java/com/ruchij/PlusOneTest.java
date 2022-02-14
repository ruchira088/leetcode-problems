package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlusOneTest {
    private final PlusOne plusOne = new PlusOne();

    @Test
    void testOne() {
        int[] input = {};
        plusOne.plusOne(input);
    }

}