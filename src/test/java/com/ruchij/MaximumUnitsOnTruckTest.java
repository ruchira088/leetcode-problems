package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumUnitsOnTruckTest {
    private final MaximumUnitsOnTruck maximumUnitsOnTruck = new MaximumUnitsOnTruck();

    @Test
    void testOne() {
        assertEquals(8, maximumUnitsOnTruck.maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4));
    }

    @Test
    void testTwo() {
        assertEquals(91, maximumUnitsOnTruck.maximumUnits(new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10));
    }

}