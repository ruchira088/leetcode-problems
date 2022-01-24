package com.ruchij;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

public class FindOriginalArray {
    public int[] findOriginalArray(int[] changed) {
        Integer[] sorted = Arrays.stream(changed).sorted().boxed().toArray(Integer[]::new);
        LinkedList<Integer> result = new LinkedList<>();

        for (int i = 0; i < sorted.length; i++) {
            Integer value = sorted[i];
            sorted[i] = null;

            if (value != null) {
                Integer matchingIndex = findIndex(value * 2, sorted);

                if (matchingIndex == null) {
                    return new int[0];
                } else {
                    sorted[matchingIndex] = null;
                    result.add(value);
                }
            }
        }

        return result.stream().mapToInt(x -> x).toArray();
    }

    private Integer findIndex(Integer value, Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            Integer current = array[i];

            if (Objects.equals(current, value)) {
                return i;
            }
        }

        return null;
    }
}
