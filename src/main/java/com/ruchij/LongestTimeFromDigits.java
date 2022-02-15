package com.ruchij;

import java.util.*;
import java.util.stream.Collectors;

public class LongestTimeFromDigits {
    public String largestTimeFromDigits(int[] arr) {
        Optional<List<Integer>> result = combination(Arrays.stream(arr).boxed().collect(Collectors.toList())).stream()
                .filter(this::isValid)
                .sorted(
                        Comparator.comparingInt(list -> ((List<Integer>) list).get(0))
                                .thenComparingInt(list -> ((List<Integer>) list).get(1))
                                .thenComparingInt(list -> ((List<Integer>) list).get(2))
                                .thenComparingInt(list -> ((List<Integer>) list).get(3))
                                .reversed()

                ).findFirst();

        return result.map(list -> String.valueOf(list.get(0)) + list.get(1) + ":" + list.get(2) + list.get(3)).orElse("");
    }

    Set<List<Integer>> combination(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            HashSet<List<Integer>> values = new HashSet<>();
            values.add(new ArrayList<>());

            return values;
        } else {
            HashSet<List<Integer>> result = new HashSet<>();

            for (Integer number : numbers) {
                ArrayList<Integer> integers = new ArrayList<>(numbers);
                integers.remove(Integer.valueOf(number));

                for (List<Integer> value : combination(integers)) {
                    value.add(0, number);
                    result.add(value);
                }
            }

            return result;
        }
    }

    private boolean isValid(List<Integer> digits) {
        if (digits.get(0) > 2) {
            return false;
        }

        if (digits.get(0) == 2 && digits.get(1) > 3) {
            return false;
        }

        if (digits.get(2) > 5) {
            return false;
        }

        return true;
    }
}
