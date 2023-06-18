package com.ruchij.canva;

import java.math.BigDecimal;
import java.math.MathContext;

public class Pow {
    public double myPow(double x, double n) {
        BigDecimal result = BigDecimal.ONE;
        BigDecimal zero = new BigDecimal("0.0000001");
        BigDecimal value = new BigDecimal(x);

        if (x == 1) {
            return 1;
        } else if (x == -1) {
            return  n % 2 == 0 ? 1 : -1;
        }

        if (n < 0) {
            for (int i = 0; i < -n; i++) {
                result = result.divide(value, MathContext.DECIMAL64);
                if (result.abs().compareTo(zero) < 0) {
                    break;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                result = result.multiply(value, MathContext.DECIMAL64);
                if (result.abs().compareTo(zero) < 0) {
                    break;
                }
            }
        }

        BigDecimal precision = new BigDecimal("100000");

        result = new BigDecimal(result.multiply(precision).toBigInteger()).divide(precision);

        return result.doubleValue();
    }
}
