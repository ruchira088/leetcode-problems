package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShortestBridgeTest {

    @Test
    void determinesIslandsCorrectly() {
        ShortestBridge shortestBridge = new ShortestBridge();

        int[][] gridOne = new int[][]{{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
        Assertions.assertEquals(1, shortestBridge.shortestBridge(gridOne));

        int[][] gridTwo = new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 0, 1}};
        Assertions.assertEquals(2, shortestBridge.shortestBridge(gridTwo));
    }

}