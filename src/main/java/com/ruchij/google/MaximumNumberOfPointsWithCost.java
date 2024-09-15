package com.ruchij.google;

public class MaximumNumberOfPointsWithCost {
    public long maxPoints(int[][] points) {
        long[] previousRow = new long[points[0].length];
        long[] currentRow = new long[points[0].length];
        long max = 0;
        for (int[] point : points) {
            for (int x = 0; x < point.length; x++) {
                long currentPoints = previousRow[x] + point[x];

                for (int left = 0; x - left >= 0; left++) {
                    long currentValue = currentRow[x - left];
                    long newValue = currentPoints - left;

                    if (newValue >= currentValue) {
                        currentRow[x - left] = newValue;
                        max = Math.max(max, newValue);
                    } else {
                        break;
                    }
                }

                for (int right = 0; right + x < point.length; right++) {
                    long currentValue = currentRow[x + right];
                    long newValue = currentPoints - right;

                    if (newValue >= currentValue) {
                        currentRow[x + right] = newValue;
                        max = Math.max(max, newValue);
                    } else {
                        break;
                    }
                }
            }
            previousRow = currentRow;
            currentRow = new long[points[0].length];
        }

        return max;
    }
}
