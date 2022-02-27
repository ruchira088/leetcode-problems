package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecodeStringTest {
    private final DecodeString decodeString = new DecodeString();

    @Test
    void testOne() {
        assertEquals("aaabcbc", decodeString.decodeString("3[a]2[bc]"));
    }

    @Test
    void testTwo() {
        assertEquals("accaccacc", decodeString.decodeString("3[a2[c]]"));
    }

    @Test
    void testThree() {
        assertEquals("abcabccdcdcdef", decodeString.decodeString("2[abc]3[cd]ef"));
    }

}