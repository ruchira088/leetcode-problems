package com.ruchij;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    record Entry(List<Integer> integers, int size) {}

    public List<List<Integer>> combine(int n, int k) {
        return combine(n, k, new ArrayList<>(List.of(new Entry(new ArrayList<>(), 0))), new ArrayList<>());
    }

    private List<List<Integer>> combine(int n, int k, List<Entry> current, List<List<Integer>> results) {
        if (n == 0) {
            return results;
        } else {
            List<Entry> newValues = new ArrayList<>(current);

            for (Entry entry : current) {
                ArrayList<Integer> integers = new ArrayList<>(entry.integers);
                integers.add(n);

                if (entry.size + 1 == k) {
                    results.add(integers);
                } else {
                    newValues.add(new Entry(integers, entry.size + 1));
                }
            }

            return combine(n - 1, k, newValues, results);
        }
    }
}
