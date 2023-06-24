package com.ruchij.canva;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClimbStairsTest {
    private final ClimbStairs climbStairs = new ClimbStairs();

    @Test
    void returnsExpectedResult() {
        for (int i = 1; i <= 35; i++) {
            System.out.println("%s -> %s".formatted(i, climbStairs.climbStairs(i)));
            System.out.println("%s -> %s".formatted(i, climbStairs.fib(i + 1)));
            System.out.println();

        }
    }

}