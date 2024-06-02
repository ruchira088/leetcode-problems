package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombinationsTest {
    private static final Combinations combinations = new Combinations();

    @Test
    void shouldReturnCorrectCombinations() {
        assertEquals(6, combinations.combine(4, 2).size());
        assertEquals(1, combinations.combine(1, 1).size());
    }

}