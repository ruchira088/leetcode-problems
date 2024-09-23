package com.ruchij.google;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> current = new ArrayList<>();

            for (List<Integer> value : list) {
                ArrayList<Integer> integers = new ArrayList<>(value);
                integers.add(num);
                current.add(integers);
            }

            list.addAll(current);
        }

        return list;
    }
}
