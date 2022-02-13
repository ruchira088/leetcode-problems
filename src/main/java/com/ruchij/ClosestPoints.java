package com.ruchij;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPoints {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (o1, o2) -> {
            int x1 = o1[0];
            int y1 = o1[1];

            int x2 = o2[0];
            int y2 = o2[1];

            return (x1 * x1 + y1 * y1) - (x2 * x2 + y2 * y2);
        });

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = points[i];
        }

        return result;
    }
}
