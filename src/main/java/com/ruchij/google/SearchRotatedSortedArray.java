package com.ruchij.google;

import java.util.function.Function;

public class SearchRotatedSortedArray {
    public boolean search(int[] nums, int target) {
        int size = nums.length;
        int pivot = findStart(nums);
        int left = 0;
        int right = nums.length - 1;

        Function<Integer, Integer> getIndex = convert(pivot, size);

        while (left <= right) {
            int midPoint = (left + right)/2;
            int midPointValue = nums[getIndex.apply(midPoint)];

            if (midPointValue == target) {
                return true;
            } else if (midPointValue > target) {
                right = midPoint - 1;
            } else {
                left = midPoint + 1;
            }
        }

        return false;
    }

    Function<Integer, Integer> convert(int pivot, int size) {
        return index -> (index + pivot) % size;
    }

    public int findStart(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
          int midPoint = (left + right)/2;
          int midPointValue = nums[midPoint];

          int leftValue = nums[left];
          int rightValue = nums[right];

          if (leftValue > midPointValue) {
              right = midPoint;
          } else if (rightValue < midPointValue) {
              left = midPoint + 1;
          } else if (leftValue == rightValue){
              right -= 1;
              left += 1;
          } else if (right + 1 < nums.length && rightValue > nums[right + 1]){
              right += 1;
          } else {
              right -= 1;
          }
        }

        return right;
    }
}
