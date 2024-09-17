package com.ruchij.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> xAxis = new HashMap<>();
        Map<Integer, Set<Integer>> yAxis = new HashMap<>();

        int minArea = Integer.MAX_VALUE;

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            Set<Integer> ys = xAxis.computeIfAbsent(x, __ -> new HashSet<>());
            ys.add(y);

            Set<Integer> xs = yAxis.computeIfAbsent(y, __ -> new HashSet<>());
            xs.add(x);
        }

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            int area = findMinimumArea(x, y, xAxis, yAxis);
            minArea = Math.min(minArea, area);
        }

        return minArea;
    }


    private int findMinimumArea(int x, int y, Map<Integer, Set<Integer>> xAxis, Map<Integer, Set<Integer>> yAxis) {
        int minArea = Integer.MAX_VALUE;

        Set<Integer> ys = xAxis.getOrDefault(x, Set.of());

        for (int y1 : ys) {
            if (y1 != y) {
                for (int x1 : yAxis.getOrDefault(y1, Set.of())) {
                    if (x1 != x) {
                        if (yAxis.getOrDefault(x1, Set.of()).contains(y)) {
                            int area = Math.abs(x - x1) * Math.abs(y - y1);
                            minArea = Math.min(minArea, area);
                        }
                    }
                }
            }
        }

        return minArea;
    }
}
