package com.ruchij;

import java.util.Arrays;

public class ThreeSumCloset {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        Integer sum = null;

        for (int i = 0; i < nums.length; i++) {
            int[] result = findIndex(nums, target - nums[i], i);
            int total = nums[i] + nums[result[0]] + nums[result[1]];

            if (sum == null || Math.abs(target - total) < Math.abs(target - sum)) {
                sum = total;
            }
        }

        return sum;
    }

    private int[] findIndex(int[] nums, int target, int no) {
        Integer sum = null;
        int[] index = new int[2];
        Arrays.fill(index, Integer.MAX_VALUE);
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (left != no) {
                if (right != no) {
                    int current = nums[left] + nums[right];

                    if (sum == null || Math.abs(target - sum) > Math.abs(target - current)) {
                        sum = current;
                        index[0] = left;
                        index[1] = right;
                    }

                    if (current > target) {
                        right--;
                    } else {
                        left++;
                    }

                } else {
                    right--;
                }
            } else {
                left++;
            }
        }


        return index;
    }
}
