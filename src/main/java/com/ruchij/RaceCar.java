package com.ruchij;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class RaceCar {
    record State(int position, int speed, int count) {}
    record Visited(int position, int speed) {}

    public int racecar(int target) {
        ArrayDeque<State> queue = new ArrayDeque<>();
        Set<Visited> visitedSet = new HashSet<>();
        queue.add(new State(0, 1, 0));

        while (!queue.isEmpty()) {
            State state = queue.pop();
            Visited visited = new Visited(state.position, state.speed);

            if (state.position == target) {
                return state.count;
            }

            if (!visitedSet.contains(visited)) {
                visitedSet.add(visited);

                if (state.position > target && state.speed > 0) {
                    queue.add(next(state, 'R'));
                } else {
                    queue.add(next(state, 'R'));
                    queue.add(next(state, 'A'));
                }
            }

        }

        return -1;
    }

    State next(State state, char instruction) {
        if (instruction == 'A') {
            return new State(state.position + state.speed, state.speed * 2, state.count + 1);
        } else {
            return new State(state.position, state.speed > 0 ? -1 : 1, state.count + 1);
        }
    }
}
