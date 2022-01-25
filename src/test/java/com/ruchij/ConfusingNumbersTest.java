package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConfusingNumbersTest {
    private final ConfusingNumbers confusingNumbers = new ConfusingNumbers();

    @Test
    void testOne() {
        Assertions.assertEquals(6, confusingNumbers.confusingNumberII(20));
        Assertions.assertEquals(19, confusingNumbers.confusingNumberII(100));

        int[] numbers = {1};

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

}