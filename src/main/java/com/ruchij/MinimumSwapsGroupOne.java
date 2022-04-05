package com.ruchij;

public class MinimumSwapsGroupOne {
    public int minSwaps(int[] data) {
        int onesCount = 0;
        int max = 0;

        for (int datum : data) {
            if (datum == 1) {
                onesCount++;
            }
        }

        for (int i = 0; i < onesCount; i++) {
            if (data[i] == 1) {
                max++;
            }
        }

        int current = max;

        for (int i = 0; i < data.length - onesCount; i++) {
            int first = data[i];
            int next = data[i + onesCount];

            if (first != next) {
                if (first == 1) {
                    current--;
                } else {
                    current++;
                }

                max = Math.max(max, current);
            }
        }

        return onesCount - max;
    }
}
