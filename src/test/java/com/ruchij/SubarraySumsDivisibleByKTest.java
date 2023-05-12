package com.ruchij;

import com.ruchij.reader.InputDataReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubarraySumsDivisibleByKTest {
    @Test
    void returnsExpectedAnswer() throws FileNotFoundException {
        SubarraySumsDivisibleByK subarraySumsDivisibleByK = new SubarraySumsDivisibleByK();

        assertEquals(1, subarraySumsDivisibleByK.subarraysDivByK(new int[]{7, 4, -10}, 5));
        assertEquals(7, subarraySumsDivisibleByK.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
        assertEquals(0, subarraySumsDivisibleByK.subarraysDivByK(new int[]{5}, 9));

        int[] input = InputDataReader.read("SubarraysDivByK.txt")
                .flatMap(line -> {
                    String[] strings = line.split(",");

                    return Arrays.stream(strings);
                })
                .mapToInt(Integer::parseInt)
                .toArray();

        assertEquals(247783, subarraySumsDivisibleByK.subarraysDivByK(input, 1823));
        assertEquals(247783, subarraySumsDivisibleByK.subarraysDivByK(input, 1823));
        assertEquals(247783, subarraySumsDivisibleByK.subarraysDivByK(input, 1823));
        assertEquals(247783, subarraySumsDivisibleByK.subarraysDivByK(input, 1823));
    }
}