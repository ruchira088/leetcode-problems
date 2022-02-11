package com.ruchij;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, Set.of());
    }

    public List<List<Integer>> permute(int[] nums, Set<Integer> exclude) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!exclude.contains(i)) {
                HashSet<Integer> newExclude = new HashSet<>(exclude);
                newExclude.add(i);

                for (List<Integer> list :permute(nums, newExclude)) {
                    list.add(nums[i]);
                    result.add(list);
                }
            }
        }

        if (result.isEmpty()) {
            result.add(new ArrayList<>());
        }

        return result;
    }
}
