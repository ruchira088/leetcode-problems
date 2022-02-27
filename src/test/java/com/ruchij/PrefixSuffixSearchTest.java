package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrefixSuffixSearchTest {
    @Test
    void testOne() {
        String[] input = { "apple", "appple" };
        PrefixSuffixSearch.WordFilter wordFilter = new PrefixSuffixSearch.WordFilter(input);

        int result = wordFilter.f("ap", "le");
        assertEquals(1, result);
    }

}