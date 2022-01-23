package com.ruchij;

import java.util.ArrayDeque;

public class ShortestPathWithObstacleElimination {
    record Coordinate(int x, int y) { }

    record Node(Coordinate position, int distance, int eliminatedObstacles) {}

    public int shortestPath(int[][] grid, int obstaclesElimination) {
        int height = grid.length;
        int width = grid[0].length;

        Coordinate origin = new Coordinate(0, 0);
        Coordinate destination = new Coordinate(width - 1, height - 1);
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(origin, 0, 0));
        int[][][] shortestDistance = new int[height][width][obstaclesElimination + 1];


        while (!queue.isEmpty()) {
            Node node = queue.pop();

            if (node.position.equals(destination)) {
                return node.distance;
            }

            Integer shortest = getShortest(shortestDistance, node.position, node.eliminatedObstacles);

            if (shortest == null || shortest >= node.distance) {
                shortestDistance[node.position.y][node.position.x][node.eliminatedObstacles] = node.distance;

                Coordinate[] coordinates =
                        {
                                new Coordinate(node.position.x, node.position.y + 1),
                                new Coordinate(node.position.x, node.position.y - 1),
                                new Coordinate(node.position.x + 1, node.position.y),
                                new Coordinate(node.position.x - 1, node.position.y)
                        };

                for (Coordinate coordinate: coordinates) {
                    if (coordinate.x >= 0 && coordinate.y >= 0 && coordinate.x < width && coordinate.y < height) {
                        int cell = grid[coordinate.y][coordinate.x];

                        if (cell == 1 && node.eliminatedObstacles < obstaclesElimination) {
                            Integer distance = getShortest(shortestDistance, coordinate, node.eliminatedObstacles + 1);

                            if (distance == null || distance > node.distance + 1) {
                                queue.add(new Node(coordinate, node.distance + 1, node.eliminatedObstacles + 1));
                            }
                        } else if (cell == 0) {
                            Integer distance = getShortest(shortestDistance, coordinate, node.eliminatedObstacles);

                            if (distance == null || distance > node.distance + 1) {
                                queue.add(new Node(coordinate, node.distance + 1, node.eliminatedObstacles));
                            }
                        }
                    }

                }
            }

        }

        return -1;
    }

    private Integer getShortest(int[][][] map, Coordinate position, int eliminated) {
        for (int i = eliminated; i >= 0; i--) {
            int distance = map[position.y][position.x][i];

            if (distance != 0) {
                return distance;
            }
        }

        return null;
    }
}
