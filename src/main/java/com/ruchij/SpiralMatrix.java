package com.ruchij;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    private static final int VISITED = 1000;

    record Coordinate(int x, int y) {
    }

    interface DirectionMapper {
        Coordinate next(Coordinate coordinate);
    }

    enum Direction {
        UP(coordinate -> new Coordinate(coordinate.x, coordinate.y - 1)),
        RIGHT(coordinate -> new Coordinate(coordinate.x + 1, coordinate.y)),
        DOWN(coordinate -> new Coordinate(coordinate.x, coordinate.y + 1)),
        LEFT(coordinate -> new Coordinate(coordinate.x - 1, coordinate.y));

        private final DirectionMapper directionMapper;

        Direction(DirectionMapper directionMapper) {
            this.directionMapper = directionMapper;
        }

        Direction turnRight() {
            switch (this) {
                case RIGHT -> { return Direction.DOWN; }
                case DOWN -> { return Direction.LEFT; }
                case LEFT -> { return Direction.UP; }
                default -> { return Direction.RIGHT; }
            }
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        Coordinate start = new Coordinate(0, 0);
        List<Integer> values = new ArrayList<>();
        values.add(matrix[0][0]);
        matrix[0][0] = VISITED;

        move(start, matrix, values, Direction.RIGHT);

        return values;
    }

    private boolean isValid(Coordinate coordinate, int[][] matrix) {
        return coordinate.y >= 0 && coordinate.y < matrix.length &&
                coordinate.x >= 0 && coordinate.x < matrix[coordinate.y].length &&
                matrix[coordinate.y][coordinate.x] != VISITED;
    }

    private void move(Coordinate start, int[][] matrix, List<Integer> values, Direction direction) {
        Coordinate last = start;
        Coordinate current = direction.directionMapper.next(start);

        while (isValid(current, matrix)) {
            values.add(matrix[current.y][current.x]);
            matrix[current.y][current.x] = VISITED;
            last = current;
            current = direction.directionMapper.next(current);
        }

        if (!last.equals(start) || direction != Direction.UP) {
            move(last, matrix, values, direction.turnRight());
        }
    }
}
