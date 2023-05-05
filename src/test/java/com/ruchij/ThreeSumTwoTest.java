package com.ruchij;

import org.junit.jupiter.api.Test;

import java.util.List;

class ThreeSumTwoTest {
    @Test
    void shouldReturnExpectedResult() {
        ThreeSumTwo threeSumTwo = new ThreeSumTwo();
        List<List<Integer>> resultOne = threeSumTwo.threeSum(numbers(List.of(-1,0,1,2,-1,-4)));

        System.out.println(resultOne);

        List<List<Integer>> resultTwo =
                threeSumTwo.threeSum(numbers(List.of(0,1,1)));

        System.out.println(resultTwo);

        List<List<Integer>> resultThree =
                threeSumTwo.threeSum(numbers(List.of(0,0, 0)));

        System.out.println(resultThree);
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