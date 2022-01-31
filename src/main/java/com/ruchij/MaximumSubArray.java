package com.ruchij;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        Integer previous = null;
        Integer max = null;

        for (int num : nums) {
            if (max == null) {
                max = num;
                previous = num;
            } else if (max < 0 && max < num) {
                max = num;
            } else if (num < 0) {
                if (max > previous) {
                    previous = max;
                }

                max += num;
            } else {
                max += num;
            }
        }

        return Math.max(previous, max);
    }
}
