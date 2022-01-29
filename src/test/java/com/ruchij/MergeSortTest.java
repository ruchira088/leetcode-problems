package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;

class MergeSortTest {
    private final MergeSort mergeSort = new MergeSort();

    @Test
    void testOne() {
        int[] arrayOne = {1, 3, 5};
        int[] arrayTwo = {2, 4, 6};

        int[] expected = {1, 2, 3, 4, 5, 6};

        int[] result = mergeSort.merge(arrayOne, arrayTwo);

        Assertions.assertArrayEquals(expected, result);

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet();

        linkedHashSet.add(3);
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        linkedHashSet.remove(3);
        linkedHashSet.add(3);

        for (Integer integer: linkedHashSet) {
            System.out.println(integer);
        }

    }
}