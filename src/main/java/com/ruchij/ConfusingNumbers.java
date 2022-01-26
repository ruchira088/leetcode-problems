package com.ruchij;

import java.util.Map;
import java.util.Set;

public class ConfusingNumbers {
    private static final Map<String, Integer> NUMBER_MAPPINGS =
            Map.of(
                    "0", 0,
                    "1", 1,
                    "6", 9,
                    "8", 8,
                    "9", 6
            );

    public int confusingNumberII(int n) {
        int count = 0;
        int index = 0;

        while (index <= n) {
            String stringNumber = String.valueOf(index);
            String mostSignificant =  stringNumber.substring(0, 1);

            if (!NUMBER_MAPPINGS.containsKey(mostSignificant)) {
                int length = stringNumber.length();
                int increase = (int) Math.pow(10, length - 1);

                if (mostSignificant.contentEquals("2")) {
                    index += increase * 4;
                } else {
                    index += increase;
                }

            } else {

                String rotated = rotate(stringNumber);

                if (rotated != null && !rotated.contentEquals(stringNumber)) {
                    count++;
                }

                index++;
            }
        }

        return count;
    }

    private String rotate(String numberString) {
        for (String non : Set.of("2", "3", "4", "5", "7")) {
            if (numberString.contains(non)) {
                return null;
            }
        }

        String[] digits = numberString.split("");
        StringBuilder result = new StringBuilder();

        for (String digit: digits) {
            Integer integer = NUMBER_MAPPINGS.get(digit);

            if (integer == null) {
                return null;
            } else {
                result.insert(0, integer);
            }
        }

        return result.toString();
    }

}
