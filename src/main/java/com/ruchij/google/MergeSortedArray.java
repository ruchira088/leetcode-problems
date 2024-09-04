package com.ruchij.google;

import java.util.ArrayDeque;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayDeque<Integer> listOne = new ArrayDeque<>(m);

        for (int i = 0; i < m; i++) {
            listOne.add(nums1[i]);
        }

        ArrayDeque<Integer> listTwo = new ArrayDeque<>(n);

        for (int i : nums2) {
            listTwo.add(i);
        }

        int i = 0;

        while (!listOne.isEmpty() || !listTwo.isEmpty()) {
            if (listOne.isEmpty()) {
                nums1[i] = listTwo.poll();
            } else if (listTwo.isEmpty()) {
                nums1[i] = listOne.poll();
            } else if (listOne.peek() < listTwo.peek()) {
                nums1[i] = listOne.poll();
            } else {
                nums1[i] = listTwo.poll();
            }

            i++;
        }
    }
}
