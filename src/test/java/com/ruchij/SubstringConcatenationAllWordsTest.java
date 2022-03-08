package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SubstringConcatenationAllWordsTest {
    private SubstringConcatenationAllWords substringConcatenationAllWords = new SubstringConcatenationAllWords();

    @Test
    void testOne() {
        String[] words = {"foo", "bar"};
        Assertions.assertEquals(List.of(0, 9), substringConcatenationAllWords.findSubstring("barfoothefoobarman", words));
    }

    @Test
    void testTwo() {
        String[] words = {"word", "good", "best", "word"};
        Assertions.assertEquals(List.of(), substringConcatenationAllWords.findSubstring("wordgoodgoodgoodbestword", words));
    }

    @Test
    void testThree() {
        String[] words = {"bar", "foo", "the"};
        Assertions.assertEquals(List.of(6, 9, 12), substringConcatenationAllWords.findSubstring("barfoofoobarthefoobarman", words));
    }

    @Test
    void testFour() {
        String[] words = {"fooo", "barr", "wing", "ding", "wing"};
        Assertions.assertEquals(List.of(13), substringConcatenationAllWords.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", words));
    }

    @Test
    void testFive() {
        String[] words = {"aa", "aa"};
        Assertions.assertEquals(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10), substringConcatenationAllWords.findSubstring("aaaaaaaaaaaaaa", words));
    }

}