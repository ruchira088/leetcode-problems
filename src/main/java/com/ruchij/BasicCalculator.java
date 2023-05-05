package com.ruchij;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicCalculator {
    public int calculate(String input) {
       return split(input, "\\+").stream()
                .map(additions ->
                        split(additions.trim(), "-").stream()
                                .map(subtractions -> calculate(reduce(subtractions, ""))
                                )
                                .reduce((acc, value) -> acc - value)
                                .orElse(0)
                )
                .reduce(0, (acc, value) -> acc + value);
    }

    List<String> split(String expression, String symbol) {
        return Arrays.asList(expression.split(symbol));
    }

    List<String> reduce(String expression, String remaining) {
        if (expression.isEmpty() && remaining.isEmpty()) {
            return new ArrayList<>();
        } else if (expression.isEmpty()) {
            return List.of(remaining);
        } else {
            String head = expression.substring(0, 1);
            String tail = expression.substring(1);
            List<String> result = new ArrayList<>();

            if (head.equals("/")) {
                result.add(remaining);
                result.add("/");
                result.addAll(reduce(tail, ""));
            } else if (head.equals("*")) {
                result.add(remaining);
                result.add("*");
                result.addAll(reduce(tail, ""));
            } else {
                result.addAll(reduce(tail, remaining + head));
            }

            return result;
        }
    }

    Integer calculate(List<String> terms) {
        if (terms.isEmpty()) {
            return 1;
        } else if (terms.size() == 1) {
            return Integer.parseInt(terms.get(0).trim());
        } else {
            int first = Integer.parseInt(terms.get(0).trim());
            String second = terms.get(1);
            int third = Integer.parseInt(terms.get(2).trim());

            terms.remove(0);
            terms.remove(0);
            terms.remove(0);

            if (second.equalsIgnoreCase("/")) {
                terms.add(0, Integer.toString(first / third));
            } else {
                terms.add(0, Integer.toString(first * third));
            }

            return calculate(terms);
        }
    }
}
