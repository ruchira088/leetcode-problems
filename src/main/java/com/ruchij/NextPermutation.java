package com.ruchij;

import java.util.*;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        Map<Integer, Integer> digits = new HashMap<>();
        int index = -1;
        Integer value = null;

        for (int i = nums.length - 1; i >= 0; i--) {
            int current = nums[i];

            Optional<Integer> integer = digits.keySet().stream().sorted().filter(digit -> digit > current).findAny();

            if (integer.isPresent()) {
                index = i;
                value = integer.get();
                break;
            } else {
                digits.put(current, i);
            }
        }

        if (value == null) {
            int start = 0;
            int end = nums.length - 1;

            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }

        } else {
            int temp = nums[index];
            nums[index] = value;
            nums[digits.get(value)] = temp;
            Arrays.sort(nums, index + 1, nums.length);
        }
    }
}
