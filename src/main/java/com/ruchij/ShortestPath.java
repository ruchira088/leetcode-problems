package com.ruchij;

import java.util.*;
import java.util.stream.Stream;

public class ShortestPath {
    private record Coordinate(int x, int y) {}
    private record Path(Coordinate current, Path before, Double distance) {}
    private record Neighbour(Coordinate coordinate, Double distance) {}

    private enum Tile {
        Empty("."), Wall("#"), Route("X");

        final String character;

        Tile(String character) {
            this.character = character;
        }
    }

    public void solve(Stream<String> input) {
        Map<Coordinate, Tile> grid = parse(input);

        Queue<Path> paths = new ArrayDeque<>();
        paths.add(new Path(new Coordinate(0, 0), null, 0.0));

        Optional<Path> result = solve(new Coordinate(109, 107), new HashMap<>(), grid, paths);

        drawRoute(grid, result.orElseThrow());
    }

    private void drawRoute(Map<Coordinate, Tile> grid, Path path) {
        while (path != null) {
            grid.put(path.current, Tile.Route);
            path = path.before;
        }

        printGrid(grid);
    }

    private void printGrid(Map<Coordinate, Tile> grid) {
        Coordinate dimensions = grid.keySet().stream().max((o1, o2) -> o1.x + o1.y - o2.x - o2.y).orElseThrow();

        for (int y = dimensions.y; y >= 0; y--) {
            for (int x = 0; x <= dimensions.x; x++) {
                System.out.print(grid.get(new Coordinate(x, y)).character + "  ");
            }
            System.out.println("\n");
        }
    }

    private Optional<Path> solve(Coordinate target, Map<Coordinate, Double> distances, Map<Coordinate, Tile> grid, Queue<Path> paths) {
        while (!paths.isEmpty()) {
            Path head = paths.poll();

            if (head.current.equals(target)) {
                return Optional.of(head);
            }

            for (Neighbour neighbour : neighbours(head.current)) {
                if (Optional.ofNullable(grid.get(neighbour.coordinate)).filter(tile -> tile == Tile.Empty).isPresent()) {
                    Double distance = head.distance + neighbour.distance;
                    Double existing = distances.get(neighbour.coordinate);

                    if (existing == null || existing > distance) {
                        Path path = new Path(neighbour.coordinate, head, distance);
                        paths.offer(path);

                        paths = new ArrayDeque<>(paths.stream().sorted(Comparator.comparing(Path::distance)).toList());

                        distances.put(neighbour.coordinate, distance);
                    }
                }
            }
        }

        return Optional.empty();
    }

    private Set<Neighbour> neighbours(Coordinate coordinate) {
        Set<Neighbour> set = new HashSet<>();

        for (Integer x : Set.of(-1, 0, 1)) {
            for (Integer y: Set.of(-1, 0, 1)) {
                if (!(x == 0 && y == 0)) {
                    Coordinate current = new Coordinate(x + coordinate.x, y + coordinate.y);

                    if (Math.abs(x) == 1 && Math.abs(y) == 1) {
                        set.add(new Neighbour(current, 1.7));
                    } else {
                        set.add(new Neighbour(current, 1.0));
                    }
                }
            }
        }

        return set;
    }

    private Tile parseTile(String input) {
        return Arrays.stream(Tile.values()).filter(tile -> tile.character.equalsIgnoreCase(input)).findFirst().orElseThrow();
    }

    public Map<Coordinate, Tile> parse(Stream<String> input) {
        Map<Coordinate, Tile> map = new HashMap<>();
        String[] strings = input.toArray(String[]::new);

        for (int i = 0; i < strings.length; i++) {
            String[] chars = strings[i].split("");

            for (int j = 0; j < chars.length; j++) {
                map.put(new Coordinate(j, strings.length - 1 - i), parseTile(chars[j]));
            }
        }

        return map;
    }
}
