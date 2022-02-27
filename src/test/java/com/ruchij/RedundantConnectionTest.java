package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedundantConnectionTest {
    private final RedundantConnection redundantConnection = new RedundantConnection();

    @Test
    void testOne() {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        int[] expected = {2, 3};

        assertArrayEquals(expected, redundantConnection.findRedundantConnection(edges));
    }

    @Test
    void testTwo() {
        int[][] edges = {{9, 10}, {5, 8}, {2, 6}, {1, 5}, {3, 8}, {4, 9}, {8, 10}, {4, 10}, {6, 8}, {7, 9}};
        int[] expected = {4, 10};

        assertArrayEquals(expected, redundantConnection.findRedundantConnection(edges));
    }

}