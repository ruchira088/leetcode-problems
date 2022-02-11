package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FibonacciTest {
    private final Fibonacci fibonacci = new Fibonacci();

    @Test
    void testOne() {
        for (int i = 0; i < 100; i++) {
            Assertions.assertEquals(fibonacci.fib2(i), fibonacci.fib(i));
        }
    }

}