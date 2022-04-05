package com.ruchij;

public class SumOfSubArrays {
    public long subArrayRanges(int[] nums) {
        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int max = nums[i];

            for (int j = i; j < nums.length; j++) {
                min = Math.min(nums[j], min);
                max = Math.max(nums[j], max);

                sum += (max - min);
            }
        }

        return sum;
    }
}
