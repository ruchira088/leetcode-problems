package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCompressionTest {
    private final StringCompression stringCompression = new StringCompression();

    @Test
    void testOne() {
        char[] input = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        assertEquals(6, stringCompression.compress(input));
    }

    @Test
    void testTwo() {
        char[] input = {'a'};
        assertEquals(1, stringCompression.compress(input));
    }

    @Test
    void testThree() {
        char[] input = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        assertEquals(4, stringCompression.compress(input));
    }

}