package com.ruchij;

import java.util.Arrays;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] ordered = new int[heights.length];
        System.arraycopy(heights, 0, ordered, 0, heights.length);
        Arrays.sort(ordered);

        int diff = 0;

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != ordered[i]) {
                diff++;
            }
        }

        return diff;
    }
}
