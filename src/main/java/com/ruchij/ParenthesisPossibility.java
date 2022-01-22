package com.ruchij;

import java.util.*;
import java.util.stream.Collectors;

public class ParenthesisPossibility {
    private record Value(String string, int count) {}
    private record MultiParam(String string, Stack<Character> stack) {}

    private static final Map<Character, Character> PARAM_MAP =
        Map.of('[', ']', '{', '}', '(', ')');

    public Set<String> solve(int count) {
        Deque<Value> values = new ArrayDeque<>();
        values.add(new Value("", 0));

        return solve(count * 2, values);
    }

    public Set<String> solve(int count, Deque<Value> values) {
        while (values.peek() != null && values.peek().count < count) {
            Value head = values.pop();
            values.addLast(new Value(head.string + "(", head.count + 1));

            if (head.count != 0) {
                values.addLast(new Value(head.string + ")", head.count - 1));
            }
        }

        return values.stream().filter(value -> value.count == 0).map(Value::string).collect(Collectors.toSet());
    }

    public Set<String> solveMulti(int count) {
        Deque<MultiParam> deque = new ArrayDeque<>();
        deque.add(new MultiParam("", new Stack<>()));

        return solveMulti(count * 2, deque);
    }

    public Set<String> solveMulti(int count, Deque<MultiParam> values) {
        while (values.peek() != null && values.peek().string.length() < count) {
            MultiParam head = values.pop();

            PARAM_MAP.keySet().forEach(character -> {
                Stack<Character> stack = new Stack<>();
                stack.addAll(head.stack);
                stack.add(character);

                values.addLast(new MultiParam(head.string + character, stack));
            });

            if (!head.stack.isEmpty()) {
                Character character = head.stack.pop();
                Character match = PARAM_MAP.get(character);

                values.addLast(new MultiParam(head.string + match, head.stack));
            }
        }

        return values.stream().filter(value -> value.stack.isEmpty()).map(MultiParam::string).collect(Collectors.toSet());
    }

}
