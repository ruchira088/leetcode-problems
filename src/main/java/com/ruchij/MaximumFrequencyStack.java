package com.ruchij;

import java.util.*;

public class MaximumFrequencyStack {

    static class FreqStack {
        record Tuple(int value, int count){}

        private final Stack<Tuple> stack = new Stack<>();
        private final Map<Integer, Integer> count = new HashMap<>();
        private final PriorityQueue<Integer> maximum = new PriorityQueue<>(Comparator.reverseOrder());

        public FreqStack() {

        }

        public void push(int val) {
            int updatedCount = count.getOrDefault(val, 0) + 1;

            count.put(val, updatedCount);
            maximum.add(updatedCount);

            Tuple tuple = new Tuple(val, updatedCount);
            stack.push(tuple);
        }

        public int pop() {
            Integer max = maximum.poll();
            Stack<Tuple> popped = new Stack<>();

            Tuple pop = stack.pop();

            while (pop.count != max) {
                popped.push(pop);
                pop = stack.pop();
            }

            while (!popped.isEmpty()) {
                stack.push(popped.pop());
            }

            count.put(pop.value, count.get(pop.value) - 1);

            return pop.value;
        }
    }
}
