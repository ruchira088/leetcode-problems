package com.ruchij;

import java.util.*;
import java.util.stream.Stream;

public class BricksFallingWhenHit {
    record Coordinate(int x, int y) {}
    record Group(boolean isStable, Set<Coordinate> coordinates) {}

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] falls = new int[hits.length];
        List<Group> groups = groupGrid(grid);
        Map<Coordinate, Group> coordinateGroupMap = new HashMap<>();

        for (Group group : groups) {
            for (Coordinate coordinate : group.coordinates) {
                coordinateGroupMap.put(coordinate, group);
            }
        }

        for (int i = 0; i < hits.length; i++) {
            int count = 0;

            if (update(grid, hits[i])) {
                Coordinate coordinate = new Coordinate(hits[i][1], hits[i][0]);
                Group group = coordinateGroupMap.remove(coordinate);
                groups.remove(group);

                HashSet<Coordinate> visited = new HashSet<>();
                group.coordinates.remove(coordinate);

                for (Coordinate start : group.coordinates) {
                    Group explore = explore(visited, grid, start);

                    if (!explore.isStable) {
                        for (Coordinate fall : explore.coordinates) {
                            coordinateGroupMap.remove(fall);
                            count++;
                            grid[fall.y][fall.x] = 0;
                        }
                    } else {
                        for (Coordinate stable : explore.coordinates) {
                            coordinateGroupMap.put(stable, explore);
                        }
                    }
                }
            }

            falls[i] = count;
        }

        return falls;
    }

    boolean update(int[][] grid, int[] hit) {
        int previous = grid[hit[0]][hit[1]];
        grid[hit[0]][hit[1]] = 0;

        return previous == 1;
    }

    List<Group> groupGrid(int[][] grid) {
        Set<Coordinate> visited = new HashSet<>();
        List<Group> groups = new ArrayList<>();

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                Coordinate coordinate = new Coordinate(x, y);

                if (!visited.contains(coordinate) && grid[y][x] == 1) {
                    groups.add(explore(visited, grid, coordinate));
                }
            }
        }

        return groups;
    }

    Group explore(Set<Coordinate> visited, int[][] grid, Coordinate start) {
        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        queue.add(start);
        int height = grid.length;
        int width = grid[0].length;
        boolean isStable = false;

        HashSet<Coordinate> group = new HashSet<>();

        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.pop();
            isStable = isStable || coordinate.y == 0;

            if (!visited.contains(coordinate)) {
                group.add(coordinate);
                visited.add(coordinate);

                Stream.of(
                        new Coordinate(coordinate.x, coordinate.y + 1),
                        new Coordinate(coordinate.x, coordinate.y - 1),
                        new Coordinate(coordinate.x + 1, coordinate.y),
                        new Coordinate(coordinate.x - 1, coordinate.y)
                )
                        .filter(current -> current.x >= 0 && current.x < width && current.y >= 0 && current.y < height && !visited.contains(current))
                        .filter(current -> grid[current.y][current.x] == 1)
                        .forEach(queue::add);
            }
        }

        return new Group(isStable, group);
    }
}
