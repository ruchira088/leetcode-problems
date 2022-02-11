package com.ruchij;

public class Fibonacci {
    public int fib2(int n) {
        if (n <= 1) {
            return n;
        } else {
            int first = 0;
            int second = 1;

            for (int i = 2; i <= n; i++) {
                second = second + first;
                first = second - first;
            }

            return second;
        }
    }

    public int fib(int n) {
        int[] values = new int[n + 1];
        return fib(n, values);
    }

    private int fib(int n, int[] values) {
        if (n <= 1) {
            return n;
        } else {
            int value = values[n];

            if (value == 0) {
                int result = fib(n - 1, values) + fib(n - 2, values);
                values[n] = result;

                return result;
            } else {
                return value;
            }
        }
    }

}
