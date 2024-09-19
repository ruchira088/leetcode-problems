package com.ruchij.google;

public class MaximumNumberOfPointsWithCost {
    public long maxPoints2(int[][] points) {
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

    public long maxPoints(int[][] points) {
        long max = 0;
        long[] previousRow = new long[points[0].length];
        long[] currentRow = new long[points[0].length];

        for (int[] row : points) {
            for (int i = 0; i < row.length; i++) {
                long value = previousRow[i] + row[i];

                // Go left
                for (int x = 0; i - x >= 0; x++) {
                    long previousValue = currentRow[i - x];
                    long newValue = value - x;

                    if (newValue >= previousValue) {
                        currentRow[i - x] = newValue;
                        max = Math.max(newValue, max);
                    } else {
                        break;
                    }
                }

                for (int x = 0; i + x < row.length; x++) {
                    long previousValue = currentRow[x + i];
                    long newValue = value - x;

                    if (newValue >= previousValue) {
                        currentRow[x + i] = newValue;
                        max = Math.max(newValue, max);
                    }
                }

            }

            previousRow = currentRow;
            currentRow = new long[row.length];
        }

        return max;
    }

}
