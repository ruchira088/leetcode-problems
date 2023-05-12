package com.ruchij;

import java.util.*;

public class CombinationSumCandidates {
    record State(List<Integer> values, int sum, int index) {}

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        HashSet<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);
        ArrayDeque<State> queue = new ArrayDeque<>();
        queue.add(new State(new ArrayList<>(), 0, 0));

        while (!queue.isEmpty()) {
            State state = queue.poll();

            if (state.sum == target) {
                result.add(state.values);
            } else if (state.sum < target){
                for (int i = state.index; i < candidates.length; i++) {
                    ArrayList<Integer> integers = new ArrayList<>(state.values);
                    int value = candidates[i];
                    integers.add(value);

                    State next = new State(integers, state.sum + value, i);
                    queue.add(next);
                }
            }
        }

        return result.stream().toList();
    }
}
