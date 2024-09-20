package com.ruchij.google;

import java.util.*;

public class MinimumPathSum {
    record Coordinate(int x, int y) {}
    record Position(int cost, Coordinate coordinate) {}

    public int minPathSum(int[][] grid) {
        PriorityQueue<Position> positions = new PriorityQueue<>(Comparator.comparing(position -> position.cost));
        Set<Coordinate> visited = new HashSet<>();
        Coordinate destination = new Coordinate(grid[0].length - 1, grid.length - 1);

        positions.add(new Position(grid[0][0], new Coordinate(0, 0)));

        while (!positions.isEmpty()) {
            Position position = positions.poll();
            Coordinate coordinate = position.coordinate;

            if (coordinate.equals(destination)) {
                return position.cost;
            }

            if (!visited.contains(coordinate)) {
                visited.add(coordinate);

                Coordinate down = new Coordinate(coordinate.x, coordinate.y + 1);
                Coordinate right = new Coordinate(coordinate.x + 1, coordinate.y);

                for (Coordinate current : List.of(down, right)) {
                    if (current.x < grid[0].length && current.y < grid.length) {
                        int cost = grid[current.y][current.x];
                        positions.add(new Position(position.cost + cost, current));
                    }
                }
            }
        }

        return -1;
    }
}
