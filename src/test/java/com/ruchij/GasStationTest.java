package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GasStationTest {
    private final GasStation gasStation = new GasStation();

    @Test
    void testOne() {
        assertEquals(3, gasStation.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }

    @Test
    void testTwo() {
        assertEquals(-1, gasStation.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }

}