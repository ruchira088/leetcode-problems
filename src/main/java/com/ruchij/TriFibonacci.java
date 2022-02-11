package com.ruchij;

public class TriFibonacci {
//    public int tribonacci(int n) {
//        int x = 0;
//        int y = 1;
//        int z = 1;
//        int temp = 0;
//
//        for (int i = 1; i <= n; i++) {
//            temp = z;
//            z = z + y + x;
//            x = y;
//            y = temp;
//        }
//
//        return x;
//    }

    public int tribonacci(int n) {
        return tribonacci(n, new int[n+1]);
    }

    public int tribonacci(int n, int[] values) {
        if (n <= 2) {
            return Math.min(n, 1);
        } else {
            int value = values[n];

            if (value == 0) {
                value = tribonacci(n - 1, values) + tribonacci(n - 2, values) + tribonacci(n - 3, values);
                values[n] = value;
            }

            return value;
        }
    }
}
