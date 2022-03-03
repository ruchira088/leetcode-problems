package com.ruchij;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordSearchTest {
    private final WordSearch wordSearch = new WordSearch();

    @Test
    void testOne() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};

        Assertions.assertTrue(wordSearch.exist(board, "ABCCED"));
    }

    @Test
    void testTwo() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};

        Assertions.assertTrue(wordSearch.exist(board, "SEE"));
    }

    @Test
    void testThree() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};

        Assertions.assertFalse(wordSearch.exist(board, "ABCB"));
    }

    @Test
    void testFour() {
        char[][] board = {{'A'}};

        Assertions.assertTrue(wordSearch.exist(board, "A"));
    }

    @Test
    void testFive() {
        char[][] board = {{'A', 'A', 'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A', 'A', 'A'}};

        Assertions.assertFalse(wordSearch.exist(board, "AAAAAAAAAAAAAAB"));
    }

    @Test
    void testSix() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};

        Assertions.assertTrue(wordSearch.exist(board,  "ABCESEEEFS"));
    }

}