package com.ruchij.google;

public class LongestIncreasingSubSequence {
    public int lengthOfLIS(int[] nums) {
        int[] longest = new int[nums.length];
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int currentMax = 0;

            for (int j = 0; j < i; j++) {
                int current = nums[j];

                if (current < value) {
                    currentMax = Math.max(currentMax, longest[j]);
                }
            }

            longest[i] = currentMax + 1;
            max = Math.max(max, longest[i]);
        }

        return max;
    }
}
