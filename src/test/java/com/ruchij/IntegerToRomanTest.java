package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntegerToRomanTest {
    private final IntegerToRoman integerToRoman = new IntegerToRoman();

    @Test
    void testOne() {
        Assertions.assertEquals("MCMXCIV", integerToRoman.intToRoman(1994));
    }

}