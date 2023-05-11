package com.ruchij;

import java.util.*;
import java.util.function.Supplier;

public class ShortestPathWithObstacleEliminationTwo {
    record Coordinate(int x, int y) {}
    record State(Coordinate position, int moves, int remainingRemovals) {}

    public int shortestPath(int[][] grid, int k) {
        int height = grid.length;
        int width = grid[0].length;

        HashMap<Coordinate, Map<Integer, Integer>> visited = new HashMap<>();

        PriorityQueue<State> queue = new PriorityQueue<>(Comparator.comparingInt(State::moves));
        queue.add(new State(new Coordinate(0, 0), 0, k));

        Coordinate destination = new Coordinate(width - 1, height - 1);

        while (!queue.isEmpty()) {
            State state = queue.poll();

            if (state.position.equals(destination)) {
                return state.moves;
            }

            Map<Integer, Integer> moveStates = visited.computeIfAbsent(state.position, __ -> new HashMap<>());

            Supplier<Boolean> isValid = () -> {
                for (int i = k; i >= state.remainingRemovals; i--) {
                    Integer minMoves = moveStates.get(i);

                    if (minMoves != null && minMoves <= state.moves) {
                        return false;
                    }
                }

                return true;
            };

            if (isValid.get()) {
                moveStates.put(state.remainingRemovals, state.moves);
                Coordinate position = state.position;

                Coordinate up = new Coordinate(position.x, position.y - 1);
                Coordinate down = new Coordinate(position.x, position.y + 1);
                Coordinate left = new Coordinate(position.x - 1, position.y);
                Coordinate right = new Coordinate(position.x + 1, position.y);

                for (Coordinate next : Set.of(up, down, left, right)) {
                    if (next.x >= 0 && next.x < width && next.y >= 0 && next.y < height) {
                        boolean isObstacle = grid[next.y][next.x] == 1;

                        if (isObstacle && state.remainingRemovals > 0) {
                            queue.add(new State(next, state.moves + 1, state.remainingRemovals - 1));
                        } else if (!isObstacle) {
                            queue.add(new State(next, state.moves + 1, state.remainingRemovals));
                        }
                    }
                }
            }

        }

        return -1;
    }
}
