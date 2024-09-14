package com.ruchij.google;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaximumGoodSubarraySumTest {
    private static final MaximumGoodSubarraySum solution = new MaximumGoodSubarraySum();

    @Test
    void verifyResult() {
//        assertEquals(11, solution.maximumSubarraySum(new int[] {1,2,3,4,5,6}, 1));
        assertEquals(11, solution.maximumSubarraySum(new int[] {-1,3,2,4,5}, 3));
//        assertEquals(-6, solution.maximumSubarraySum(new int[] {-1,-2,-3,-4}, 2));
//        assertEquals(0, solution.maximumSubarraySum(new int[] {1, 5}, 2));
    }

    @Test
    void arrays() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7);
        Integer[] array = integers.toArray(new Integer[0]);
        System.out.println(Arrays.deepToString(array));
    }

}