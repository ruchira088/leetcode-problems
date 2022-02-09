package com.ruchij;

import org.junit.jupiter.api.Test;

class MinimumEdgesTest {
    private final MinimumEdges minimumEdges = new MinimumEdges();

    @Test
    void testOne() {
        int result =
                minimumEdges.minReorder(6, new int[][]{new int[]{0, 1}, new int[]{1, 3}, new int[]{2, 3}, new int[]{4, 0}, new int[]{4, 5}});

        System.out.println(result);
    }

    @Test
    void testTwo() {
        int result =
                minimumEdges.minReorder(5, new int[][]{new int[]{1, 0}, new int[]{1, 2}, new int[]{3, 2}, new int[]{3, 4}});

        System.out.println(result);
    }

}