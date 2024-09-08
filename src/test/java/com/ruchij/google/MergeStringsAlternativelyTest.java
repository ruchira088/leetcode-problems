package com.ruchij.google;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeStringsAlternativelyTest {
    private static final MergeStringsAlternatively solver = new MergeStringsAlternatively();

    @Test
    void verifyResults() {
        assertEquals("apbqcr", solver.mergeAlternately("abc", "pqr"));
        assertEquals("apbqrs", solver.mergeAlternately("ab", "pqrs"));
        assertEquals("apbqcd", solver.mergeAlternately("abcd", "pq"));
    }

}