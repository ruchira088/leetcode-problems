package com.ruchij.google;

public class LongestIncreasingSequence {
    public int lengthOfLIS(int[] nums) {
        int maxCount = 0;
        int[] max = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int value = nums[i];

            for (int j = 0; j < i; j++) {
                int previous = nums[j];

                if (previous < value) {
                    count = Math.max(count, max[j]);
                }
            }

            max[i] = count + 1;
            maxCount = Math.max(maxCount, max[i]);
        }

        return maxCount;
    }
}
