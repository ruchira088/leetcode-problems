package com.ruchij.google;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfIslands {
    record Coordinate(int x, int y) {}

    public int numIslands(char[][] grid) {
        int count = 0;
        Set<Coordinate> visited = new HashSet<>();

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                Coordinate coordinate = new Coordinate(x, y);

                if (!visited.contains(coordinate)) {
                    if (isLand(x, y, grid)) {
                        Set<Coordinate> island = explore(coordinate, grid);
                        count++;
                        visited.addAll(island);
                    }
                }
            }
        }

        return count;
    }

    private Set<Coordinate> explore(Coordinate coordinate, char[][] grid) {
        ArrayDeque<Coordinate> path = new ArrayDeque<>();
        path.add(coordinate);

        Set<Coordinate> visited = new HashSet<>();

        List<Coordinate> moves = List.of(
                new Coordinate(1, 0),
                new Coordinate(-1, 0),
                new Coordinate(0, 1),
                new Coordinate(0, -1)
        );

        while (!path.isEmpty()) {
            Coordinate position = path.poll();

            if (!visited.contains(position)) {
                visited.add(position);

                for (Coordinate move : moves) {
                    Coordinate next = new Coordinate(position.x + move.x, position.y + move.y);

                    if (isLand(next.x, next.y, grid)) {
                        path.add(next);
                    }
                }
            }
        }

        return visited;
    }

    private boolean isLand(int x, int y, char[][] grid) {
        return y >=0 && y < grid.length && x >= 0 && x < grid[y].length && grid[y][x] == '1';
    }
}
