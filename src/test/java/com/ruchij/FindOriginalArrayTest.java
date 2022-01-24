package com.ruchij;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

class FindOriginalArrayTest {
    private final FindOriginalArray findOriginalArray = new FindOriginalArray();

    @Test
    void solve() {
        int[] input = {0};
        int[] result = findOriginalArray.findOriginalArray(input);

        System.out.println(Arrays.stream(result).boxed().collect(Collectors.toList()));
    }

}