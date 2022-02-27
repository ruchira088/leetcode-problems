package com.ruchij;

import java.util.Optional;

public class DecodeString {
    interface Token {
        String stringify();
    }

    record Concat(Token first, Token second) implements Token {
        @Override
        public String stringify() {
            return first.stringify() + second.stringify();
        }
    }

    record Multiply(int multiplier, Token token) implements Token {
        @Override
        public String stringify() {
            return repeat(multiplier, token.stringify());
        }

        private String repeat(int count, String input) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < count; i++) {
                stringBuilder.append(input);
            }

            return stringBuilder.toString();
        }
    }

    record StringToken(String string) implements Token {

        @Override
        public String stringify() {
            return string;
        }
    }

    public String decodeString(String s) {
        return parse(s).stringify();
    }

    private Optional<Integer> parseInt(String input) {
        try {
            int number = Integer.parseInt(input);
            return Optional.of(number);
        } catch (NumberFormatException numberFormatException) {
            return Optional.empty();
        }
    }

    private Token parse(String input) {
        if (input.isEmpty()) {
            return new StringToken("");
        } else {
            String head = input.substring(0, 1);

         if (parseInt(head).isPresent()) {
                int index = 0;
                boolean done = false;
                StringBuilder stringBuilder = new StringBuilder();

                while (!done) {
                    String current = input.substring(index, index + 1);
                    Optional<Integer> integer = parseInt(current);

                    if (integer.isPresent()) {
                        stringBuilder.append(current);
                        index++;
                    } else {
                        done = true;
                    }
                }

                index++;

                int multiplier = Integer.parseInt(stringBuilder.toString());
                int start = index;

                int offset = 1;

                while (offset != 0) {
                    if (input.charAt(index) == '[') {
                        offset++;
                    } else if (input.charAt(index) == ']') {
                        offset--;
                    }

                    index++;
                }

                return new Concat(new Multiply(multiplier, parse(input.substring(start, index - 1))), parse(input.substring(index)));

            }
            else {
                return new Concat(new StringToken(head), parse(input.substring(1)));
            }
        }
    }
}
