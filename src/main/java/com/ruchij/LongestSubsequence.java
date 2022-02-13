package com.ruchij;

public class LongestSubsequence {
    public int lengthOfLIS(int[] nums) {
        int result = 0;
        int[] longest = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int current = nums[i];
            int max = 0;

            for (int j = i + 1; j < nums.length; j++) {
                int next = nums[j];
                int nextLongest = longest[j];

                if (next > current && nextLongest > max) {
                    max = nextLongest;
                }
            }

            max++;
            longest[i] = max;

            if (result < max) {
                result = max;
            }
        }

        return result;
    }
}
