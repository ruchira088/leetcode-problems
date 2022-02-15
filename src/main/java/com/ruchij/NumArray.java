package com.ruchij;

public class NumArray {
    private final int[] nums;
    private final int[] sums;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.sums = new int[nums.length];
        updateSums(0);
    }

    private void updateSums(int start) {
        for (int i = start; i < nums.length; i++) {
            if (i == 0) {
                sums[0] = nums[0];
            } else {
                sums[i] = sums[i - 1] + nums[i];
            }
        }
    }

    public void update(int index, int val) {
        this.nums[index] = val;
        updateSums(index);
    }

    public int sumRange(int left, int right) {
        return sums[right] - sums[left] + nums[left];
    }
}
