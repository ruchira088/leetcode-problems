package com.ruchij;

import java.util.*;
import java.util.stream.Stream;

public class MinimumPathSum {
    record Coordinate(int x, int y) {
    }

    record State(Coordinate position, int sum) {
    }

    public int minPathSum(int[][] grid) {
        Set<Coordinate> visited = new HashSet<>();
        PriorityQueue<State> queue = new PriorityQueue<>(Comparator.comparingInt(State::sum));
        Coordinate start = new Coordinate(0, 0);
        Coordinate destination = new Coordinate(grid[0].length - 1, grid.length - 1);
        queue.add(new State(start, grid[start.y][start.x]));

        while (!queue.isEmpty()) {
            State state = queue.poll();
            Coordinate position = state.position;
            visited.add(position);

            if (position.equals(destination)) {
                return state.sum;
            }

            Stream.of(
                    new Coordinate(position.x, position.y + 1),
                    new Coordinate(position.x + 1, position.y)
            ).filter(coordinate ->
                    coordinate.x >= 0 && coordinate.x < grid[0].length &&
                            coordinate.y >= 0 && coordinate.y < grid.length && !visited.contains(coordinate)
            ).forEachOrdered(coordinate -> queue.add(new State(coordinate, state.sum + grid[coordinate.y][coordinate.x])));
        }

        return -1;
    }

//    public int minPathSum(int[][] grid) {
//        ArrayDeque<State> queue = new ArrayDeque<>();
//        Integer[][] shortestPaths = new Integer[grid.length][grid[0].length];
//
//        Coordinate startIndex = new Coordinate(0, 0);
//        Coordinate destination = new Coordinate(grid[0].length - 1, grid.length - 1);
//
//        shortestPaths[0][0] = grid[startIndex.y][startIndex.x];
//        queue.add(new State(startIndex, grid[startIndex.y][startIndex.x]));
//
//        while (!queue.isEmpty()) {
//            State state = queue.poll();
//            Coordinate coordinate = state.coordinate;
//
//            if (shortestPaths[coordinate.y][coordinate.x] == null || shortestPaths[coordinate.y][coordinate.x] == state.sum) {
//                Stream.of(
//                        new Coordinate(coordinate.x, coordinate.y + 1),
//                        new Coordinate(coordinate.x + 1, coordinate.y)
//                ).filter(coordinate ->
//                        coordinate.x >= 0 && coordinate.x < grid[0].length &&
//                                coordinate.y >= 0 && coordinate.y < grid.length
//                ).forEachOrdered(coordinate -> {
//                    int sum = state.sum + grid[coordinate.y][coordinate.x];
//
//                    if (shortestPaths[coordinate.y][coordinate.x] == null || shortestPaths[coordinate.y][coordinate.x] > sum) {
//                        shortestPaths[coordinate.y][coordinate.x] = sum;
//                        queue.add(new State(coordinate, sum));
//                    }
//                });
//            }
//
//        }
//
//        return shortestPaths[destination.y][destination.x];
//    }
}
