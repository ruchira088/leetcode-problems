package com.ruchij;

import org.junit.jupiter.api.Test;

class FindAndReplaceStringTest {
    private final FindAndReplaceString findAndReplaceString = new FindAndReplaceString();

    @Test
    void test() {
        int[] indices = {0, 2};
        String[] sources = {"a", "cd"};
        String[] target = {"eee", "ffff"};

        System.out.println(findAndReplaceString.findReplaceString("abcd", indices, sources, target));
    }
}