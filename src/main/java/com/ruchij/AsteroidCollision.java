package com.ruchij;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            putInStack(asteroid, stack);
        }

        int[] result = new int[stack.size()];
        int index = 0;

        for (Integer value : stack) {
            result[index] = value;
            index++;
        }

        return result;
    }

    private void putInStack(int asteroid, Stack<Integer> stack) {
        if (stack.isEmpty()) {
            stack.push(asteroid);
        } else {
            Integer head = stack.peek();

            if (head > 0 && asteroid < 0) {
                if (Math.abs(head) <= Math.abs(asteroid)) {
                    stack.pop();

                    if (-head != asteroid) {
                        putInStack(asteroid, stack);
                    }
                }
            } else {
                stack.push(asteroid);
            }
        }
    }
}
