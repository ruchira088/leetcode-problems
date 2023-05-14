package com.ruchij;

import java.util.Stack;

public class LongestPath {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for (String line : input.split("\n")) {
            int tabs = line.lastIndexOf('\t') + 1;

            while (stack.size() > tabs) {
                stack.pop();
            }

            int length = line.length() - tabs + 1;
            int totalLength = stack.isEmpty() ? length : (stack.peek() + length);

            stack.push(totalLength);

            if (line.contains(".")) {
                max = Math.max(max, totalLength);
            }
        }

        return Math.max(0, max - 1);
    }
}
