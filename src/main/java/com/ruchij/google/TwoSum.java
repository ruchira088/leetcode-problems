package com.ruchij.google;

import java.util.Arrays;
import java.util.Comparator;

public class TwoSum {
    record Entry(int index, int value) {}

    public int[] twoSum(int[] nums, int target) {
        Entry[] entries = new Entry[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            Entry entry = new Entry(i, number);
            entries[i] = entry;
        }

        Arrays.sort(entries, Comparator.comparing(entry -> entry.value));

        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex < rightIndex) {
            Entry leftValue = entries[leftIndex];
            Entry rightValue = entries[rightIndex];

            int total = leftValue.value + rightValue.value;

            if (total == target) {
                return new int[] {leftValue.index, rightValue.index};
            } else if (total < target) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return new int[] {};
    }

}
