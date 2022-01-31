package com.ruchij;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class NumberOfIslands {
    record Coordinate(int x, int y) {}

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
