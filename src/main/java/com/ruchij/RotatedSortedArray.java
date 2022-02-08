package com.ruchij;

public class RotatedSortedArray {
    public int search(int[] nums, int target) {
        return search(nums, -1, -1, target, 0, nums.length - 1, false, false);
    }

    private int search(int[] nums, int initialStart, int initialEnd, int target, int start, int end, boolean checkedStart, boolean checkedEnd) {
        checkedEnd = checkedEnd || start >= nums.length - 1;
        checkedStart = checkedStart || end <= 0;

        if (start <= end) {
            int midpoint = (start + end) / 2;
            int midValue = nums[midpoint];

            if (initialStart == -1) {
                initialStart = start;
            }

            if (initialEnd == -1) {
                initialEnd = end;
            }

            if (midValue == target) {
                return midpoint;
            } else if (midValue < nums[start]) {
                return search(nums, -1, -1, target, start, midpoint - 1, checkedStart, checkedEnd);
            }   else if (target < midValue) {
                return search(nums, initialStart, initialEnd, target, start, midpoint - 1, checkedStart, checkedEnd || start >= nums.length - 1);
            } else {
                return search(nums, initialStart, initialEnd, target, midpoint + 1, end, checkedStart, checkedEnd);
            }
        } else if (end <= initialStart && !checkedEnd) {
            return search(nums, -1, -1, target, (initialStart + initialEnd) / 2 + 1, nums.length - 1, checkedStart, checkedEnd);
        } else if (start >= initialEnd && !checkedStart) {
            return search(nums, -1, -1, target, 0, (initialStart + initialEnd) / 2 - 1, checkedStart, checkedEnd);
        } else {
            return -1;
        }
    }
}
