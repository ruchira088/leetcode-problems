package com.ruchij;

import java.util.HashMap;
import java.util.Map;

public class RobotBoundedInCircle {
    record Coordinate(int x, int y) {}
    record State(Coordinate position, Direction direction) {}

    interface Movement {
        Coordinate move(Coordinate coordinate);
    }

    enum Direction {
        NORTH(coordinate -> new Coordinate(coordinate.x, coordinate.y + 1)),
        EAST(coordinate -> new Coordinate(coordinate.x + 1, coordinate.y)),
        SOUTH(coordinate -> new Coordinate(coordinate.x, coordinate.y - 1)),
        WEST(coordinate -> new Coordinate(coordinate.x - 1, coordinate.y));

        private final Movement movement;

        Direction(Movement movement) {
            this.movement = movement;
        }

        Direction turnLeft() {
            switch (this) {
                case EAST -> { return NORTH; }
                case WEST -> { return SOUTH; }
                case NORTH -> { return WEST; }
                default -> { return EAST; }
            }
        }

        Direction turnRight() {
            switch (this) {
                case WEST -> { return NORTH; }
                case NORTH -> { return EAST; }
                case SOUTH -> { return WEST; }
                default -> { return SOUTH; }
            }
        }

        Coordinate move(Coordinate coordinate) {
            return movement.move(coordinate);
        }
    }

    enum Instruction {
        GO('G'), TURN_LEFT('L'), TURN_RIGHT('R');

        private final char symbol;

        Instruction(char symbol) {
            this.symbol = symbol;
        }
    }

    public boolean isRobotBounded(String instructions) {
        State start = new State(new Coordinate(0, 0), Direction.NORTH);
        State state = start;

        Map<Character, Instruction> instructionMap = new HashMap<>();

        for (Instruction instruction : Instruction.values()) {
            instructionMap.put(instruction.symbol, instruction);
        }

        for (int i = 0; i < 4; i++) {
            for (char character : instructions.toCharArray()) {
                Instruction instruction = instructionMap.get(character);
                state = next(state, instruction);
            }

            if (start.equals(state)) {
                return true;
            } else if (state.direction == Direction.NORTH) {
                return false;
            }
        }

        return start.equals(state);
    }

    private State next(State current, Instruction instruction) {
        switch (instruction) {
            case GO -> { return new State(current.direction.move(current.position), current.direction); }
            case TURN_LEFT -> { return new State(current.position, current.direction.turnLeft()); }
            default -> { return new State(current.position, current.direction.turnRight()); }
        }
    }
}
