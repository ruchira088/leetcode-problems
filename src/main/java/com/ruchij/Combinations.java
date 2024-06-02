package com.ruchij;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        return combine(n, k, new ArrayList<>(List.of(new ArrayList<>())), new ArrayList<>());
    }

    private List<List<Integer>> combine(int n, int k, List<List<Integer>> current, List<List<Integer>> results) {
        if (n == 0) {
            return results;
        } else {
            List<List<Integer>> newValues = new ArrayList<>(current);

            for (List<Integer> value : current) {
                ArrayList<Integer> integers = new ArrayList<>(value);
                integers.add(n);

                if (integers.size() == k) {
                    results.add(integers);
                } else {
                    newValues.add(integers);
                }
            }

            return combine(n - 1, k, newValues, results);
        }
    }
}
