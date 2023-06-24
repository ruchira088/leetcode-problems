package com.ruchij.canva;

import java.util.ArrayDeque;

public class ClimbStairs {
    public int climbStairs(int n) {
        return fib(n + 1);
    }

    public int fib(int n) {
        int x0 = 0;
        int x1 = 1;

        for (int i = 0; i < n; i++) {
            int next = x1 + x0;
            x0 = x1;
            x1 = next;
        }

        return x0;
    }
}
