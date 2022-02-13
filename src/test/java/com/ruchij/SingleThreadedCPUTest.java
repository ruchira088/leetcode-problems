package com.ruchij;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

class SingleThreadedCPUTest {
    private final SingleThreadedCPU singleThreadedCPU = new SingleThreadedCPU();

    @Test
    void testOne() {
        int[][] input = {{1, 2}, {2, 4}, {3, 2}, {4, 1}};
        System.out.println(Arrays.stream(singleThreadedCPU.getOrder(input)).boxed().collect(Collectors.toList()));
    }

    @Test
    void testTwo() {
        int[][] input = {{5, 2}, {7, 2}, {9, 4}, {6, 3}, {5, 10}, {1, 1}};
        System.out.println(Arrays.stream(singleThreadedCPU.getOrder(input)).boxed().collect(Collectors.toList()));
    }

}