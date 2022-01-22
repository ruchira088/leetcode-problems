package com.ruchij;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class LowestRisk {
    private record Coordinate(int x, int y) {}
    private record Path(Coordinate current, int distance, Path path) {}

    public void solve(Stream<String> input) {
        Map<Coordinate, Integer> grid = parse(input);
        expand(grid, dimensions(grid), 5);
        Coordinate size = dimensions(grid);

        Queue<Path> paths = new ArrayDeque<>();
        paths.offer(new Path(new Coordinate(0, 0), 0, null));

        Integer shortedPath = find(size, grid, new HashMap<>(), paths);

        System.out.println(shortedPath);
    }

    private void expand(Map<Coordinate, Integer> grid, Coordinate dimen, int repeat) {
        for (int offsetY = 0; offsetY < repeat; offsetY++) {
            for (int offsetX = 0; offsetX < repeat; offsetX++) {
                for (int y = 0; y <= dimen.y; y++) {
                    for (int x = 0; x <= dimen.x; x++) {
                        int risk = (grid.get(new Coordinate(x, y)) + offsetX + offsetY) % 9;
                        grid.put(
                                new Coordinate(x + (dimen.x + 1) * offsetX, y + (dimen.y + 1) * offsetY),
                                risk == 0 ? 9 : risk
                        );
                    }
                }
            }
        }
    }

    private Integer find(Coordinate target, Map<Coordinate, Integer> grid, Map<Coordinate, Integer> distances, Queue<Path> paths) {
        while (!paths.isEmpty()) {
            Path path = paths.poll();
            Integer current = distances.get(path.current);

            if (current == null || current == path.distance) {
                for (Coordinate neighbour: neighbours(path.current)) {
                    if (grid.containsKey(neighbour)) {
                        int distance = grid.get(neighbour);
                        int totalDistance = distance + path.distance;

                        Integer currentShortest = distances.get(neighbour);

                        if (currentShortest == null || currentShortest > totalDistance) {
                            Path shorterPath = new Path(neighbour, totalDistance, path);
                            distances.put(neighbour, totalDistance);
                            paths.offer(shorterPath);

                        }
                    }
                }
            }
        }

        return distances.get(target);
    }

    private Set<Coordinate> neighbours(Coordinate coordinate) {
        return Set.of(
                new Coordinate(coordinate.x - 1, coordinate.y),
                new Coordinate(coordinate.x + 1, coordinate.y),
                new Coordinate(coordinate.x, coordinate.y - 1),
                new Coordinate(coordinate.x, coordinate.y + 1)
        );
    }

    private Coordinate dimensions(Map<Coordinate, Integer> grid) {
        return grid.keySet().stream().max((c1, c2) -> c1.x + c1.y - c2.x - c2.y).orElseThrow();
    }

    private Map<Coordinate, Integer> parse(Stream<String> input) {
        Map<Coordinate, Integer> grid = new HashMap<>();

        AtomicInteger y = new AtomicInteger(0);

        input.forEachOrdered(line -> {
            AtomicInteger x = new AtomicInteger(0);

            Arrays.stream(line.trim().split(""))
                    .map(Integer::parseInt)
                    .forEachOrdered(digit -> grid.put(new Coordinate(x.getAndIncrement(), y.get()), digit));

            y.incrementAndGet();
        });

        return grid;
    }
}
