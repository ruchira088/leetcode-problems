package com.ruchij.google;

public class BestTimeToBuyAndSell {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int lowestPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < lowestPrice) {
                lowestPrice = price;
            } else {
                int profit = price - lowestPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}
