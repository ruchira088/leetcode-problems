package com.ruchij.google;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MinimumAreaRectangleTest {
    private static final MinimumAreaRectangle solution = new MinimumAreaRectangle();

    record Entry(int value, String random) {
        public Entry(int value) {
            this(value, UUID.randomUUID().toString());
        }
    }

    @Test
    void verifyResult() {
        Comparator<Entry> compareValue = Comparator.comparing(entry -> entry.value);
        Comparator<Entry> compareRandom = Comparator.comparing(entry -> entry.random);

        TreeSet<Entry> integers = new TreeSet<>(compareValue.thenComparing(compareRandom));

        integers.add(new Entry(1));
        integers.add(new Entry(2));
        integers.add(new Entry(1));
        integers.add(new Entry(4));
        integers.add(new Entry(0));


        integers.tailSet(new Entry(1, "")).forEach(entry -> {
            System.out.println(entry.value);
        });

        assertEquals(4, solution.minAreaRect(new int[][]{new int[] {1, 1}, new int[] {1, 3}, new int[] {3, 1}, new int[] {3, 3}, new int[] {2, 2}}));
        assertEquals(2, solution.minAreaRect(new int[][]{new int[] {1, 1}, new int[] {1, 3}, new int[] {3, 1}, new int[] {3, 3}, new int[] {4, 1}, new int[] {4, 3}}));
    }

}