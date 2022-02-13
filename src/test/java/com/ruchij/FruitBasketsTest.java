package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FruitBasketsTest {
    private final FruitBaskets fruitBaskets = new FruitBaskets();

    @Test
    void testOne() {
        Assertions.assertEquals(3, fruitBaskets.totalFruit(new int[]{1, 2, 1}));
    }

    @Test
    void testTwo() {
        Assertions.assertEquals(3, fruitBaskets.totalFruit(new int[]{0, 1, 2, 2}));
    }

    @Test
    void testThree() {
        Assertions.assertEquals(4, fruitBaskets.totalFruit(new int[]{1, 2, 3, 2, 2}));
    }

    @Test
    void testFour() {
        Assertions.assertEquals(6, fruitBaskets.totalFruit(new int[]{1, 0, 0, 0, 1, 0, 4, 0, 4}));
    }

}