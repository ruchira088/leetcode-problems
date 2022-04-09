package com.ruchij;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class WetTiles {
    record Coordinate(int x, int y) {
    }

    record State(Coordinate start, Coordinate current, Set<Coordinate> visited) {
    }

    public Set<Coordinate> countWetTiles(int[][] grid) {
        ArrayDeque<State> arrayDeque = new ArrayDeque<>();
        Set<Coordinate> wetTiles = new HashSet<>();

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                Coordinate coordinate = new Coordinate(x, y);
                wetTiles.add(coordinate);
                arrayDeque.add(new State(coordinate, coordinate, new HashSet<>()));
            }
        }

        while (!arrayDeque.isEmpty()) {
            State state = arrayDeque.pop();

            if (doWaterRollOff(state.current, grid)) {
                wetTiles.remove(state.start);
            } else if (wetTiles.contains(state.current)) {
                int[][] offsets = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

                for (int[] offset : offsets) {
                    Coordinate neighbour = new Coordinate(state.current.x + offset[0], state.current.y + offset[1]);

                    if (isInRange(neighbour, grid) && grid[state.current.y][state.current.x] >= grid[neighbour.y][neighbour.x] && !state.visited.contains(neighbour)) {
                        HashSet<Coordinate> visited = new HashSet<>(state.visited);
                        visited.add(state.current);

                        arrayDeque.add(new State(state.start, neighbour, visited));
                    }
                }

            } else {
                wetTiles.remove(state.start);
            }
        }

        return wetTiles;
    }

    private boolean isInRange(Coordinate coordinate, int[][] grid) {
        return coordinate.y >= 0 && coordinate.y < grid.length && coordinate.x >= 0 && coordinate.x < grid[coordinate.y].length;
    }

    private boolean doWaterRollOff(Coordinate tile, int[][] grid) {
        return grid[tile.y][tile.x] >= 0 && (tile.y == 0 || tile.y == grid.length - 1 || tile.x == 0 || tile.x == grid[tile.y].length - 1);
    }
}
