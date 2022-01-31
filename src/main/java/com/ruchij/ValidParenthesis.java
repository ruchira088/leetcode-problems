package com.ruchij;

import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ValidParenthesis {
    private static final Map<Character, Character> MAPPINGS =
            Map.of(
                    '(', ')', '[', ']', '{', '}'
            );

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> keySet = MAPPINGS.keySet();

        for (char character: s.toCharArray()) {
            if (keySet.contains(character)) {
                stack.push(MAPPINGS.get(character));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                Character pop = stack.pop();

                if (character != pop) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
