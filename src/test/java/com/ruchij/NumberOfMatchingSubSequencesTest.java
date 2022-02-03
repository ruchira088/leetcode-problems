package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberOfMatchingSubSequencesTest {
    private final NumberOfMatchingSubSequences numberOfMatchingSubSequences = new NumberOfMatchingSubSequences();

    @Test
    void testOne() {
        Assertions.assertEquals(
                3,
                numberOfMatchingSubSequences.numMatchingSubseq("abcde", new String[]{"a","bb","acd","ace"})
        );
    }

}