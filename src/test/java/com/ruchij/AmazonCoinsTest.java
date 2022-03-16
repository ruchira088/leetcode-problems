package com.ruchij;

import org.junit.jupiter.api.Test;

import java.util.Map;

class AmazonCoinsTest {
    private final AmazonCoins amazonCoins = new AmazonCoins();

    @Test
    void testOne() {
        System.out.println(amazonCoins.provideChange(Map.of(50, 2, 20, 3, 10, 1, 5, 1), 80));
    }

}