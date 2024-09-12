package com.ruchij.google;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int previous = -101;
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];

            if (previous != current) {
                previous = current;
                nums[index] = current;
                index++;
            }
        }

        return index;
    }
}
