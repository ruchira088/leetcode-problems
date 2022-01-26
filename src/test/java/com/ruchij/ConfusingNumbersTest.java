package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConfusingNumbersTest {
    private final ConfusingNumbers confusingNumbers = new ConfusingNumbers();

    @Test
    void testOne() {
        Assertions.assertEquals(6, confusingNumbers.confusingNumberII(20));
        Assertions.assertEquals(19, confusingNumbers.confusingNumberII(100));

        System.out.println(confusingNumbers.confusingNumberII(100_000_000));
    }

}