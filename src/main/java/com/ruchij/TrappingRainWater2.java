package com.ruchij;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class TrappingRainWater2 {
    record Coordinate(int x, int y) {
    }

    record Cell(Coordinate coordinate, int height) {
    }

    public int trapRainWater(int[][] heightMap) {
        Set<Coordinate> visited = new HashSet<>();
        PriorityQueue<Cell> queue = new PriorityQueue<>(Comparator.comparingInt(Cell::height));

        for (int i = 0; i < heightMap.length; i++) {
            Coordinate startCoordinate = new Coordinate(0, i);
            Cell startCell = new Cell(startCoordinate, heightMap[startCoordinate.y][startCoordinate.x]);

            Coordinate endCoordinate = new Coordinate(heightMap[i].length - 1, i);
            Cell endCell = new Cell(endCoordinate, heightMap[endCoordinate.y][endCoordinate.x]);

            queue.add(startCell);
            queue.add(endCell);

            visited.add(startCoordinate);
            visited.add(endCoordinate);
        }

        for (int i = 0; i < heightMap[0].length; i++) {

            Coordinate startCoordinate = new Coordinate(i, 0);

            if (!visited.contains(startCoordinate)) {
                Cell startCell = new Cell(startCoordinate, heightMap[startCoordinate.y][startCoordinate.x]);
                queue.add(startCell);
                visited.add(startCoordinate);
            }

            Coordinate endCoordinate = new Coordinate(i, heightMap.length - 1);

            if (!visited.contains(endCoordinate)) {
                Cell endCell = new Cell(endCoordinate, heightMap[endCoordinate.y][endCoordinate.x]);
                queue.add(endCell);
                visited.add(endCoordinate);
            }
        }

        int result = 0;

        int[][] diffs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();

            for (int[] diff : diffs) {
                Coordinate neighbour = new Coordinate(cell.coordinate.x + diff[0], cell.coordinate.y + diff[1]);

                if (neighbour.y >= 0 && neighbour.y < heightMap.length && neighbour.x >= 0 && neighbour.x < heightMap[neighbour.y].length && !visited.contains(neighbour)) {
                    int neighbourHeight = heightMap[neighbour.y][neighbour.x];
                    result += Math.max(0, cell.height - neighbourHeight);
                    queue.add(new Cell(neighbour, Math.max(cell.height, neighbourHeight)));
                    visited.add(neighbour);
                }
            }

        }

        return result;
    }

}
