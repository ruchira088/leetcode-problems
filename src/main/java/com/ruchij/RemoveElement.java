package com.ruchij;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int diff = 0;

        for (int i=0; i < nums.length; i++) {
            if (nums[i] == val) {
                diff++;
            } else {
                nums[i - diff] = nums[i];
            }
        }

        return nums.length - diff;
    }
}
