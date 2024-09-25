package com.ruchij.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestNumberTest {
    private static final LargestNumber largestNumber = new LargestNumber();

    @Test
    void verifyResult() {
        assertEquals("9534330", largestNumber.largestNumber(new int[]{3,30,34,5,9}));
        assertEquals("1113111311", largestNumber.largestNumber(new int[]{111311,1113}));
        assertEquals("210", largestNumber.largestNumber(new int[]{10, 2}));
        assertEquals("30302", largestNumber.largestNumber(new int[]{302, 30}));

    }

}