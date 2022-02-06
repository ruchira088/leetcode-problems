package com.ruchij;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StudentAttendance {
    enum Attendance {
        PRESENT, LATE, ABSENT
    }

    record State(Attendance first, Attendance second, boolean hadAbsent) { }

    public int checkRecord(int n) {
        State initial = new State(null, null, false);
        Map<State, Long> states = new HashMap<>();
        states.put(initial, 1L);

        for (int i = 0; i < n; i++) {
            Map<State, Long> map = new HashMap<>();

            for (State state: states.keySet()) {
                Set<State> nextStates = next(state);

                for (State nextState : nextStates) {
                    map.put(
                            nextState,
                            limit(map.getOrDefault(nextState, 0L) + states.getOrDefault(state, 1L))
                    );
                }
            }

            states = map;
        }


        return (int) limit(states.values().stream().mapToLong(value -> value).sum());
    }

    long limit(long number) {
        return number % 1_000_000_007;
    }

    Set<State> next(State state) {
        Set<State> result = new HashSet<>();

        if (!state.hadAbsent()) {
            result.add(new State(Attendance.ABSENT, state.first, true));
        }

        if (state.first != Attendance.LATE || state.second != Attendance.LATE) {
            result.add(new State(Attendance.LATE, state.first, state.hadAbsent));
        }

        result.add(new State(Attendance.PRESENT, state.first, state.hadAbsent));

        return result;
    }


}
