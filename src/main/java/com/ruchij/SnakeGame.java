package com.ruchij;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.Function;

public class SnakeGame {
    record Coordinate(int x, int y) {}

    enum Direction {
        UP("U",coordinate -> new Coordinate(coordinate.x, coordinate.y - 1)),
        DOWN("D",coordinate -> new Coordinate(coordinate.x, coordinate.y + 1)),
        RIGHT("R",coordinate -> new Coordinate(coordinate.x + 1, coordinate.y)),
        LEFT("L",coordinate -> new Coordinate(coordinate.x - 1, coordinate.y));

        private final Function<Coordinate, Coordinate> next;
        private final String symbol;

        Direction(String symbol, Function<Coordinate, Coordinate> next) {
            this.symbol = symbol;
            this.next = next;
        }

        public Function<Coordinate, Coordinate> getNext() {
            return next;
        }

        public String getSymbol() {
            return symbol;
        }

        public static Direction parse(String input) {
            return Arrays.stream(Direction.values())
                    .filter(direction -> direction.symbol.equals(input))
                    .findFirst().orElseThrow();
        }
    }

    private final int width;
    private final int height;
    private final LinkedList<Coordinate> snake;
    private final LinkedList<Coordinate> food;

    private int score = 0;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;

        this.snake = new LinkedList<>();
        this.snake.add(new Coordinate(0, 0));

        this.food = new LinkedList<>();

        for (int[] ints : food) {
            int x = ints[1];
            int y = ints[0];

            this.food.add(new Coordinate(x, y));
        }
    }

    public int move(String stringDirection) {
        Direction direction = Direction.parse(stringDirection);
        Coordinate next = direction.next.apply(this.snake.peekFirst());
        Coordinate last = this.snake.removeLast();

        if (next.x < 0 || next.y < 0 || next.x >= width || next.y >= height || this.snake.contains(next)) {
            return -1;
        } else {
            this.snake.addFirst(next);
            Coordinate foodCoordinate = this.food.peekFirst();

            if (next.equals(foodCoordinate)) {
                this.food.removeFirst();
                this.snake.addLast(last);
                score++;
            }

            return score;
        }
    }
}
