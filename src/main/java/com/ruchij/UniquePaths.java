package com.ruchij;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {
    record Coordinate(int x, int y) {}

    public int uniquePaths(int m, int n) {
        Map<Coordinate, Integer> cache = new HashMap<>();

        return count(n - 1, m - 1, cache);
    }

    private int count(int x, int y, Map<Coordinate, Integer> cache) {
        Integer result = cache.get(new Coordinate(x, y));

        if (result != null) {
            return result;
        } else if (x < 0 || y < 0) {
            return 0;
        } else if (x == 0 && y == 0) {
            return 1;
        } else {
            int answer = count(x - 1, y, cache) + count(x, y - 1, cache);
            cache.put(new Coordinate(x, y), answer);
            cache.put(new Coordinate(y, x), answer);
            return answer;
        }
    }
}
