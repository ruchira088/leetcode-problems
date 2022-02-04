package com.ruchij;

import java.util.*;

public class DetectSquares {
    record Coordinate(int x, int y) {}

    private final Map<Coordinate, Integer> count;
    private final Map<Integer, List<Integer>> xAxis;
    private final Map<Integer, List<Integer>> yAxis;

    public DetectSquares() {
        this.count = new HashMap<>();
        this.xAxis = new HashMap<>();
        this.yAxis = new HashMap<>();
    }

    public void add(int[] point) {
        Coordinate coordinate = new Coordinate(point[0], point[1]);

        List<Integer> ys = xAxis.getOrDefault(coordinate.x, new LinkedList<>());
        ys.add(coordinate.y);
        xAxis.put(coordinate.x, ys);

        List<Integer> xs = yAxis.getOrDefault(coordinate.y, new LinkedList<>());
        xs.add(coordinate.x);
        yAxis.put(coordinate.y, xs);

        count.put(coordinate, count.getOrDefault(coordinate, 0) + 1);
    }

    public int count(int[] point) {
        Coordinate coordinate = new Coordinate(point[0], point[1]);

        List<Integer> ys = xAxis.getOrDefault(coordinate.x, new LinkedList<>());
        List<Integer> xs = yAxis.getOrDefault(coordinate.y, new LinkedList<>());

        long doubleCount =
                ys.stream().mapToInt(y -> hasSquare(coordinate, new Coordinate(coordinate.x, y), this.count)).sum() +
                    xs.stream().mapToInt(x -> hasSquare(coordinate, new Coordinate(x, coordinate.y), this.count)).sum();

        return (int) doubleCount / 2;
    }

    private int hasSquare(Coordinate base, Coordinate other, Map<Coordinate, Integer> count) {
        if (base.x == other.x && base.y == other.y) {
            return 0;
        } else if (base.x == other.x) {
            int length = base.y - other.y;

            return (count.getOrDefault(new Coordinate(base.x - length, base.y), 0) * count.getOrDefault(new Coordinate(other.x - length, other.y), 0)) +
                    (count.getOrDefault(new Coordinate(base.x + length, base.y), 0) * count.getOrDefault(new Coordinate(other.x + length, other.y), 0));

        } else if (base.y == other.y) {
            int length = base.x - other.x;

            return (count.getOrDefault(new Coordinate(base.x, base.y - length), 0) * count.getOrDefault(new Coordinate(other.x, other.y - length), 0)) +
                    (count.getOrDefault(new Coordinate(base.x, base.y + length), 0) * count.getOrDefault(new Coordinate(other.x, other.y + length), 0));
        } else {
            return 0;
        }
    }
}