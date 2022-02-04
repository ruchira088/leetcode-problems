package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DetectSquaresTest {

    @Test
    void testOne() {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[] {3, 10});
        detectSquares.add(new int[] {11, 2});
        detectSquares.add(new int[] {3, 2});
        Assertions.assertEquals(1, detectSquares.count(new int[] {11, 10}));

        Assertions.assertEquals(0, detectSquares.count(new int[] {14, 8}));
        detectSquares.add(new int[] {3, 2});
        detectSquares.add(new int[] {11, 2});
        detectSquares.add(new int[] {11, 2});

        Assertions.assertEquals(6, detectSquares.count(new int[] {11, 10}));
    }
}