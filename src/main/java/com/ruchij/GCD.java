package com.ruchij;

public class GCD {
    public long run(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return run(b, a % b);
        }
    }
}
