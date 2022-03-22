package com.ruchij;

import java.util.*;

public class ShortestPathWithObstacleElimination {
    record Coordinate(int x, int y) {}
    record State(Coordinate coordinate, int obstaclesRemoved, int moves) {}

    public int shortestPath(int[][] grid, int k) {
        Coordinate target = new Coordinate(grid[grid.length - 1].length - 1, grid.length - 1);
        ArrayDeque<State> queue = new ArrayDeque<>();
        queue.add(new State(new Coordinate(0, 0), 0, 0));
        Map<Coordinate, Integer[]> minMoves = new HashMap<>();

        while (!queue.isEmpty()) {
            State state = queue.pop();

            if (state.coordinate.equals(target)) {
                return state.moves;
            } else if (isApplicable(state, minMoves, k)) {
                int[][] diffs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

                for (int[] diff : diffs) {
                    Coordinate coordinate = new Coordinate(state.coordinate.x + diff[0], state.coordinate.y + diff[1]);

                    if (coordinate.y >= 0 && coordinate.y < grid.length && coordinate.x >= 0 && coordinate.x < grid[coordinate.y].length) {
                        int cell = grid[coordinate.y][coordinate.x];

                        if (cell == 0) {
                            queue.add(new State(coordinate, state.obstaclesRemoved, state.moves + 1));
                        } else if (state.obstaclesRemoved < k) {
                            queue.add(new State(coordinate, state.obstaclesRemoved + 1, state.moves + 1));
                        }
                    }
                }
            }
        }

        return -1;
    }

    private boolean isApplicable(State state, Map<Coordinate, Integer[]> minMoves, int max) {
        Integer[] minDistances = minMoves.computeIfAbsent(state.coordinate, x -> new Integer[max + 1]);
        int current = state.obstaclesRemoved;

        while (current >= 0) {
            Integer minDistance = minDistances[current];

            if (minDistance != null) {
                if (minDistance < state.moves || current < state.moves && minDistance == state.moves) {
                    return false;
                } else {
                    minDistances[state.obstaclesRemoved] = state.moves;
                    return true;
                }
            } else {
                current--;
            }
        }

        minDistances[state.obstaclesRemoved] = state.moves;

        return true;
    }
}
