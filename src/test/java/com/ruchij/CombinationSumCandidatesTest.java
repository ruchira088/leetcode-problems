package com.ruchij;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSumCandidatesTest {
    private final CombinationSumCandidates combinationSumCandidates = new CombinationSumCandidates();

    @Test
    void testOne() {
        int[] input = {2, 3, 6, 7};
        List<List<Integer>> result = combinationSumCandidates.combinationSum(input, 7);
        System.out.println(result);
    }

}