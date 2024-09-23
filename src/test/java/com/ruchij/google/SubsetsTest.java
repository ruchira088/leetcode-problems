package com.ruchij.google;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SubsetsTest {
    private static final Subsets subsets = new Subsets();

    @Test
    void verifyResult() {
        List<List<Integer>> result = subsets.subsets(new int[]{1, 2, 3});
        Assertions.assertEquals(8, result.size());

        result = subsets.subsets(new int[]{0});
        Assertions.assertEquals(2, result.size());
    }

}