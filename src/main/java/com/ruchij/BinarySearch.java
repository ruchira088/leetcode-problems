package com.ruchij;

public class BinarySearch {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        } else {
            int midPoint = (start + end) / 2;
            int midValue = nums[midPoint];

            if (target == midValue) {
                return midPoint;
            } else if (target > midValue) {
                return search(nums, target, midPoint + 1, end);
            } else {
                return search(nums, target, start, midPoint - 1);
            }
        }
    }
}
