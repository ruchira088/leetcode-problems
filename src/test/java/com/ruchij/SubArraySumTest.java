package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SubArraySumTest {
    private final SubArraySum subArraySum = new SubArraySum();

    @Test
    void testOne() {
        int[] input = {2, 1, 3};
        int result = subArraySum.subarraySum(input, 3);

        Assertions.assertEquals(2, result);
    }

    @Test
    void testTwo() {
        int[] input = {1, 1, 1};
        int result = subArraySum.subarraySum(input, 2);

        Assertions.assertEquals(2, result);
    }

    @Test
    void testThree() {
        int[] input = {1};
        int result = subArraySum.subarraySum(input, 0);

        Assertions.assertEquals(0, result);
    }

    @Test
    void testFour() {
        int[] input = {-1, -1, 1};
        int result = subArraySum.subarraySum(input, 0);

        Assertions.assertEquals(1, result);
    }

    @Test
    void testFive() {
        int[] input = {-1, -1, 1};
        int result = subArraySum.subarraySum(input, 1);

        Assertions.assertEquals(1, result);
    }


}