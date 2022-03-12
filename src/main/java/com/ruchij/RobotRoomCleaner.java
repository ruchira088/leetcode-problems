package com.ruchij;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {
    interface Robot {
        boolean move();

        void turnLeft();
        void turnRight();

        void clean();
    }

    record Coordinate(int x, int y) {}

    public void cleanRoom(Robot robot) {
        cleanRoom(robot, new HashSet<>(), new Coordinate(0, 0), Direction.UP);
    }

    enum Direction {
        UP, RIGHT, DOWN, LEFT
    }

    Coordinate move(Coordinate position, Direction direction) {
        if (direction == Direction.DOWN) {
            return new Coordinate(position.x, position.y + 1);
        } else if (direction == Direction.UP) {
            return new Coordinate(position.x, position.y - 1);
        } else if (direction == Direction.RIGHT) {
            return new Coordinate(position.x + 1, position.y);
        } else {
            return new Coordinate(position.x - 1, position.y);
        }
    }

    Direction turnRight(Direction direction) {
        if (direction == Direction.DOWN) {
            return Direction.LEFT;
        } else if (direction == Direction.LEFT) {
            return Direction.UP;
        } else if (direction == Direction.UP) {
            return Direction.RIGHT;
        } else {
            return Direction.DOWN;
        }
    }

    Direction turnLeft(Direction direction) {
        if (direction == Direction.DOWN) {
            return Direction.RIGHT;
        } else if (direction == Direction.RIGHT) {
            return Direction.UP;
        } else if (direction == Direction.UP) {
            return Direction.LEFT;
        } else {
            return Direction.DOWN;
        }
    }

    void cleanRoom(Robot robot, Set<Coordinate> cleaned, Coordinate position, Direction direction) {
        Direction currentDirection = direction;

        if (!cleaned.contains(position)) {
            robot.clean();
            cleaned.add(position);

            boolean canMove = robot.move();

            if (canMove) {
                cleanRoom(robot, cleaned, move(position, currentDirection), currentDirection);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }

            robot.turnRight();
            currentDirection = turnRight(currentDirection);
            canMove = robot.move();

            if (canMove) {
                cleanRoom(robot, cleaned, move(position, currentDirection), currentDirection);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
            } else {
                robot.turnRight();
                robot.turnRight();
                robot.turnRight();
            }

            currentDirection = direction;

            robot.turnLeft();
            currentDirection = turnLeft(currentDirection);
            canMove = robot.move();

            if (canMove) {
                cleanRoom(robot, cleaned, move(position, currentDirection), currentDirection);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnLeft();
            } else {
                robot.turnRight();
            }

            currentDirection = direction;

            robot.turnRight();
            robot.turnRight();
            currentDirection = turnRight(turnRight(currentDirection));
            canMove = robot.move();

            if (canMove) {
                cleanRoom(robot, cleaned, move(position, currentDirection), currentDirection);
                robot.turnRight();
                robot.turnRight();
                robot.move();
            } else {
                robot.turnRight();
                robot.turnRight();
            }
        }
    }
}
