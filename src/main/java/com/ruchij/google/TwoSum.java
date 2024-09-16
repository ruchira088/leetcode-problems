package com.ruchij.google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int other = target - num;
            Integer otherIndex = hashMap.get(other);

            if (otherIndex != null && otherIndex != i) {
                return new int[] { otherIndex, i };
            }
        }

        return new int[] {};
    }

    public int[] twoSum2(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex < rightIndex) {
            int leftValue = nums[leftIndex];
            int rightValue = nums[rightIndex];

            int total = leftValue + rightValue;

            if (total == target) {
                return new int[] {leftIndex + 1, rightIndex + 1};
            } else if (total < target) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return new int[] {};
    }

}
