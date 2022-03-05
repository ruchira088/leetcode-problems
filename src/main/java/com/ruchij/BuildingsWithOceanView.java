package com.ruchij;

import java.util.ArrayList;

public class BuildingsWithOceanView {
    public int[] findBuildings(int[] heights) {
        int height = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > height) {
                result.add(i);
                height = heights[i];
            }
        }

        return result.stream().sorted().mapToInt(x -> x).toArray();
    }
}
