package com.ruchij;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FourSum {
    record Tuple<A, B>(A first, B second) {}

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<Map<Integer, List<Integer>>> output = new HashSet<>();
        Arrays.sort(nums);

        for (int i  = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    int diff = target - (nums[i] + nums[j]);
                    Set<Integer> noMatch = new HashSet<>(Set.of(i, j));
                    Tuple<Integer, Integer> result = find(nums, diff, noMatch);

                    while (result != null) {
                        Map<Integer, List<Integer>> map = Stream.of(nums[i], nums[j], nums[result.first], nums[result.second])
                                .collect(Collectors.groupingBy(x -> x));

                        output.add(map);

                        noMatch.add(result.first);
                        noMatch.add(result.second);

                        result = find(nums, diff, noMatch);
                    }
                }
            }
        }

        return output.stream().map(count -> count.values().stream().flatMap(Collection::stream).collect(Collectors.toList())).collect(Collectors.toList());
    }

    private Tuple<Integer, Integer> find(int[] nums, int target, Set<Integer> noMatch) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (noMatch.contains(left)) {
                left++;
            } else if (noMatch.contains(right)) {
                right--;
            }
            else {
                int total = nums[left] + nums[right];

                if (total == target) {
                    return new Tuple<>(left, right);
                } else if (total > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return null;
    }
}
