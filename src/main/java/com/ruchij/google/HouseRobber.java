package com.ruchij.google;

public class HouseRobber {
    public int rob(int[] nums) {
        int[] maxValue = new int[nums.length];
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentHouse = nums[i];
            int earnings = 0;

            for (int j = 0; j < i - 1; j++) {
                earnings = Math.max(earnings, maxValue[j]);
            }

            maxValue[i] = earnings + currentHouse;
            max = Math.max(max, maxValue[i]);
        }

        return max;
    }
}
