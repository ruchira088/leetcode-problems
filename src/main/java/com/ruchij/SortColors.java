package com.ruchij;

import java.util.Arrays;
import java.util.LinkedList;

public class SortColors {
    public void sortColors(int[] nums) {
        sortColors(nums, 0, nums.length - 1);
    }

    void sortColors(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            sortColors(nums, start, mid);
            sortColors(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    void merge(int[] nums, int start, int mid, int end) {
        int leftIndex = start;
        int rightIndex = mid + 1;

        LinkedList<Integer> leftValues = new LinkedList<>();

        int index = start;

        while (index <= end && leftIndex <= mid) {
            int left = leftValues.isEmpty() ? nums[leftIndex] : leftValues.peekFirst();
            int right = rightIndex > end ? left : nums[rightIndex];
            int num = nums[index];

            if (left > right) {
                if (index <= mid) {
                    leftValues.addLast(num);
                }

                nums[index] = right;
                rightIndex++;
            } else {
                if (!leftValues.isEmpty()) {
                    leftValues.removeFirst();

                    if (index <= mid) {
                        leftValues.addLast(num);
                    }
                }

                nums[index] = left;
                leftIndex++;
            }

            index++;
        }

        if (!leftValues.isEmpty()) {
            throw new AssertionError("Left values should be empty: %s".formatted(leftValues));
        }

    }
}
