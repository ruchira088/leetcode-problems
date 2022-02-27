package com.ruchij;

import java.util.Arrays;

public class RandomPickWithWeight {
    static class Solution {
        int[] range;

        public Solution(int[] w) {
            range = new int[w.length];
            int sum = 0;

            for (int i = 0; i < w.length; i++) {
                sum += w[i];
                range[i] = sum;
            }
        }

        public int pickIndex() {
            int sum = range[range.length - 1] + 1;
            int pick = (int) (sum * Math.random());

            if (pick == 0) {
                return pickIndex();
            }

            int found = Arrays.binarySearch(range, pick);
            int result = found < 0 ? -found-1 : found;

            return result;
        }
    }
}
