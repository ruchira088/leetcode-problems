package com.ruchij;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArraySwap {
    static final class State {
        private final List<Integer> swaps;
        private final int swapCount;

        State(List<Integer> swaps, int swapCount) {
            this.swaps = swaps;
            this.swapCount = swapCount;
        }

        public List<Integer> swaps() {
            return swaps;
        }

        public int swapCount() {
            return swapCount;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (State) obj;
            return Objects.equals(this.swaps, that.swaps) &&
                    this.swapCount == that.swapCount;
        }

        @Override
        public int hashCode() {
            return Objects.hash(swaps, swapCount);
        }

        @Override
        public String toString() {
            return "State[" +
                    "swaps=" + swaps + ", " +
                    "swapCount=" + swapCount + ']';
        }
    }

    public int minSwap(int[] nums1, int[] nums2) {
        ArrayDeque<State> queue = new ArrayDeque<>();
        queue.add(new State(List.of(), 0));
        int size = nums1.length;

        while (!queue.isEmpty()) {
            State state = queue.pop();

            int[] arrayOne = new int[size];
            System.arraycopy(nums1, 0, arrayOne, 0, size);

            int[] arrayTwo = new int[size];
            System.arraycopy(nums2, 0, arrayTwo, 0, size);

            for (Integer swap: state.swaps) {
                int value = arrayOne[swap];
                arrayOne[swap] = arrayTwo[swap];
                arrayTwo[swap] = value;
            }

            if (isSorted(arrayOne) && isSorted(arrayTwo)) {
                return state.swapCount;
            }

            for (int i = 0; i < size; i++) {
                List<Integer> swaps = new ArrayList<>(state.swaps);
                swaps.add(i);

                queue.add(new State(swaps, state.swapCount + 1));
            }
        }

        return -1;
    }

    private boolean isSorted(int[] array) {
        if (array.length != 0) {
            int previous = array[0];

            for (int i = 1; i < array.length; i++) {
                int current = array[i];

               if (current <= previous) {
                    return false;
                } else {
                    previous = current;
                }
            }

        }
        return true;
    }
}
