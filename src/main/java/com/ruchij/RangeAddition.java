package com.ruchij;

public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] data = new int[length];

        for (int[] update :  updates) {
            int start = update[0];
            int end = update[1];
            int diff = update[2];

            for (int i = start; i <= end; i++) {
                data[i] = data[i] + diff;
            }
        }

        return data;
    }
}
