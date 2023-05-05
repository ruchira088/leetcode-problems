package com.ruchij;

import java.util.*;

public class ThreeSumTwo {
    public List<List<Integer>> threeSum(int[] input) {
        Set<List<Integer>> results = new HashSet<>();
        Arrays.sort(input);

        for (int index = 0; index < input.length; index++) {
            int offset = input[index];

            int left = 0;
            int right = input.length - 1;

            while (left < right) {
                if (left == index) {
                    left++;
                }

                if (right == index) {
                    right--;
                }

                if (left < right) {
                    int sum = input[left] + input[right] + offset;

                    if (sum == 0) {
                        ArrayList<Integer> integers = new ArrayList<>(List.of(input[left], input[right], offset));
                        integers.sort(Comparator.naturalOrder());

                        results.add(integers);
                        left++;
                    } else if (sum > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return new ArrayList<>(results);
    }
}
