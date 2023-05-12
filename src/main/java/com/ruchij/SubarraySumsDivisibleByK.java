package com.ruchij;

import java.util.HashMap;

public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        int divisibleCount = 0;
        int sum = 0;

        HashMap<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1);

        for (int num : nums) {
            sum += num;
            sum = (k + sum % k) % k;

            int count = remainderCount.getOrDefault(sum, 0);
            divisibleCount += count;
            remainderCount.put(sum, count + 1);
        }

        return divisibleCount;
    }
}
