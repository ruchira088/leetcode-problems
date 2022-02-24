package com.ruchij;

import com.ruchij.reader.InputDataReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestArithmeticSubsequenceTest {
    private final LongestArithmeticSubsequence longestArithmeticSubsequence = new LongestArithmeticSubsequence();

    @Test
    void testOne() {
        assertEquals(4, longestArithmeticSubsequence.longestSubsequence(new int[]{1, 2, 3, 4}, 1));
    }

    @Test
    void testTwo() throws FileNotFoundException {
        int[] input = InputDataReader.read("LongestArithmeticSubsequenceData.txt")
                .flatMap(line -> Arrays.stream(line.split(",")))
                .mapToInt(Integer::valueOf)
                .toArray();

        assertEquals(11, longestArithmeticSubsequence.longestSubsequence(input, -1960));
    }

    @Test
    void testThree() {
        assertEquals(4, longestArithmeticSubsequence.longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
    }

}