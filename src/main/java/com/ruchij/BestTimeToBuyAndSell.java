package com.ruchij;

public class BestTimeToBuyAndSell {
    public int maxProfit(int k, int[] prices) {
        int days = prices.length;
        int[][][] profits = new int[days][k + 1][2];

        if (k <= 0 || days <= 1) {
            return 0;
        }

        for (int i = 0; i < days; i++) {
            for (int j = 0; j <= k; j++) {
                profits[i][j][0] = -1000_000;
                profits[i][j][1] = -1000_000;
            }
        }

        profits[0][0][0] = 0;
        profits[0][1][1] = -prices[0];

        for (int i = 1; i < days; i++) {
            for (int t = 0; t <= k; t++) {
                profits[i][t][0] = Math.max(profits[i - 1][t][0], profits[i - 1][t][1] + prices[i]);

                if (t > 0) {
                    profits[i][t][1] = Math.max(profits[i - 1][t][1], profits[i - 1][t - 1][0] - prices[i]);
                }
            }
        }

        int result = 0;

        for (int i = 0; i <= k; i++) {
            result = Math.max(result, profits[days - 1][i][0]);
        }

        return result;
    }
}
