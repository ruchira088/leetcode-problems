package com.ruchij.google;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths2 {
    record Coordinate(int x, int y) {}

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Coordinate start = new Coordinate(0, 0);
        Coordinate target = new Coordinate(obstacleGrid[0].length - 1, obstacleGrid.length - 1);

        HashMap<Coordinate, Integer> hashMap = new HashMap<>();

        if (obstacleGrid[start.y][start.x] != 1) {
            hashMap.put(start, 1);
        }

        return uniquePathsWithObstacles(obstacleGrid, target, hashMap);
    }

    private int uniquePathsWithObstacles(int[][] obstacleGrid, Coordinate target, Map<Coordinate, Integer> uniquePaths) {
        Integer count = uniquePaths.get(target);

        // Already calculated
        if (count != null) {
            return count;
        }

        // Out of bound
        if (target.x < 0 || target.y < 0) {
            return 0;
        }

        // Obstacle
        if (obstacleGrid[target.y][target.x] == 1) {
            return 0;
        }

        int top = uniquePathsWithObstacles(obstacleGrid, new Coordinate(target.x, target.y - 1), uniquePaths);
        int left = uniquePathsWithObstacles(obstacleGrid, new Coordinate(target.x - 1, target.y), uniquePaths);

        int total = top + left;

        uniquePaths.put(target, total);

        return total;
    }
}
