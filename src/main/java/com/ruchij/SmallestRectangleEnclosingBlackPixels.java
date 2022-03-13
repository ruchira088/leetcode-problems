package com.ruchij;

import java.util.ArrayDeque;
import java.util.HashSet;

public class SmallestRectangleEnclosingBlackPixels {
    record Coordinate(int x, int y) {
    }

    public int minArea(char[][] image, int x, int y) {
        Coordinate start = new Coordinate(y, x);

        HashSet<Coordinate> visited = new HashSet<>();
        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.pop();

            if (!visited.contains(coordinate)) {
                visited.add(coordinate);

                int[][] diffs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

                for (int[] diff : diffs) {
                    Coordinate neighbour = new Coordinate(coordinate.x + diff[0], coordinate.y + diff[1]);

                    if (neighbour.y >= 0 && neighbour.y < image.length && neighbour.x >= 0 && neighbour.x < image[neighbour.y].length) {
                        char pixel = image[neighbour.y][neighbour.x];

                        if (pixel == '1' && !visited.contains(neighbour)) {
                            queue.add(neighbour);
                        }
                    }
                }
            }
        }

        int[] xs = visited.stream().mapToInt(Coordinate::x).sorted().toArray();
        int xMin = xs[0];
        int xMax = xs[xs.length - 1];

        int[] ys = visited.stream().mapToInt(Coordinate::y).sorted().toArray();
        int yMin = ys[0];
        int yMax = ys[ys.length - 1];

        return (xMax - xMin + 1) * (yMax - yMin + 1);
    }
}
