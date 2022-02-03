package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestWordChainTest {
    private final LongestWordChain longestWordChain = new LongestWordChain();

    @Test
    void testOne() {
        Assertions.assertTrue(longestWordChain.isChain("cats", "crats"));
        Assertions.assertTrue(longestWordChain.isChain("dog", "dogs"));
    }

    @Test
    void testTwo() {
        Assertions.assertEquals(4, longestWordChain.longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
    }

    @Test
    void testThree() {
        Assertions.assertEquals(5, longestWordChain.longestStrChain(new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"}));
    }

    @Test
    void testFour() {
        Assertions.assertEquals(1, longestWordChain.longestStrChain(new String[]{"abcd","dbqca"}));
    }

}