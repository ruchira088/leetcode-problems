package com.ruchij.google;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            int left = heights[i];
            int lowest = heights[i];
            max = Math.max(left, max);

            for (int j = i + 1; j < heights.length; j++) {
                lowest = Math.min(lowest, heights[j]);
                max = Math.max(max, lowest * (j + 1 - i));
            }
        }

        return max;
    }
}
