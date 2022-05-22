package com.ruchij;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IpToCidr {
    public List<String> ipToCIDR(String ip, int n) {
        List<Integer> integers = parse(ip);
        List<String> cidrs = new ArrayList<>();
        List<Integer> current = integers;

        for (int i = 0; i < n; i++) {
            cidrs.add(toBinary(current));
            current = add(current, 1, 256);
        }

        return summarize(cidrs, cidrs.size(), 0, 32);
    }

    String toCidr(String number) {
        if (number.isEmpty()) {
            return "";
        } else {
            int value = Integer.parseInt(number.substring(0, 8), 2);

            String remainder = toCidr(number.substring(8));

            return value + (remainder.isEmpty() ? "" : ("." + remainder));
        }
    }

    List<String> summarize(List<String> numbers, int size, int index, int max) {
        if (numbers.isEmpty()) {
            return new ArrayList<>();
        } else if (index >= max) {
            return numbers.stream().map(number -> toCidr(number) + "/32").collect(Collectors.toList());
        } else {
            int count = (int) Math.pow(2, max - index);

            if (count == size) {
                String number = toCidr(numbers.get(0).substring(0, index) + Stream.generate(() -> "0").limit(max - index).collect(Collectors.joining()));
                return new ArrayList<>(List.of(number + "/" + index));
            } else {
                List<String> ones = new ArrayList<>();
                List<String> zeros = new ArrayList<>();

                numbers.forEach(number -> {
                    char charAt = number.charAt(index);

                    if (charAt == '1') {
                        ones.add(number);
                    } else {
                        zeros.add(number);
                    }
                });

                List<String> result = summarize(zeros, zeros.size(), index + 1, max);
                result.addAll(summarize(ones,  ones.size(), index + 1, max));

                return result;
            }
        }
    }

    String toBinary(List<Integer> numbers) {
        StringBuilder stringBuilder = new StringBuilder();

        numbers.forEach(number -> {
            String binaryString = Integer.toBinaryString(number);
            String leadingZeros = Stream.generate(() -> "0").limit(8 - binaryString.length()).collect(Collectors.joining());
            stringBuilder.append(leadingZeros);
            stringBuilder.append(binaryString);
        });

        return stringBuilder.toString();
    }

    List<Integer> parse(String ip) {
        return Arrays.stream(ip.split("\\."))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    List<Integer> add(List<Integer> numbers, int add, int limit) {
        ArrayList<Integer> integers = new ArrayList<>(numbers);
        Collections.reverse(integers);

        List<Integer> result = addNumbers(integers, add, limit);
        Collections.reverse(result);

        return result;
    }

    private List<Integer> addNumbers(List<Integer> numbers, int add, int limit) {
        if (add == 0) {
            return numbers;
        } else {
            int first = numbers.isEmpty() ? 0 : numbers.get(0);
            int addition = first + add;
            int remainder = addition % limit;
            int integer = addition / limit;

            ArrayList<Integer> list = new ArrayList<>(numbers);

            if (integer == 0) {
                list.set(0, remainder);

                return list;
            } else {
                list.remove(0);
                List<Integer> result = addNumbers(list, integer, limit);
                result.add(0, remainder);

                return result;
            }
        }
    }


}
