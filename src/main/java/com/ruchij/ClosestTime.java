package com.ruchij;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestTime {
    public String nextClosestTime(String time) {
        List<Integer> nums = parse(time);
        Integer timeNumber = Integer.parseInt("%s%s%s%s".formatted(nums.get(0), nums.get(1), nums.get(2), nums.get(3)));

        Integer next = numbers(nums).stream().filter(num -> num > timeNumber).sorted().findFirst().orElseThrow();

        if (next >= 2400) {
            next -= 2400;
        }

        StringBuilder stringBuilder = new StringBuilder();

        if (next < 1000) {
            stringBuilder.append("0");
        }

        stringBuilder.append(next / 100);
        stringBuilder.append(":");

        if (next % 100 < 10) {
            stringBuilder.append("0");
        }

        stringBuilder.append(next % 100);

        return stringBuilder.toString();
    }

    List<Integer> parse(String time) {
        return Arrays.stream(time.split(""))
                .filter(character -> character.matches("\\d"))
                .map(Integer::parseInt)
                .toList();
    }

    List<Integer> numbers(List<Integer> nums) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int first : nums) {
            for (int second: nums) {
                for (int third : nums) {
                    for (int fourth : nums) {
                        String num = "%s%s%s%s".formatted(first, second, third, fourth);
                        int number = Integer.parseInt(num);

                        if (number % 100 < 60 && number / 100 < 24) {
                            arrayList.add(number);
                            arrayList.add(number + 2400);
                        }
                    }
                }
            }
        }

        return arrayList;
    }
}
