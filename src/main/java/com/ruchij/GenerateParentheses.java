package com.ruchij;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    record State(String value, int offset) {}

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        ArrayDeque<State> queue = new ArrayDeque<>();
        queue.add(new State("", 0));

        while (!queue.isEmpty()) {
            State state = queue.pop();
            int length = state.value.length();

            if (length == n * 2 && state.offset == 0) {
                result.add(state.value);
            } else if (length < n * 2) {
                if (state.offset < n * 2 - length) {
                    queue.add(new State(state.value + "(", state.offset + 1));
                }

                if (state.offset > 0) {
                    queue.add(new State(state.value + ")", state.offset - 1));
                }
            }
        }

        return result;
    }
}
