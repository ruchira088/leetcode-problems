package com.ruchij;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int[] result = new int[nums.length - k + 1];
//        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
//
//        int size = 0;
//        int index = 0;
//
//        for (int number : nums) {
//            max.add(number);
//            size++;
//
//            if (size >= k) {
//                Integer peek = max.peek();
//                result[index] = peek;
//                max.remove(nums[index]);
//                index++;
//            }
//        }
//
//        return result;
//    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && queue.peek() <= i - k) {
                queue.poll();
            }

            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.removeLast();
            }

            queue.add(i);

            if (i >= k - 1) {
                result[index] = nums[queue.peek()];
                index++;
            }
        }

        return result;
    }
}
