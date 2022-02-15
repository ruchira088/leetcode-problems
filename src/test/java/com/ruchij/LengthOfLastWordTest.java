package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthOfLastWordTest {
    private final LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

    @Test
    void testOne() {
        assertEquals(5, lengthOfLastWord.lengthOfLastWord("Hello World"));
    }

    @Test
    void testTwo() {
        assertEquals(4, lengthOfLastWord.lengthOfLastWord("   fly me   to   the moon  "));
    }

    @Test
    void testThree() {
        assertEquals(6, lengthOfLastWord.lengthOfLastWord("luffy is still joyboy"));
    }

    @Test
    void testFour() {
        assertEquals(5, lengthOfLastWord.lengthOfLastWord("luffy"));
    }

}