package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceCarTest {
    private final RaceCar raceCar = new RaceCar();

    @Test
    void testOne() {
        assertEquals(2, raceCar.racecar(3));
        assertEquals(5, raceCar.racecar(6));
    }

}