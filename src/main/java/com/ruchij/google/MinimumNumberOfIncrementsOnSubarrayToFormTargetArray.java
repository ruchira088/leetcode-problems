package com.ruchij.google;

import java.util.Arrays;

public class MinimumNumberOfIncrementsOnSubarrayToFormTargetArray {
    public int minNumberOperations(int[] target) {
        int count = target[0];

        for (int i = 0; i < target.length - 1; i++) {
            count += Math.max(target[i + 1] - target[i], 0);
        }

        return count;
    }

    public int minNumberOperationsOne(int[] target) {
        int[] initial = new int[target.length];
        int count = 0;

        while (!Arrays.equals(target, initial)) {
            int start = -1;
            int end = -1;
            int minDiff = Integer.MAX_VALUE;

            for (int i = 0; i < target.length; i++) {
                int diff = target[i] - initial[i];

                if (diff != 0) {
                    minDiff = Math.min(diff, minDiff);
                }

                if (start == -1) {
                    if (diff != 0) {
                        start = i;
                        end = i;
                    }
                } else {
                    if (diff != 0) {
                        end = i;
                    } else {
                        break;
                    }
                }
            }

            for (int i = start; i <= end; i++) {
                initial[i] += minDiff;
            }

            count += minDiff;
        }


        return count;
    }
}
