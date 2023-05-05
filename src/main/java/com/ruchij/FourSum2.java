package com.ruchij;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> result = new HashSet<>();

        int length = nums.length;
        int[] numbers = new int[length];
        System.arraycopy(nums, 0, numbers, 0, length);

        Arrays.sort(numbers);
        int a = 0;
        int b = 1;
        int c = length - 2;
        int d = length - 1;

        boolean innerLeft = true;
        boolean innerRight = true;

        while (b < c) {
            int valueA = numbers[a];
            int valueB = numbers[b];
            int valueC = numbers[c];
            int valueD = numbers[d];

            int sum = valueA + valueB + valueC + valueD;

            if (sum == target) {
                result.add(List.of(valueA, valueB, valueC, valueD));
                if (innerLeft) {
                    b++;
                    innerLeft = false;
                } else {
                    a++;
                    innerLeft = true;
                }
            } else if (sum < target) {
                if (innerLeft) {
                    b++;
                    innerLeft = false;
                } else {
                    a++;
                    innerLeft = true;
                }
            } else {
                if (innerRight) {
                    c--;
                    innerRight = false;
                } else {
                    d--;
                    innerRight = true;
                }
            }
        }

        return new ArrayList<>(result);
    }

}
