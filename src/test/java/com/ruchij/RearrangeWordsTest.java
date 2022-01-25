package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RearrangeWordsTest {
    private final RearrangeWords rearrangeWords = new RearrangeWords();

    @Test
    void testOne() {
        Assertions.assertEquals("this   is   a   sentence", rearrangeWords.reorderSpaces("  this   is  a sentence "));
        Assertions.assertEquals("practice   makes   perfect ", rearrangeWords.reorderSpaces(" practice   makes   perfect"));
    }

}