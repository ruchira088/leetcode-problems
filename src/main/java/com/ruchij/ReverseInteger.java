package com.ruchij;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseInteger {
    public int reverse(int x) {
        List<Integer> max = listNumber((int) Math.pow(2, 31) - 1);
        List<Integer> min = listNumber((int) Math.pow(-2, 31));

        List<Integer> reversedNumber = listNumber(x);
        Collections.reverse(reversedNumber);

        if (x >= 0) {
            if (greaterThan(reversedNumber, max)) {
                return 0;
            } else {
                return integer(reversedNumber);
            }
        } else {
            if (greaterThan(reversedNumber, min)) {
                return 0;
            } else {
                return -integer(reversedNumber);
            }
        }
    }

    private int integer(List<Integer> number) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Integer integer : number) {
            stringBuilder.append(integer);
        }

        return Integer.parseInt(stringBuilder.toString());
    }

    private List<Integer> listNumber(int number) {
        String numberString = Integer.valueOf(number).toString();
        ArrayList<Integer> integers = new ArrayList<>();

        for (int i = 0; i < numberString.length(); i++) {
            if (numberString.charAt(i) != '-') {
                integers.add(Integer.parseInt(numberString.substring(i, i+1)));
            }
        }

        return integers;
    }

    private boolean greaterThan(List<Integer> main, List<Integer> other) {
        if (main.size() > other.size()) {
            return true;
        } else if (main.size() == other.size()) {
            for (int i = 0; i < main.size(); i++) {
                if (main.get(i) > other.get(i)) {
                    return true;
                } else if (main.get(i) < other.get(i)) {
                    return false;
                }
            }

            return false;
        } else {
            return false;
        }
    }
}
