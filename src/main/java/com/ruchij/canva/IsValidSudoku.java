package com.ruchij.canva;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!validateColumn(board, i) || !validateRow(board, i)) {
                return false;
            }
        }

        for (int r = 0; r < board.length; r = r + 3) {
            for (int c = 0; c < board[r].length; c = c + 3) {
                if (!validateSubBox(board, r, c)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean validateRow(char[][] board, int row) {
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < board[row].length; i++) {
            char character = board[row][i];

            if (character != '.') {
                Integer value = Integer.valueOf(String.valueOf(character));

                if (seen.contains(value)) {
                    return false;
                }

                seen.add(value);
            }
        }

        return true;
    }

    private boolean validateColumn(char[][] board, int column) {
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            char character = board[i][column];

            if (character != '.') {
                Integer value = Integer.valueOf(String.valueOf(character));

                if (seen.contains(value)) {
                    return false;
                }

                seen.add(value);
            }
        }

        return true;
    }

    private boolean validateSubBox(char[][] board, int row, int column) {
        Set<Integer> seen = new HashSet<>();

        for (int i = row; i < row + 3; i++) {
            for (int j = column; j < column + 3; j++) {
                char character = board[i][j];

                if (character != '.') {
                    Integer value = Integer.valueOf(String.valueOf(character));

                    if (seen.contains(value)) {
                        return false;
                    }

                    seen.add(value);
                }
            }
        }

        return true;
    }
}
