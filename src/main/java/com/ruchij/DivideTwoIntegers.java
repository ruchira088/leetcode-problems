package com.ruchij;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int result = 0;
        int n = dividend < 0 ? dividend : -dividend;
        int d = divisor < 0 ? divisor : -divisor;

        int diff = (d < -10000) ? d : -(-d - d - d - d -d - d - d - d);

        while (n <= d) {
            if (n < diff) {
                result -= d == diff ? 1 : 8;
                n = n - diff;
            } else {
                result--;
                n = n - d;
            }
        }

        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            return result;
        }

        return result == Integer.MIN_VALUE ? Integer.MAX_VALUE : -result;
    }
}
