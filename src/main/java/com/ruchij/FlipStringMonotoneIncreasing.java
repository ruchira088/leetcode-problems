package com.ruchij;

public class FlipStringMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        int zerosRight = countZeros(s);
        int onesLeft = 0;

        int min = zerosRight;

        for (int index = 0; index < s.length(); index++) {
            if (s.charAt(index) == '1') {
                onesLeft++;
            } else {
                zerosRight--;
            }

            min = Math.min(min, onesLeft + zerosRight);
        }

        return min;
    }

    int countZeros(String input) {
        int count = 0;

        for (char character : input.toCharArray()) {
            if (character == '0') {
                count++;
            }
        }

        return count;
    }
}
