package com.ruchij;

import java.util.*;
import java.util.stream.Stream;

public class WordSearch {
    record Coordinate(int x, int y) {}
    record State(Coordinate position, String word, Set<Coordinate> visited) {}

    public boolean exist(char[][] board, String word) {
        if (canExist(board, word)) {
            for (int y = 0; y < board.length; y++) {
                for (int x = 0; x < board[y].length; x++) {
                    if (check(new Coordinate(x, y), board, word)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean canExist(char[][] board, String word) {
        Map<Character, Integer> boardSummary = new HashMap<>();
        Map<Character, Integer> wordSummary = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boardSummary.put(board[i][j], boardSummary.getOrDefault(board[i][j], 0) + 1);
            }
        }

        for (char character : word.toCharArray()) {
            wordSummary.put(character, wordSummary.getOrDefault(character, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : wordSummary.entrySet()) {
            Character character = entry.getKey();

            Integer value = boardSummary.get(character);

            if (value == null || value < entry.getValue()) {
                return false;
            }
        }

        return true;
    }

    private boolean check(Coordinate position, char[][] board, String word) {
        ArrayDeque<State> queue = new ArrayDeque<>();
        queue.add(new State(position, word, new HashSet<>()));

        while (!queue.isEmpty()) {
            State state = queue.poll();

            if (state.word.isEmpty()) {
                return true;
            } else {

                char head = state.word.charAt(0);
                String rest = state.word.substring(1);

                if (head == board[state.position.y][state.position.x]) {
                    Set<Coordinate> visited = new HashSet<>(state.visited);
                    visited.add(state.position);

                    if (rest.isEmpty()) {
                        return true;
                    }

                    Stream.of(
                            new Coordinate(state.position.x, state.position.y + 1),
                            new Coordinate(state.position.x, state.position.y - 1),
                            new Coordinate(state.position.x - 1, state.position.y),
                            new Coordinate(state.position.x + 1, state.position.y)
                    ).filter(coordinate ->
                            coordinate.y >= 0 &&
                                    coordinate.y < board.length &&
                                    coordinate.x >= 0 &&
                                    coordinate.x < board[coordinate.y].length &&
                                    !state.visited.contains(coordinate)
                        ).forEach(coordinate -> queue.add(new State(coordinate, rest, visited)));
                }
            }
        }

        return false;
    }
}
