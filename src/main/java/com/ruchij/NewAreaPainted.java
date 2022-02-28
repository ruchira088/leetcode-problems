package com.ruchij;

import java.util.HashSet;

public class NewAreaPainted {
    public int[] amountPainted(int[][] paint) {
        HashSet<Integer> painted = new HashSet<>();
        int[] workDone = new int[paint.length];

        for (int i = 0; i < paint.length; i++) {
            int start = paint[i][0];
            int end = paint[i][1];

            int work = 0;

            for (int j = start; j < end; j++) {
                if (!painted.contains(j)) {
                    painted.add(j);
                    work++;
                }
            }

            workDone[i] = work;
        }

        return workDone;
    }
}
