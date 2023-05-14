package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallestNumberOfNeighboursTest {

    @Test
    void returnsExpectedResult() {
        SmallestNumberOfNeighbours smallestNumberOfNeighbours = new SmallestNumberOfNeighbours();

//        assertEquals(3, smallestNumberOfNeighbours.findTheCity(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4));
//        assertEquals(0, smallestNumberOfNeighbours.findTheCity(5, new int[][]{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}}, 2));

//        System.out.println(smallestNumberOfNeighbours.findTheCity(6, new int[][]{{0,3,7},{2,4,1},{0,1,5},{2,3,10},{1,3,6},{1,2,1}}, 417));

        System.out.println(smallestNumberOfNeighbours.findTheCity(6, new int[][]{{0,1,10},{0,2,1},{2,3,1},{1,3,1},{1,4,1},{4,5,10}}, 20));

    }

}