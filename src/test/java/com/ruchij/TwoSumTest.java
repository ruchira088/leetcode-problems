package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoSumTest {
    @Test
    void shouldReturnExpectedResult() {
        TwoSum twoSum = new TwoSum();

        Assertions.assertEquals(
                Set.of(0, 1),
                integerSet(twoSum.twoSum(numbers(List.of(2, 7, 11, 15)), 9))
        );

        Assertions.assertEquals(
                Set.of(1, 2),
                integerSet(twoSum.twoSum(numbers(List.of(3, 2, 4)), 6))
        );

        Assertions.assertEquals(
                Set.of(0, 1),
                integerSet(twoSum.twoSum(numbers(List.of(3, 3)), 6))
        );
    }

    Set<Integer> integerSet(int[] numbers) {
        return IntStream.of(numbers).boxed().collect(Collectors.toSet());
    }

    int[] numbers(List<Integer> numbers) {
        int size = numbers.size();
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = numbers.get(i);
        }

        return result;
    }
}
