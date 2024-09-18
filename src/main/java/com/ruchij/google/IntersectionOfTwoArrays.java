package com.ruchij.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> integers = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();

        for (int i : nums1) {
            integers.add(i);
        }

        for (int i : nums2) {
            if (integers.contains(i)) {
                intersection.add(i);
            }
        }

        return intersection.stream().mapToInt(value -> value).toArray();
    }
}
