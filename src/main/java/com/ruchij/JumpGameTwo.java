package com.ruchij;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class JumpGameTwo {
    record State(int index, int jumps) {}

//    public int jump(int[] nums) {
//        Set<Integer> visited = new HashSet<>();
//        PriorityQueue<State> queue = new PriorityQueue<>(Comparator.comparingInt(State::jumps));
//        queue.add(new State(0, 0));
//        int destination = nums.length - 1;
//
//        while (!queue.isEmpty()) {
//            State state = queue.poll();
//            visited.add(state.index);
//
//            if (state.index == destination) {
//                return state.jumps;
//            } else {
//                for (int i = 1; state.index + i < nums.length && i <= nums[state.index]; i++) {
//                    int next = state.index + i;
//
//                    if (!visited.contains(next)) {
//                        queue.add(new State(next, state.jumps + 1));
//                    }
//                }
//            }
//        }
//
//        return -1;
//    }

    public int jump(int[] nums) {
        Integer[] shortest = new Integer[nums.length];
        shortest[0] = 0;
        PriorityQueue<State> queue = new PriorityQueue<>(Comparator.comparingInt(State::jumps));
        queue.add(new State(0, 0));
        int destination = nums.length - 1;

        while (!queue.isEmpty()) {
            State state = queue.poll();

            if (shortest[state.index] == null || shortest[state.index] == state.jumps) {
                for (int i = 1; state.index + i < nums.length && i <= nums[state.index]; i++) {
                    int next = state.index + i;

                    if (shortest[next] == null || shortest[next] > state.jumps + 1) {
                        shortest[next] = state.jumps + 1;
                        queue.add(new State(next, state.jumps + 1));
                    }
                }
            }
        }

        return shortest[destination];
    }
}
