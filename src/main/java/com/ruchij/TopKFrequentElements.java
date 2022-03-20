package com.ruchij;

import java.util.*;

public class TopKFrequentElements {
    record Tuple(int value, int count) {}

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        PriorityQueue<Tuple> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Tuple::count).reversed());
        int[] results = new int[k];

        for (int value : nums) {
            int updatedCount = countMap.getOrDefault(value, 0) + 1;
            countMap.put(value, updatedCount);

            priorityQueue.add(new Tuple(value, updatedCount));
        }

        int count = 0;
        Set<Integer> added = new HashSet<>();

        while (count != k) {
            Tuple tuple = priorityQueue.poll();

            if (!added.contains(tuple.value)) {
                added.add(tuple.value);
                results[count] = tuple.value;
                count++;
            }
        }

        return results;
    }
}
