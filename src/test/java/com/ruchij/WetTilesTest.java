package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WetTilesTest {
    private final WetTiles wetTiles = new WetTiles();

    @Test
    void testOne() {
        int[][] grid = {
                {0, -1, 0,  0},
                {0, 1, 1,  1},
                {1, 0, 0,  1},
                {0, 1, 1,  1}
        };

        System.out.println(wetTiles.countWetTiles(grid));
    }

}