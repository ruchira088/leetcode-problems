package com.ruchij;

import java.util.*;
import java.util.stream.Collectors;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int[] numberOne = parse(num1);
        int[] numberTwo = parse(num2);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numberOne.length; i++) {
            List<Integer> row = multiply(numberOne[numberOne.length - 1 - i], numberTwo);

            for (int j = 0; j < i; j++) {
                row.add(0);
            }

            result = add(result, row);
        }

        String formatted = result.stream().dropWhile(i -> i == 0).map(Object::toString).collect(Collectors.joining());

        return formatted.length() == 0 ? "0" : formatted;
    }

    private List<Integer> add(List<Integer> numOne, List<Integer> numTwo) {
        LinkedList<Integer> integers = new LinkedList<>();

        ArrayList<Integer> one = new ArrayList<>(numOne);
        Collections.reverse(one);

        ArrayList<Integer> two = new ArrayList<>(numTwo);
        Collections.reverse(two);

        int carry = 0;

        for (int i = 0; i < Math.max(two.size(), one.size()); i++) {
            int digitOne = one.size() > i ? one.get(i) : 0;
            int digitTwo = two.size() > i ? two.get(i) : 0;

            int sum = digitOne + digitTwo + carry;
            carry = sum / 10;
            integers.addFirst(sum % 10);
        }

        if (carry > 0) {
            integers.addFirst(carry);
        }

        return integers;
    }

    private int[] parse(String number) {
        return Arrays.stream(number.split("")).mapToInt(Integer::parseInt).toArray();
    }

    private List<Integer> multiply(int digit, int[] number) {
        LinkedList<Integer> integers = new LinkedList<>();
        int carry = 0;

        for (int i = 0; i < number.length; i++) {
            int result = number[number.length - 1 - i] * digit + carry;
            carry = result / 10;
            integers.addFirst(result % 10);
        }


        if (carry > 0) {
            integers.addFirst(carry);
        }

        return integers;
    }
}
