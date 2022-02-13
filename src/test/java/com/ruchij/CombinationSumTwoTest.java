package com.ruchij;

import org.junit.jupiter.api.Test;

import java.util.List;

class CombinationSumTwoTest {
    private final CombinationSumTwo combinationSumTwo = new CombinationSumTwo();

    @Test
    void testOne() {
        int[] data = {10,1,2,7,6,1,5};
        List<List<Integer>> result = combinationSumTwo.combinationSum2(data, 8);
        System.out.println(result);
    }

}