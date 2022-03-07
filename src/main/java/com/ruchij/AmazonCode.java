package com.ruchij;

import java.util.*;

public class AmazonCode {
    public static long maximumQuality(List<Integer> packets, int channels) {
        packets.sort(Comparator.comparingInt(quality -> quality));
        int packetCount = packets.size();
        int first = packetCount - channels;

        long firstMedian = 0;
        long result = 0;

        if (first % 2 == 0) {
            firstMedian = packets.get(first / 2);
        } else {
            double total = (double) (packets.get(first / 2) + packets.get((first + 1) / 2));
            firstMedian = (long) Math.ceil(total / 2);
        }

        for (int i = first + 1; i < packetCount; i++) {
            result += packets.get(i);
        }

        result += firstMedian;

        return result;

    }

    public static long findTotalImbalance(List<Integer> input) {
        List<Integer> rank = new ArrayList<>(input);
        long imbalances = 0;
        int size = rank.size();

        for (int i = 0; i < size; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            for (int j = i; j < size; j++) {
               list.add(rank.get(j));
               list.sort(Comparator.comparingInt(x -> x));

                for (int n = 1; n < list.size(); n++) {
                    if (list.get(n - 1) + 1 != list.get(n)) {
                        imbalances++;
                    }
                }
            }
        }

        return imbalances;

    }
}
