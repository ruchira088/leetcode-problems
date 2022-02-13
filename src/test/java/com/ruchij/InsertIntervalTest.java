package com.ruchij;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

class InsertIntervalTest {
    private final InsertInterval insertInterval = new InsertInterval();

    @Test
    void testOne() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        int[][] result = insertInterval.insert(intervals, newInterval);

        System.out.println(Arrays.stream(result).map(array -> Arrays.stream(array).boxed().toList()).collect(Collectors.toList()));
    }

    @Test
    void testTwo() {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};

        int[][] result = insertInterval.insert(intervals, newInterval);

        System.out.println(Arrays.stream(result).map(array -> Arrays.stream(array).boxed().toList()).collect(Collectors.toList()));
    }

}