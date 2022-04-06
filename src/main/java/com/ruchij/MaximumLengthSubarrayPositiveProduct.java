package com.ruchij;

public class MaximumLengthSubarrayPositiveProduct {
    public int getMaxLen(int[] nums) {
        int max = 0;
        int current = 0;
        boolean value = true;
        int first = 0;
        int last = 0;
        boolean lead = true;

        while (first <= last) {
            if (value) {
                max = Math.max(current, max);
            }

            if (lead && last < nums.length) {
                int num = nums[last];
                last++;

                if (num > 0) {
                    current++;
                } else if (num < 0) {
                    current++;
                    value = !value;
                } else {
                    if (value) {
                        max = Math.max(current, max);
                    }
                    lead = false;
                }
            } else if (first < nums.length) {
                int num = nums[first];
                first++;

                if (num > 0) {
                    current--;
                } else if (num < 0) {
                    current--;
                    value = !value;
                } else {
                    if (value) {
                        max = Math.max(current, max);
                    }
                    lead = true;
                    current = 0;
                }
            } else {
                break;
            }
        }

        return max;
    }
}
