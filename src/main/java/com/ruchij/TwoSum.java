package com.ruchij;

import java.util.Arrays;
import java.util.Comparator;

public class TwoSum {
    private record Tuple(int index, int value) {}

    private Tuple[] convert(int[] nums) {
        Tuple[] tuples = new Tuple[nums.length];

        for (int i = 0; i < nums.length; i++) {
            tuples[i] = new Tuple(i, nums[i]);
        }

        return tuples;
    }

    public int[] twoSum(int[] nums, int target) {
        Tuple[] tuples = convert(nums);
        Arrays.sort(tuples, Comparator.comparing(Tuple::value));

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            Tuple lower = tuples[start];
            Tuple higher = tuples[end];

            int sum = lower.value + higher.value;

            if (sum == target) {
                int [] result = new int[2];
                result[0] = lower.index;
                result[1] = higher.index;

                return result;
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }

        }

        return null;
    }
}
