package com.ruchij;

import java.util.*;

public class WordSearchTwo {
    static final class Trie {
        private String value;
        private Map<Character, Trie> children;

        Trie(String value, Map<Character, Trie> children) {
            this.value = value;
            this.children = children;
        }
    }

    record Cell(int x, int y) {
    }

    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> result = new HashSet<>();
        Trie root = build(words);

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                explore(board, new Cell(x, y), root, result);
            }
        }

        return result.stream().toList();
    }

    private Trie build(String[] words) {
        Trie root = new Trie(null, new HashMap<>());

        for (String word : words) {
            Trie current = root;

            for (char character : word.toCharArray()) {
                Trie next = current.children.getOrDefault(character, new Trie(null, new HashMap<>()));
                current.children.put(character, next);
                current = next;
            }

            current.value = word;
        }

        return root;
    }

    private void explore(char[][] board, Cell cell, Trie trie, Set<String> results) {
        char character = board[cell.y][cell.x];

        Trie next = trie.children.get(character);

        if (next != null) {
            if (next.value != null) {
                results.add(next.value);
                next.value = null;
            }

            board[cell.y][cell.x] = '#';

            int[] xDiffs = {0, 0, -1, 1};
            int[] yDiffs = {-1, 1, 0, 0};

            for (int i = 0; i < 4; i++) {
                Cell nextCell = new Cell(cell.x + xDiffs[i], cell.y + yDiffs[i]);

                if (nextCell.y >= 0 && nextCell.y < board.length && nextCell.x >= 0 && nextCell.x < board[nextCell.y].length) {
                    explore(board, nextCell, next, results);
                }
            }

            board[cell.y][cell.x] = character;
        }
    }
}
