package com.ruchij;

public class FindFirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[] {first, last};
    }

    int findFirst(int[] nums, int target) {
        return find(nums, target, 0, nums.length - 1, false);
    }

    int findLast(int[] nums, int target) {
        return find(nums, target, 0, nums.length - 1, true);
    }

    private int find(int[] nums, int target, int start, int end, boolean isLast) {
        if (start > end) {
            return -1;
        }

        int midPoint = (start + end + (isLast ? 1 : 0)) / 2;
        int value = nums[midPoint];

        if (value > target) {
            return find(nums, target, start, midPoint - 1, isLast);
        } else if (value < target) {
            return find(nums, target, midPoint + 1, end, isLast);
        } else if (start == end) {
            return start;
        } else if (!isLast) {
            return find(nums, target, start, midPoint, false);
        } else {
            return find(nums, target, midPoint, end, true);
        }
    }
}
