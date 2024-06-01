package com.ruchij;

public class Sqrt {
    public int mySqrt(int x) {
        for (long i = 0; i <= x; i++) {
            if (i * i > x) {
                return (int) i - 1;
            }
        }

        return x;
    }
}
