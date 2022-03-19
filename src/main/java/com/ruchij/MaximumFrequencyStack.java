package com.ruchij;

import java.util.*;

public class MaximumFrequencyStack {

    static class FreqStack {

        int max = 0;

        private final Map<Integer, Integer> count = new HashMap<>();
        private final Map<Integer, Stack<Integer>> stackMap = new HashMap<>();

        public FreqStack() {

        }

        public void push(int val) {
            int updatedCount = count.getOrDefault(val, 0) + 1;
            count.put(val, updatedCount);

            if (max < updatedCount) {
                max = updatedCount;
            }

            stackMap.computeIfAbsent(updatedCount, x -> new Stack<>()).push(val);
        }

        public int pop() {
            Stack<Integer> stack = stackMap.get(max);
            int value = stack.pop();

            count.put(value, count.get(value) - 1);

            if (stack.isEmpty()) {
                max--;
            }

            return value;
        }
    }
}
