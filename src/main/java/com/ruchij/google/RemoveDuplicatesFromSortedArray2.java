package com.ruchij.google;

public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int value = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];

            if (value == current) {
                if (count < 2) {
                    count++;
                    nums[index] = current;
                    index++;
                }
            } else {
                value = current;
                count = 1;
                nums[index] = current;
                index++;
            }
        }

        return index;
    }
}
