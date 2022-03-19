package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RobotBoundedInCircleTest {
    private final RobotBoundedInCircle robotBoundedInCircle = new RobotBoundedInCircle();

    @Test
    void testOne() {
        Assertions.assertTrue(robotBoundedInCircle.isRobotBounded("GGLLGG"));
    }

    @Test
    void testTwo() {
        Assertions.assertFalse(robotBoundedInCircle.isRobotBounded("GG"));
    }

    @Test
    void testThree() {
        Assertions.assertTrue(robotBoundedInCircle.isRobotBounded("GL"));
    }

}