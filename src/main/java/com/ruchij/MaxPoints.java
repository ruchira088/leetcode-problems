package com.ruchij;

import java.util.*;

public class MaxPoints {
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

    static final class State {
        private final Coordinate coordinate;
        private final int points;

        State(Coordinate coordinate, int points) {
            this.coordinate = coordinate;
            this.points = points;
        }

        public Coordinate coordinate() {
            return coordinate;
        }

        public int points() {
            return points;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (State) obj;
            return Objects.equals(this.coordinate, that.coordinate) &&
                    this.points == that.points;
        }

        @Override
        public int hashCode() {
            return Objects.hash(coordinate, points);
        }

        @Override
        public String toString() {
            return "State[" +
                    "coordinate=" + coordinate + ", " +
                    "points=" + points + ']';
        }
    }

    public long maxPoints(int[][] points) {
        int result = 0;
        Map<Coordinate, Integer> maxPoints = new HashMap<>();
        Queue<State> queue = new ArrayDeque<>();

        for (int i = 0; i < points[0].length; i++) {
            Coordinate coordinate = new Coordinate(i, 0);
            State state = new State(coordinate, points[coordinate.y][coordinate.x]);
            queue.add(state);
            result = Math.max(result, state.points);
        }

        while (!queue.isEmpty()) {
            State state = queue.poll();
            Integer max = maxPoints.get(state.coordinate);

            if (state.coordinate.y + 1 < points.length && (max == null || max == state.points)) {
                for (int i = 0; i < points[state.coordinate.y + 1].length; i++) {
                    Coordinate coordinate = new Coordinate(i,state.coordinate.y + 1);
                    State newState = new State(coordinate, state.points + points[coordinate.y][coordinate.x] - Math.abs(coordinate.x - state.coordinate.x));

                    Integer existingMax = maxPoints.get(coordinate);

                    if (existingMax == null || existingMax < newState.points) {
                        queue.add(newState);
                        maxPoints.put(newState.coordinate, newState.points);

                        result = Math.max(result, newState.points);
                    }
                }
            }
        }

        return result;
    }
}
