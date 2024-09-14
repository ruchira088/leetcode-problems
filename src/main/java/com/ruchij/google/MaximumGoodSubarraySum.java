package com.ruchij.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumGoodSubarraySum {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Long> cumulativeSums = new HashMap<>();
        long currentSum = 0;
        long maxSum = Long.MIN_VALUE;

        for (int value : nums) {
            for (int offset : new int[]{-k, k}) {
                if (cumulativeSums.containsKey(value + offset)) {
                    long minValue = cumulativeSums.get(value + offset);
                    maxSum = Math.max(maxSum, currentSum + value - minValue);
                }
            }

            cumulativeSums.put(value, Math.min(cumulativeSums.getOrDefault(value, Long.MAX_VALUE), currentSum));
            currentSum += value;
            System.out.println(currentSum);
        }

        return  maxSum == Long.MIN_VALUE ? 0 : maxSum;
    }

    public long maximumSubarraySumOne(int[] nums, int k) {
        Map<Integer, List<Integer>> summary = summarise(nums);
        long[] sums = sums(nums);

        long max = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> one = summary.getOrDefault(num - k, new ArrayList<>());
            List<Integer> two = summary.getOrDefault(num + k, new ArrayList<>());

            ArrayList<Integer> results = new ArrayList<>(one);
            results.addAll(two);

            for (int result : results) {
                if (i <= result) {
                    long sum = sums[result + 1] - sums[i];
                    max = Math.max(max, sum);
                }
            }
        }

        return max == Long.MIN_VALUE ? 0 : max;
    }

    long[] sums(int[] nums) {
        long[] sum = new long[nums.length + 1];
        sum[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        return sum;
    }

    Map<Integer, List<Integer>> summarise(int[] nums) {
        HashMap<Integer, List<Integer>> summary = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            List<Integer> existing = summary.computeIfAbsent(number, __ -> new ArrayList<>());
            existing.add(i);
        }

        return summary;
    }
}
