package com.ruchij;

import org.junit.jupiter.api.Test;

import java.util.List;

class FourSum2Test {

    @Test
    void returnsExpectedResult() {
        FourSum2 fourSum2 = new FourSum2();
        List<List<Integer>> resultOne = fourSum2.fourSum(numbers(List.of(1, 0, -1, 0, -2, 2)), 0);

        System.out.println(resultOne);

        List<List<Integer>> resultTwo =
                fourSum2.fourSum(numbers(List.of(2,2,2,2,2)), 8);

        System.out.println(resultTwo);
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