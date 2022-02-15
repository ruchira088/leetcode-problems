package com.ruchij;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GardenNoAdjacent {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] gardens = new int[n];
        HashMap<Integer, Set<Integer>> mappings = new HashMap<>();

        for (int i = 0; i < paths.length; i++) {
            int start = paths[i][0];
            int end = paths[i][1];

            Set<Integer> startRoutes = mappings.getOrDefault(start, new HashSet<>());
            startRoutes.add(end);
            mappings.put(start, startRoutes);

            Set<Integer> endRoutes = mappings.getOrDefault(end, new HashSet<>());
            endRoutes.add(start);
            mappings.put(end, endRoutes);
        }

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                gardens[0] = 1;
            }

            setFlower(mappings, gardens, i);
        }

        for (int i = 0; i < gardens.length; i++) {
            if (gardens[i] == 0) {
                gardens[i] = 1;
            }
        }

        return gardens;
    }

    void setFlower(Map<Integer, Set<Integer>> map, int[] gardens, int garden) {
        Set<Integer> paths = map.getOrDefault(garden, new HashSet<>());

        for (Integer path : paths) {
            if (gardens[path - 1] == 0) {
                Set<Integer> integers = map.getOrDefault(path, new HashSet<>()).stream().map(x -> gardens[x - 1]).collect(Collectors.toSet());
                List<Integer> flowers = Stream.of(1, 2, 3, 4).filter(flower -> !integers.contains(flower)).collect(Collectors.toList());

                gardens[path - 1] = flowers.get(0);

                setFlower(map, gardens, path);
            }
        }
    }
}
