package com.ruchij;

public class SingleElementInSortedArray {
    // [1,1,2,3,3,4,4,8,8]
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        if (nums.length == 1) {
            return nums[0];
        }

        while (left <= right) {
            int midPoint = (left + right) / 2;
            int value = nums[midPoint];

            int otherIndex = midPoint % 2 == 0 ? midPoint + 1 : midPoint - 1;
            int otherValue = nums[otherIndex];

            if (value == otherValue) {
                if (left == midPoint) {
                    return nums[right];
                } else {
                    left = midPoint;
                }
            } else {
                if (right == midPoint) {
                    return nums[left];
                } else {
                    right = midPoint;
                }
            }
        }

        return -1;
    }
}
