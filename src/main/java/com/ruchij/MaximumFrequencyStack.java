package com.ruchij;

import java.util.*;

public class MaximumFrequencyStack {

    static class FreqStack {
        record Tuple(int value, int count, int index){}

        int index = 0;

        private final Map<Integer, Integer> count = new HashMap<>();
        private final PriorityQueue<Tuple> maximum =
                new PriorityQueue<>(Comparator.comparingInt(Tuple::count).thenComparingInt(Tuple::index).reversed());

        public FreqStack() {

        }

        public void push(int val) {
            int updatedCount = count.getOrDefault(val, 0) + 1;
            count.put(val, updatedCount);

            Tuple tuple = new Tuple(val, updatedCount, index);
            maximum.add(tuple);

            index++;
        }

        public int pop() {
            Tuple max = maximum.poll();
            count.put(max.value, count.get(max.value) - 1);

            return max.value;
        }
    }
}
