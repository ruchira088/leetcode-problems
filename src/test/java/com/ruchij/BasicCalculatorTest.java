package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BasicCalculatorTest {
    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    void testOne() {
        Assertions.assertEquals(5, basicCalculator.calculate("3+5/2"));
        Assertions.assertEquals(1, basicCalculator.calculate("3/2"));
        Assertions.assertEquals(7, basicCalculator.calculate("3+2*2"));
        Assertions.assertEquals(1, basicCalculator.calculate("1-1+1"));
        Assertions.assertEquals(8, basicCalculator.calculate("14/3*2"));
        Assertions.assertEquals(6, basicCalculator.calculate("1+2*5/3+6/4*2"));
        Assertions.assertEquals(5, basicCalculator.calculate(" 3+5 / 2 "));
    }

}