package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClosestTimeTest {

    @Test
    void returnsExpectedResult() {
        ClosestTime closestTime = new ClosestTime();

//        Assertions.assertEquals("19:39", closestTime.nextClosestTime("19:34"));
//        Assertions.assertEquals("22:22", closestTime.nextClosestTime("23:59"));
//        Assertions.assertEquals("01:33", closestTime.nextClosestTime("01:32"));
        Assertions.assertEquals("23:22", closestTime.nextClosestTime("22:37"));
    }

}