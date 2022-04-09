package com.ruchij;

import java.util.Stack;

public class StringCompression {
    record Entry(char character, int count){}

    public int compress(char[] chars) {
        Stack<Entry> stack = new Stack<>();

        for (char character : chars) {
            if (stack.isEmpty() || stack.peek().character != character) {
                stack.push(new Entry(character, 1));
            } else {
                Entry entry = stack.pop();
                stack.push(new Entry(entry.character, entry.count + 1));
            }
        }

        int index = 0;

        for (Entry entry : stack) {
            chars[index] = entry.character;
            index++;

            if (entry.count > 1) {
                String lengthString = Integer.valueOf(entry.count).toString();

                for (char character : lengthString.toCharArray()) {
                    chars[index] = character;
                    index++;
                }
            }
        }

        return index;
    }
}
