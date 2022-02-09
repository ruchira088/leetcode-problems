package com.ruchij;

import java.util.*;

public class MinimumEdges {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, Set<Integer>> destinationMap = new HashMap<>();
        Map<Integer, Set<Integer>> arrivalMap = new HashMap<>();

        for (int[] route: connections) {
            int start = route[0];
            int end = route[1];

            Set<Integer> destinations = destinationMap.getOrDefault(start, new HashSet<>());
            destinations.add(end);
            destinationMap.put(start, destinations);

            Set<Integer> arrivals = arrivalMap.getOrDefault(end, new HashSet<>());
            arrivals.add(start);
            arrivalMap.put(end, arrivals);
        }

        int changes = 0;

        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        while (visited.size() != n) {
            int city = queue.pop();

            for (int next : arrivalMap.getOrDefault(city, new HashSet<>())) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }

            for (int from: destinationMap.getOrDefault(city, new HashSet<>())) {
                if (!visited.contains(from)) {
                    visited.add(from);
                    queue.add(from);
                    changes++;
                }
            }
        }

        return changes;
    }
}
