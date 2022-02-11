package com.ruchij;

import java.util.*;

public class ArrayDoubledPairs {
    public boolean canReorderDoubled(int[] arr) {
        Integer[] integers = Arrays.stream(arr).boxed().sorted(Comparator.comparingInt(Math::abs)).toArray(Integer[]::new);
        Map<Integer, Integer> integerMap = new HashMap<>();

        for (Integer integer: integers) {
            integerMap.put(integer, integerMap.getOrDefault(integer, 0) + 1);
        }

        for (Integer integer: integers) {
            Integer value = integerMap.getOrDefault(integer, 0);

            if (value > 0) {
                Integer match = integer * 2;
                Integer matchCount = integerMap.getOrDefault(match, 0);

                if (matchCount == 0) {
                    break;
                } else {
                    integerMap.put(integer, value - 1);
                    integerMap.put(match, matchCount - 1);
                }
            }
        }

        return integerMap.values().stream().noneMatch(count -> count > 0);
    }
}
