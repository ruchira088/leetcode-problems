package com.ruchij;

import java.util.ArrayDeque;
import java.util.Objects;

public class ArraySwap {
    static final class State {
        private final int previousOne;
        private final int previousTwo;
        private final int swaps;
        private final int index;

        State(int previousOne, int previousTwo, int swaps, int index) {
            this.previousOne = previousOne;
            this.previousTwo = previousTwo;
            this.swaps = swaps;
            this.index = index;
        }

        public int previousOne() {
            return previousOne;
        }

        public int previousTwo() {
            return previousTwo;
        }

        public int swaps() {
            return swaps;
        }

        public int index() {
            return index;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (State) obj;
            return this.previousOne == that.previousOne &&
                    this.previousTwo == that.previousTwo &&
                    this.swaps == that.swaps &&
                    this.index == that.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(previousOne, previousTwo, swaps, index);
        }

        @Override
        public String toString() {
            return "State[" +
                    "previousOne=" + previousOne + ", " +
                    "previousTwo=" + previousTwo + ", " +
                    "swaps=" + swaps + ", " +
                    "index=" + index + ']';
        }
    }

    public int minSwap(int[] nums1, int[] nums2) {
        ArrayDeque<State> queue = new ArrayDeque<>();
        int min = -1;
        queue.add(new State(nums1[0], nums2[0], 0, 1));

        while (!queue.isEmpty()) {
            State state = queue.pop();

            if (state.index == nums1.length) {
                if (min == -1 || min > state.swaps) {
                    min = state.swaps;
                }
            } else {
                int currentOne = nums1[state.index];
                int currentTwo = nums2[state.index];

                if (state.previousOne >= currentOne || state.previousTwo >= currentTwo) {
                    queue.add(new State(currentTwo, currentOne, state.swaps + 1, state.index + 1));
                }

                if (state.previousOne <= currentOne && state.previousTwo <= currentTwo) {
                    boolean isEqual = state.previousOne == currentOne || state.previousTwo == currentTwo;

                    queue.add(new State(currentOne, currentTwo, state.swaps + (isEqual ? 1 : 0), state.index + 1));
                }
            }
        }

        return min;
    }
}
