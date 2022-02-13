package com.ruchij;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestIncreasingPath {
    record Coordinate(int x, int y) {
    }

    public int longestIncreasingPath(int[][] matrix) {
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int current = findLongest(new Coordinate(j, i), matrix, cache);

                if (current > max) {
                    max = current;
                }

            }
        }

        return max;
    }

    private int findLongest(Coordinate coordinate, int[][] matrix, int[][] cache) {
        int distance = cache[coordinate.y][coordinate.x];

        if (distance == 0) {
            int cellValue = matrix[coordinate.y][coordinate.x];
            int max = 1;

            List<Coordinate> neighbours = Stream.of(
                            new Coordinate(coordinate.x, coordinate.y + 1),
                            new Coordinate(coordinate.x, coordinate.y - 1),
                            new Coordinate(coordinate.x + 1, coordinate.y),
                            new Coordinate(coordinate.x - 1, coordinate.y)
                    )
                    .filter(value -> value.x >= 0 && value.x < matrix[0].length && value.y >= 0 && value.y < matrix.length)
                    .collect(Collectors.toList());

            for (Coordinate neighbour : neighbours) {
                int neighbourCell = matrix[neighbour.y][neighbour.x];

                if (neighbourCell > cellValue) {
                    int neighbourLongest = findLongest(neighbour, matrix, cache);

                    if (neighbourLongest + 1 > max) {
                        max = neighbourLongest + 1;
                    }

                }
            }

            cache[coordinate.y][coordinate.x] = max;

            return max;
        } else {
            return distance;
        }
    }

}
