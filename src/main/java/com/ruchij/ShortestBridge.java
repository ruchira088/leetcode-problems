package com.ruchij;

import java.util.*;

public class ShortestBridge {
    record Coordinate(int x, int y) {}

    public int shortestBridge(int[][] grid) {
        List<Set<Coordinate>> islands = new ArrayList<>();
        Set<Coordinate> allIslandCoordinates = new HashSet<>();

        for (int row = 0; row < grid.length; row++) {
            for (int colum = 0; colum < grid[row].length; colum++) {
                Coordinate coordinate = new Coordinate(colum, row);
                boolean isLand = grid[row][colum] == 1;

                if (isLand && !allIslandCoordinates.contains(coordinate)) {
                    Set<Coordinate> island = island(coordinate, grid);
                    allIslandCoordinates.addAll(island);
                    islands.add(island);
                }
            }
        }

        assert islands.size() == 2;

        return shortestBridge(islands.get(0), islands.get(1));
    }

    int shortestBridge(Set<Coordinate> islandOne, Set<Coordinate> islandTwo) {
        int shortestDistance = Integer.MAX_VALUE;

        for (Coordinate one : islandOne) {
            for (Coordinate two : islandTwo) {
                int distance = Math.abs(one.x - two.x) + Math.abs(one.y - two.y) - 1;

                if (distance < shortestDistance) {
                    shortestDistance = distance;
                }
            }
        }

        return shortestDistance;
    }

    Set<Coordinate> island(Coordinate startingPoint, int[][] grid) {
        int rowCount = grid.length;
        int columnCount = grid[0].length;

        HashSet<Coordinate> island = new HashSet<>();
        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        queue.add(startingPoint);

        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();

            if (!island.contains(coordinate)) {
                island.add(coordinate);

                Coordinate up = new Coordinate(coordinate.x, coordinate.y - 1);
                Coordinate down = new Coordinate(coordinate.x, coordinate.y + 1);
                Coordinate left = new Coordinate(coordinate.x - 1, coordinate.y);
                Coordinate right = new Coordinate(coordinate.x + 1, coordinate.y);

                for (Coordinate neighbour : Set.of(up, down, left, right)) {
                    if (neighbour.x >= 0 && neighbour.x < columnCount && neighbour.y >= 0 && neighbour.y < rowCount) {
                        boolean isLand = grid[neighbour.y][neighbour.x] == 1;

                        if (isLand) {
                            if (!island.contains(neighbour)) {
                                queue.add(neighbour);
                            }
                        }
                    }
                }
            }
        }

        return island;
    }
}
