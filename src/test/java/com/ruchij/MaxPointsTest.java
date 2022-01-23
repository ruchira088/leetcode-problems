package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaxPointsTest {
    private final MaxPoints maxPoints = new MaxPoints();

    @Test
    void maxPoints() {
        int[][] matrixOne = Stream.of(
                IntStream.of(1, 2, 3),
                IntStream.of(1, 5, 1),
                IntStream.of(3, 1, 1)
        )
                .map(IntStream::toArray)
                .toArray(int[][]::new);

        Assertions.assertEquals(9, maxPoints.maxPoints(matrixOne));

        int[][] matrixTwo = Stream.of(IntStream.of(10).toArray()).toArray(int[][]::new);

        Assertions.assertEquals(10, maxPoints.maxPoints(matrixTwo));
    }
}
