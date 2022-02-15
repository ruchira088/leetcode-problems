package com.ruchij;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class GardenNoAdjacentTest {
    private final GardenNoAdjacent gardenNoAdjacent = new GardenNoAdjacent();

    @Test
    void testOne() {
        int[][] paths = {{1, 2}, {2, 3}, {3, 1}};

        int[] result = gardenNoAdjacent.gardenNoAdj(3, paths);

        System.out.println(Arrays.stream(result).boxed().toList());
    }

    @Test
    void testTwo() {
        int[][] paths = {{1, 2}, {3, 4}};

        int[] result = gardenNoAdjacent.gardenNoAdj(4, paths);

        System.out.println(Arrays.stream(result).boxed().toList());
    }

}