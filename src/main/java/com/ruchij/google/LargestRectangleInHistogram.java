package com.ruchij.google;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int[] leftLessThan = new int[heights.length];
        int[] rightLessThan = new int[heights.length];

        leftLessThan[0] = -1;
        rightLessThan[heights.length - 1] = heights.length;

        for (int index = 1; index < heights.length; index++) {
            int current = index - 1;

            while (current >= 0 && heights[current] >= heights[index]) {
                current = leftLessThan[current];
            }

            leftLessThan[index] = current;
        }

        for (int index = heights.length - 2; index >= 0; index--) {
            int current = index + 1;

            while (current < heights.length && heights[current] >= heights[index]) {
                current = rightLessThan[current];
            }

            rightLessThan[index] = current;
        }

        int max = 0;

        for (int index = 0; index < heights.length; index++) {
            int area = heights[index] * (rightLessThan[index] - leftLessThan[index] - 1);
            max = Math.max(max, area);
        }

        return max;
    }


}
