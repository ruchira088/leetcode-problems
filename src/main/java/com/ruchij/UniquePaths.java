package com.ruchij;

import java.util.ArrayDeque;
import java.util.stream.Stream;

public class UniquePaths {
    record Coordinate(int x, int y) {}

    public int uniquePaths(int m, int n) {
        Coordinate start = new Coordinate(0, 0);
        Coordinate destination = new Coordinate(n - 1, m - 1);
        int count = 0;
        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (current.equals(destination)) {
                count++;
            } else {
                Stream.of(new Coordinate(current.x + 1, current.y), new Coordinate(current.x, current.y + 1))
                        .filter(coordinate -> isValid(m, n, coordinate))
                        .forEach(queue::add);
            }
        }

        return count;
    }

    boolean isValid(int m, int n, Coordinate coordinate) {
        return coordinate.x < n && coordinate.y < m;
    }
}
