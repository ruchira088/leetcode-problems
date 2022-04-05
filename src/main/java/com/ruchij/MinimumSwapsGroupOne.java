package com.ruchij;

public class MinimumSwapsGroupOne {
    public int minSwaps(int[] data) {
        int onesCount = 0;
        int max = 0;

        for (int datum : data) {
            onesCount += datum;
        }

        for (int i = 0; i < onesCount; i++) {
            max += data[i];
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
