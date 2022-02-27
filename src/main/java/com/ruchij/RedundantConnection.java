package com.ruchij;

import java.util.HashSet;
import java.util.Set;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        Set<Set<Integer>> sets = new HashSet<>();
        int[] result = null;

        for (int[] connection: edges) {
            int start = connection[0];
            int end = connection[1];
            Set<Integer> added = null;

            for (Set<Integer> set : sets) {
                if (set.contains(start) || set.contains(end)) {
                    if (set.contains(start) && set.contains(end)) {
                        result = connection;
                    }

                    if (added == null) {
                        set.add(start);
                        set.add(end);
                        added = set;
                    } else {
                        added.addAll(set);
                        set.clear();
                    }
                }
            }

            if (added == null) {
                HashSet<Integer> set = new HashSet<>();
                set.add(start);
                set.add(end);
                sets.add(set);
            }

            sets.remove(Set.of());

        }

        return result;
    }
}
