package com.ruchij;

public class SearchIndex {
    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length - 1);
    }

    private int searchInsert(int[] nums, int target, int start, int end) {
        if (start > end) {
            return start;
        }

        int midPoint = (start + end) / 2;
        int midValue = nums[midPoint];

        if (target == midValue) {
            return midPoint;
        } else if (target < midValue) {
            return searchInsert(nums, target, start, midPoint - 1);
        } else {
            return searchInsert(nums, target, midPoint + 1, end);
        }
    }
}
