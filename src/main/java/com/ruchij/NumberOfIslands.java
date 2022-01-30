package com.ruchij;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class NumberOfIslands {
    static final class Coordinate {
        private final int x;
        private final int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x() {
            return x;
        }

        public int y() {
            return y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (Coordinate) obj;
            return this.x == that.x &&
                    this.y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Coordinate[" +
                    "x=" + x + ", " +
                    "y=" + y + ']';
        }

    }

    public int numIslands(char[][] grid) {
        Set<Coordinate> checked = new HashSet<>();
        Set<Set<Coordinate>> islands = new HashSet<>();

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                Coordinate position = new Coordinate(x, y);
                char value = grid[y][x];

                if (!checked.contains(position)) {
                    if (value == '1') {
                        Set<Coordinate> island = new HashSet<>();
                        navigateIsland(position, grid, island);

                        islands.add(island);
                        checked.addAll(island);
                    }
                }
            }
        }

        return islands.size();
    }

    private void navigateIsland(Coordinate position, char[][] grid, Set<Coordinate> island) {
        island.add(position);

        Stream.of(
                        new Coordinate(position.x, position.y + 1),
                        new Coordinate(position.x, position.y - 1),
                        new Coordinate(position.x + 1, position.y),
                        new Coordinate(position.x - 1, position.y)
                )
                .filter(coordinate ->
                        coordinate.x < grid[0].length && coordinate.x >= 0 &&
                                coordinate.y < grid.length && coordinate.y >= 0 &&
                                !island.contains(coordinate) &&
                                grid[coordinate.y][coordinate.x] == '1'
                )
                .forEach(coordinate -> navigateIsland(coordinate, grid, island));

    }
}
