package com.ruchij;

import java.util.*;
import java.util.stream.Collectors;

public class BusRoutes {
    record State(int stop, int count) {}

    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, Set<Integer>> map = routeMap(routes);
        ArrayDeque<State> queue = new ArrayDeque<>();
        Set<Integer> visitedStops = new HashSet<>();
        visitedStops.add(source);
        queue.add(new State(source, 0));

        while (!queue.isEmpty()) {
            State state = queue.pop();

            if (state.stop == target) {
                return state.count;
            }

            Set<Integer> nextStops = map.getOrDefault(state.stop, new HashSet<>());

            for (Integer next: nextStops) {
                if (!visitedStops.contains(next)) {
                    queue.add(new State(next, state.count + 1));
                    visitedStops.add(next);
                }
            }
        }

        return -1;
    }

    Map<Integer, Set<Integer>> routeMap(int[][] routes) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] route: routes) {
            Set<Integer> stops = Arrays.stream(route).boxed().collect(Collectors.toSet());

            for (int stop: route) {
                Set<Integer> existing = map.getOrDefault(stop, new HashSet<>());
                existing.addAll(stops);
                existing.remove(stop);

                map.put(stop, existing);
            }
        }

        return map;
    }
}
