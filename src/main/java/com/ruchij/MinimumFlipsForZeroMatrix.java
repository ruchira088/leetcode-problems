package com.ruchij;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class MinimumFlipsForZeroMatrix {
    record Coordinate(int x, int y) {}
    record State(int flips, int[][] matrix, Coordinate lastFlip) {}

    public int minFlips(int[][] mat) {
        ArrayDeque<State> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.add(new State(0, mat, new Coordinate(-1, -1)));

        int limit = mat.length * mat[0].length;

        while (!queue.isEmpty()) {
            State state = queue.pop();

            if (isZeroMatrix(state.matrix)) {
                return state.flips;
            }

            String summary = summarize(state.matrix);

            if (state.flips <= limit && !visited.contains(summary)) {
                visited.add(summary);

                for (int y = 0; y < state.matrix.length; y++) {
                    for (int x = 0; x < state.matrix[y].length; x++) {
                        Coordinate flipped = new Coordinate(x, y);

                        if (flipped != state.lastFlip) {
                            queue.add(
                                    new State(state.flips + 1, flip(state.matrix, flipped), flipped)
                            );
                        }
                    }
                }
            }
        }

        return -1;
    }

    void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int j = 0; j < matrix[i].length; j++) {
                stringBuilder.append(matrix[i][j]);
            }

            System.out.println(stringBuilder);
        }

        System.out.println();
    }

    int[][] flip(int[][] matrix, Coordinate coordinate) {
        int[][] updated = new int[matrix.length][matrix.length == 0 ? 0 : matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, updated[i], 0, matrix[i].length);
        }

        int[] xs = {0, 0, -1, 1};
        int[] ys = {1, -1, 0, 0};

        for (int i = 0; i < xs.length; i++) {
            Coordinate neighbour = new Coordinate(coordinate.x + xs[i], coordinate.y + ys[i]);

            if (neighbour.y >= 0 && neighbour.y < updated.length && neighbour.x >= 0 && neighbour.x < updated[neighbour.y].length) {
                updated[neighbour.y][neighbour.x] = updated[neighbour.y][neighbour.x] == 0 ? 1 : 0;
            }
        }

        updated[coordinate.y][coordinate.x] = updated[coordinate.y][coordinate.x] == 0 ? 1 : 0;

        return updated;
    }

    String summarize(int[][] matrix) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                stringBuilder.append(matrix[y][x]);
            }
        }

        return stringBuilder.toString();
    }

    boolean isZeroMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
