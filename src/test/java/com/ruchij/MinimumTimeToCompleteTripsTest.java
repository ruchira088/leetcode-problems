package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumTimeToCompleteTripsTest {

    @Test
    void shouldReturnExpectedResult() {
        MinimumTimeToCompleteTrips minimumTimeToCompleteTrips = new MinimumTimeToCompleteTrips();
        assertEquals(3, minimumTimeToCompleteTrips.minimumTime(new int[]{1, 2, 3}, 5));
//        assertEquals(2, minimumTimeToCompleteTrips.minimumTime(new int[]{2}, 1));
    }

}