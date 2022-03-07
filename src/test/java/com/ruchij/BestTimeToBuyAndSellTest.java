package com.ruchij;

import org.junit.jupiter.api.Test;

class BestTimeToBuyAndSellTest {
    private final BestTimeToBuyAndSell bestTimeToBuyAndSell = new BestTimeToBuyAndSell();

    @Test
    void testOne() {
        System.out.println(bestTimeToBuyAndSell.maxProfit(4, new int[]{3, 2, 6, 5, 0, 3}));
    }

}