package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumProfitTest {
    @Test
    void returnsExpectedResult() {
        MaximumProfit maximumProfit = new MaximumProfit();

        Assertions.assertEquals(150, maximumProfit.jobScheduling(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60}));
//        Assertions.assertEquals(120, maximumProfit.jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}));
    }

}