package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BusRoutesTest {
    private final BusRoutes busRoutes = new BusRoutes();

    @Test
    void testOne() {
        int[] routeOne = {1, 2, 7};
        int[] routeTwo = {3, 6, 7};
        Assertions.assertEquals(2, busRoutes.numBusesToDestination(new int[][]{routeOne, routeTwo}, 1, 6));
    }
}