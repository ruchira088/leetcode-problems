package com.ruchij;

import java.util.*;

public class SmallestNumberOfNeighbours {
    record State(int city, int remainingDistance) {}

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, TreeMap<Integer, Set<Integer>>> nodes = parse(edges);
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int neighbours = findNeighbours(i, nodes, distanceThreshold);
            treeMap.put(neighbours, i);
            System.out.println("%s -> %s".formatted(i, neighbours));
        }

        return treeMap.firstEntry().getValue();

    }

    int findNeighbours(int city, Map<Integer, TreeMap<Integer, Set<Integer>>> nodes, int distanceThreshold) {
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<State> queue = new PriorityQueue<State>(Comparator.comparing(State::remainingDistance).reversed());
        queue.add(new State(city, distanceThreshold));

        while (!queue.isEmpty()) {
            State state = queue.poll();

            if (!visited.contains(state.city)) {
                visited.add(state.city);

                TreeMap<Integer, Set<Integer>> map = nodes.get(state.city);

                if (map != null) {
                    SortedMap<Integer, Set<Integer>> sortedMap = map.headMap(state.remainingDistance, true);

                    for (Map.Entry<Integer, Set<Integer>> entry : sortedMap.entrySet()) {
                        int distance = state.remainingDistance - entry.getKey();

                        for (Integer nextCity : entry.getValue()) {

                            if (distance >= 0) {
                                State nextState = new State(nextCity, distance);
                                queue.add(nextState);
                            }
                        }
                    }
                }
            }
        }

        return visited.size();
    }

    Map<Integer, TreeMap<Integer, Set<Integer>>> parse(int[][] edges) {
        HashMap<Integer, TreeMap<Integer, Set<Integer>>> map = new HashMap<>();

        for (int[] route : edges) {
            int from = route[0];
            int to = route[1];
            int distance = route[2];

            TreeMap<Integer, Set<Integer>> treeMap = map.computeIfAbsent(from, __ -> new TreeMap<>());
            Set<Integer> integers = treeMap.computeIfAbsent(distance, __ -> new HashSet<>());
            integers.add(to);

            treeMap = map.computeIfAbsent(to, __ -> new TreeMap<>());
            integers = treeMap.computeIfAbsent(distance, __ -> new HashSet<>());
            integers.add(from);
        }

        return map;
    }
}
