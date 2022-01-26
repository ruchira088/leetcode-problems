package com.ruchij;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else {
                int currentProfit = prices[i] - minPrice;

                if (currentProfit > profit) {
                    profit = currentProfit;
                }
            }
        }

        return profit;
    }

}
