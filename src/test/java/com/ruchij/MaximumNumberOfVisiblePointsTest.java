package com.ruchij;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaximumNumberOfVisiblePointsTest {
    private final MaximumNumberOfVisiblePoints maximumNumberOfVisiblePoints = new MaximumNumberOfVisiblePoints();

    @Test
    void findLastTest() {
        double[] input = {1, 2, 3, 4, 4, 4, 5, 5, 6, 7, 9};

        assertEquals(2, maximumNumberOfVisiblePoints.findLast(input, 3));
        assertEquals(5, maximumNumberOfVisiblePoints.findLast(input, 4));
        assertEquals(7, maximumNumberOfVisiblePoints.findLast(input, 5));
        assertEquals(9, maximumNumberOfVisiblePoints.findLast(input, 7));
        assertEquals(9, maximumNumberOfVisiblePoints.findLast(input, 8));
        assertEquals(10, maximumNumberOfVisiblePoints.findLast(input, 9));
        assertEquals(10, maximumNumberOfVisiblePoints.findLast(input, 20));
    }

    @Test
    void testOne() {
        List<List<Integer>> points = List.of(List.of(2, 1), List.of(2, 2), List.of(3, 3));
        int angle = 90;
        List<Integer> location = List.of(1, 1);

        assertEquals(3, maximumNumberOfVisiblePoints.visiblePoints(points, angle, location));

    }

    @Test
    void testTwo() {
        List<List<Integer>> points = List.of(List.of(2, 1), List.of(2, 2), List.of(3, 4), List.of(1, 1));
        int angle = 90;
        List<Integer> location = List.of(1, 1);

        assertEquals(4, maximumNumberOfVisiblePoints.visiblePoints(points, angle, location));

    }

    @Test
    void testThree() {
        List<List<Integer>> points = List.of(List.of(1, 0), List.of(2, 1));
        int angle = 13;
        List<Integer> location = List.of(1, 1);

        assertEquals(1, maximumNumberOfVisiblePoints.visiblePoints(points, angle, location));

    }

}