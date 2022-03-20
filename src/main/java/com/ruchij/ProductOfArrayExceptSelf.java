package com.ruchij;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                left[0] = nums[0];
            } else {
                left[i] = left[i - 1] * nums[i];
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                right[i] = nums[i];
            } else {
                right[i] = nums[i] * right[i + 1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[0] = right[1];
            } else if (i == nums.length - 1) {
                result[i] = left[i - 1];
            } else {
                result[i] = left[i - 1] * right[i + 1];
            }
        }

        return result;
    }
}
