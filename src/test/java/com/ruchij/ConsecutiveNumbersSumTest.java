package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsecutiveNumbersSumTest {
    private final ConsecutiveNumbersSum consecutiveNumbersSum = new ConsecutiveNumbersSum();

    @Test
    void testOne() {
        assertEquals(2, consecutiveNumbersSum.consecutiveNumbersSum(5));
        assertEquals(4, consecutiveNumbersSum.consecutiveNumbersSum(15));
        assertEquals(1, consecutiveNumbersSum.consecutiveNumbersSum(1));
    }

}