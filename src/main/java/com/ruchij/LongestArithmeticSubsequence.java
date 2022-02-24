package com.ruchij;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {

    public int longestSubsequence(int[] arr, int difference) {
        int max = 0;
        Map<Integer, Integer> count = new HashMap<>();

        for (int integer : arr) {
            int diffs = count.getOrDefault(integer - difference, 0) + 1;
            count.put(integer, diffs);

            max = Math.max(diffs, max);
        }

        return max;
    }
}
