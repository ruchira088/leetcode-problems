package com.ruchij;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        combinationSum(candidates, target, 0, results, new ArrayList<>());

        return results;
    }

    public void combinationSum(int[] candidates, int target, int start, List<List<Integer>> results, List<Integer> combination) {
        if (target == 0) {
            results.add(new ArrayList<>(combination));
        } else if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                combination.add(0, candidates[i]);
                combinationSum(candidates, target - candidates[i], i, results, combination);
                combination.remove(0);
            }
        }
    }
}
