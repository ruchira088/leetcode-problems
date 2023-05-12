package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumNumberOfOccurrencesOfSubstringTest {

    @Test
    void returnsExpectedResult() {
        MaximumNumberOfOccurrencesOfSubstring maximumNumberOfOccurrencesOfSubstring = new MaximumNumberOfOccurrencesOfSubstring();
        assertEquals(2, maximumNumberOfOccurrencesOfSubstring.maxFreq("aababcaab", 2, 3, 4));
        assertEquals(2, maximumNumberOfOccurrencesOfSubstring.maxFreq("aaaa", 1, 3, 3));
    }

}