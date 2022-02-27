package com.ruchij;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class RandomPickWithWeightTest {
    @Test
    void testOne() {
        int[] input = {1, 2, 1, 5, 1};
        HashMap<Integer, Integer> result = new HashMap<>();

        RandomPickWithWeight.Solution solution = new RandomPickWithWeight.Solution(input);

        for (int i = 0; i < 1000_000; i++) {
            int index = solution.pickIndex();
            result.put(index, result.getOrDefault(index, 0) + 1);
        }

        System.out.println(result);
    }

}