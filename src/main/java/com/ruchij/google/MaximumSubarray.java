package com.ruchij.google;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = max;

        for (int i = 1; i < nums.length; i++) {
            int number = nums[i];

            if (sum < 0) {
                sum = 0;
            }

            sum += number;
            max = Math.max(max, sum);
        }

        return max;
    }
}
