package com.ruchij;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class RegularExpressionMatching {
    interface RegexChar {
        boolean isMatch(char input);
    }

    record Character(char character) implements RegexChar {
        @Override
        public boolean isMatch(char input) {
            return character == input;
        }
    }

    record Any() implements RegexChar {
        @Override
        public boolean isMatch(char input) {
            return true;
        }
    }

    record ZeroOrMore(RegexChar regexChar) implements RegexChar {
        @Override
        public boolean isMatch(char input) {
            return regexChar.isMatch(input);
        }
    }

    record Node(String input, List<RegexChar> pattern) { }

    public boolean isMatch(String input, String pattern) {
        List<RegexChar> parsedPattern = parse(pattern);
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(input, parsedPattern));

        while (!queue.isEmpty()) {
            Node node = queue.pop();

            if (node.input.isEmpty() && node.pattern.isEmpty()) {
                return true;
            } else if (!node.pattern.isEmpty()) {
                RegexChar headRegex = node.pattern.get(0);
                List<RegexChar> tailPattern = node.pattern.subList(1, node.pattern.size());

                if (!node.input.isEmpty()) {
                    char headChar = node.input.charAt(0);

                    if (headRegex instanceof ZeroOrMore) {
                        queue.add(new Node(node.input, tailPattern));
                    }

                    if (headRegex.isMatch(headChar)) {
                        String newInput = node.input.substring(1);

                        queue.add(new Node(newInput, tailPattern));

                        if (headRegex instanceof ZeroOrMore) {
                            queue.add(new Node(newInput, node.pattern));
                        }
                    }
                } else {
                    if (headRegex instanceof ZeroOrMore) {
                        queue.add(new Node("", tailPattern));
                    }
                }
            }
        }

        return false;
    }



    List<RegexChar> parse(String pattern) {
        List<RegexChar> result = new ArrayList<>();

        for (int i = 0; i < pattern.length(); i++) {
            char character = pattern.charAt(i);

            if (character == '.') {
                result.add(new Any());
            } else if (character == '*') {
                int lastIndex = result.size() - 1;
                RegexChar regexChar = result.remove(lastIndex);

                ZeroOrMore zeroOrMore = new ZeroOrMore(regexChar);

                if (result.size() == 0 || !result.get(result.size() - 1).equals(zeroOrMore)) {
                    result.add(zeroOrMore);
                }
            } else {
                result.add(new Character(character));
            }
        }

        return result;
    }
}
