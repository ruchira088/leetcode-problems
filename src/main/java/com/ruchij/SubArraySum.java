package com.ruchij;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubArraySum {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        int[] sums = new int[nums.length];
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
            Set<Integer> set = map.getOrDefault(sum, new HashSet<>());
            set.add(i);
            map.put(sum, set);
        }

        for (int i = 0; i < sums.length + 1; i++) {
            int diff = k + (i == 0 ? 0 : sums[i - 1]);

            Set<Integer> matches = map.getOrDefault(diff, Set.of());

            for (Integer match : matches) {
                if (match >= i) {
                    count++;
                }
            }
        }

        return count;
    }
}
