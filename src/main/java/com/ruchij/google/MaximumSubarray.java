package com.ruchij.google;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int number = nums[i];
            max = Math.max(max, sum);

            if (sum + number < 0) {
                sum = number;
            } else {
                if (sum < 0) {
                    sum = 0;
                }

                sum += number;
            }
        }

        return Math.max(max, sum);
    }
}
