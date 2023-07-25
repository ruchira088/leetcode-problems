package com.ruchij;

import java.util.ArrayDeque;

public class InplaceMergeSort {
    void sort(int[] numbers) {
        sort(numbers, 0, numbers.length);
    }

    void sort(int[] numbers, int start, int end) {
        if (end - start <= 1) {
            return;
        }

        int mid = (start + end) / 2;
        sort(numbers, start, mid);
        sort(numbers, mid, end);

        merge(numbers, start, mid, end);
    }

    void merge(int[] numbers, int start, int mid, int end) {
        int left = start;
        int right = mid;
        int index = start;

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        while (index < end) {
            int leftValue = queue.isEmpty() ? (left < mid ? numbers[left] : Integer.MAX_VALUE) : queue.peek();

            int rightValue = right < end ? numbers[right] : Integer.MAX_VALUE;

            if (leftValue <= rightValue) {
                if (!queue.isEmpty()) {
                    queue.poll();

                    if (index < mid) {
                        queue.add(numbers[index]);
                    }
                }

                numbers[index] = leftValue;

                left++;
            } else {
                if (index < mid) {
                    queue.add(numbers[index]);
                }

                numbers[index] = rightValue;
                right++;
            }

            index++;
        }
    }
}
