package com.ruchij;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindingUsersActiveMinutes {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] result = new int[k];
        HashMap<Integer, Set<Integer>> userActivity = new HashMap<>();

        for (int[] log : logs) {
            int userId = log[0];
            int time = log[1];

            Set<Integer> activeMinutes = userActivity.computeIfAbsent(userId, __ -> new HashSet<>());
            activeMinutes.add(time);
        }

        for (Set<Integer> minutes : userActivity.values()) {
            int size = minutes.size();
            result[size-1] = result[size-1] + 1;
        }

        return result;
    }
}
