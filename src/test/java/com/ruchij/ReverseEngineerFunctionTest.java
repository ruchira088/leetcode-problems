package com.ruchij;

import org.junit.jupiter.api.Test;

import java.util.List;

class ReverseEngineerFunctionTest {
    private final ReverseEngineerFunction reverseEngineerFunction = new ReverseEngineerFunction();

    @Test
    void testOne() {
        List<List<Integer>> result = reverseEngineerFunction.findSolution(new ReverseEngineerFunction.CustomFunction(), 5);

        System.out.println(result);
    }


}