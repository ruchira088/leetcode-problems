package com.ruchij.google;

public class MaximumNumberOfPointsWithCost {
    public long maxPoints(int[][] points) {
        long[][] maxPoints = new long[points.length][points[0].length];
        long max = 0;
        for (int y = 0; y < points.length; y++) {
            for (int x = 0; x < points[y].length; x++) {
                long previous = y == 0 ? 0 : maxPoints[y - 1][x];
                long currentPoints =  previous + points[y][x];

                for (int left = 0; x - left >= 0; left++) {
                    long currentValue = maxPoints[y][x - left];
                    long newValue = currentPoints - left;

                    if (newValue >= currentValue) {
                        maxPoints[y][x - left] = newValue;
                        max = Math.max(max, newValue);
                    } else {
                        break;
                    }
                }

                for (int right = 0; right + x < points[y].length; right++) {
                    long currentValue = maxPoints[y][x + right];
                    long newValue = currentPoints - right;

                    if (newValue >= currentValue) {
                        maxPoints[y][x + right] = newValue;
                        max = Math.max(max, newValue);
                    } else {
                        break;
                    }
                }
            }
        }

        return max;
    }
}
