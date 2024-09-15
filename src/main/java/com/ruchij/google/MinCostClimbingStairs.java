package com.ruchij.google;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] costs = new int[cost.length];
        costs[0] = 0;
        costs[1] = 0;

        for (int i = 2; i < cost.length; i++) {
            int minCostOne = costs[i - 2] + cost[i - 2];
            int minCostTwo = costs[i - 1] + cost[i - 1];

            int minCost = Math.min(minCostOne, minCostTwo);
            costs[i] = minCost;
        }

        return Math.min(costs[cost.length - 1] + cost[cost.length - 1], costs[cost.length - 2] + cost[cost.length - 2]);
    }
}
