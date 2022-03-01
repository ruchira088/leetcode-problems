package com.ruchij;

import java.util.Arrays;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        int index = nums.length - k;

        return nums[index];
    }
}
