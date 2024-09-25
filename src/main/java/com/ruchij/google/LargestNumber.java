package com.ruchij.google;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comparator = (one, two) -> (one + two).compareTo(two + one);

        Arrays.sort(strings, comparator.reversed());

        StringBuilder stringBuilder = new StringBuilder();

        for (String s : strings) {
            stringBuilder.append(s);
        }

        String result = stringBuilder.toString();

        while (result.length() > 1 && result.charAt(0) == '0') {
            result = result.substring(1);
        }

        System.out.println(Arrays.toString(strings));

        return result;
    }
}
