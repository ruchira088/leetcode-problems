package com.ruchij;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int number : arr) {
            count.put(number, count.getOrDefault(number, 0) + 1);
        }

        Set<Integer> seen = new HashSet<>();

        for (Integer integer : count.values()) {
            if (seen.contains(integer)) {
                return false;
            } else {
                seen.add(integer);
            }
        }

        return true;
    }
}
