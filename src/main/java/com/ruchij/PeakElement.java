package com.ruchij;

public class PeakElement {
    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length - 1);
    }

    public int findPeakElement(int[] nums, int start, int end) {
        int midPoint = (start + end) / 2;
        int midValue = nums[midPoint];

        int leftValue = midPoint == 0 ? Integer.MIN_VALUE : nums[midPoint - 1];

        if (leftValue > midValue) {
            return findPeakElement(nums, start, midPoint - 1);
        }

        int rightValue = midValue + 1 == nums.length ? Integer.MIN_VALUE : nums[midPoint + 1];

        if (rightValue > midValue) {
            return findPeakElement(nums, midPoint + 1, end);
        }

        return midPoint;
    }
}
