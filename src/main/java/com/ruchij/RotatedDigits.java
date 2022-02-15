package com.ruchij;

import java.util.Map;

public class RotatedDigits {
    private Map<Character, Character> MAPPINGS =
            Map.of(
                    '0', '0',
                    '1', '1',
                    '8', '8',
                    '2', '5',
                    '5', '2',
                    '6', '9',
                    '9', '6'
            );

    public int rotatedDigits(int n) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            String rotated = rotate(i);

            if (rotated != null && !rotated.equals(String.valueOf(i))) {
                count++;
            }

        }

        return count;
    }

    private String rotate(int number) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char character : String.valueOf(number).toCharArray()) {
            Character rotated = MAPPINGS.get(character);

            if (rotated == null) {
                return null;
            } else {
                stringBuilder.append(rotated);
            }
        }

        return stringBuilder.toString();
    }
}
