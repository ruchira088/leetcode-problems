package com.ruchij;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSumTwo {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        return combinationSum2(candidates, target, 0, new HashSet<>(), new ArrayList<>()).stream().collect(Collectors.toList());
    }

    public Set<List<Integer>> combinationSum2(int[] candidates, int target, int start, Set<List<Integer>> results, List<Integer> combination) {

        if (target < 0) {
            return results;
        } else if (target == 0) {
            results.add(new ArrayList<>(combination));
        } else {
            for (int i = start; i < candidates.length; i++) {
                int current = candidates[i];

                if (i != start && current == candidates[i - 1]) {
                    continue;
                }

                if (target >= current) {
                    combination.add(0, current);
                    combinationSum2(candidates, target - current, i + 1, results, combination);
                    combination.remove(0);
                }

            }
        }

        return results;
    }
}
