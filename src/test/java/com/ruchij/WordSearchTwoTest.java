package com.ruchij;

import org.junit.jupiter.api.Test;

class WordSearchTwoTest {
    private final WordSearchTwo wordSearchTwo = new WordSearchTwo();

    @Test
    void testOne() {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};

        System.out.println(wordSearchTwo.findWords(board, words));
    }

    @Test
    void testTwo() {
        char[][] board = {{'o', 'a', 'b', 'n'}, {'o', 't', 'a', 'e'}, {'a', 'h', 'k', 'r'}, {'a', 'f', 'l', 'v'}};
        String[] words = {"oa", "oaa"};

        System.out.println(wordSearchTwo.findWords(board, words));
    }

    @Test
    void testThree() {
        char[][] board = {{'o'}};
        String[] words = {"o"};

        System.out.println(wordSearchTwo.findWords(board, words));
    }

}