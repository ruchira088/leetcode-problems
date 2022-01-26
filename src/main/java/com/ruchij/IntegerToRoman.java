package com.ruchij;

import java.util.Objects;

public class IntegerToRoman {
    static final class NumberSet {
        private final char ones;
        private final char fives;
        private final char tens;

        NumberSet(char ones, char fives, char tens) {
            this.ones = ones;
            this.fives = fives;
            this.tens = tens;
        }

        public char ones() {
            return ones;
        }

        public char fives() {
            return fives;
        }

        public char tens() {
            return tens;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (NumberSet) obj;
            return this.ones == that.ones &&
                    this.fives == that.fives &&
                    this.tens == that.tens;
        }

        @Override
        public int hashCode() {
            return Objects.hash(ones, fives, tens);
        }

        @Override
        public String toString() {
            return "NumberSet[" +
                    "ones=" + ones + ", " +
                    "fives=" + fives + ", " +
                    "tens=" + tens + ']';
        }
    }

    public String intToRoman(int num) {
        NumberSet hundredNumberSet = new NumberSet('C', 'D', 'M');
        NumberSet tenNumberSet = new NumberSet('X', 'L', 'C');
        NumberSet oneNumberSet = new NumberSet('I', 'V', 'X');

        int ones = num % 10;
        int tens = (num % 100) / 10;
        int hundreds = (num % 1000) / 100;
        int thousands = num / 1000;

        String roman =
                repeat(thousands, String.valueOf(hundredNumberSet.tens)) +
                        numberToChar(hundredNumberSet, hundreds) +
                        numberToChar(tenNumberSet, tens) +
                        numberToChar(oneNumberSet, ones);

        return roman;
    }

    private String repeat(int count, String input) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < count; i++) {
            builder.append(input);
        }

        return builder.toString();
    }

    private String numberToChar(NumberSet numberSet, int number) {
        String ones = String.valueOf(numberSet.ones);
        String fives = String.valueOf(numberSet.fives);
        String tens = String.valueOf(numberSet.tens);

        switch (number) {
            case 1:
                return ones;

            case 2:
                return ones + ones;

            case 3:
                return ones + ones + ones;

            case 4:
                return ones + fives;

            case 5:
                return fives;

            case 6:
                return fives + ones;

            case 7:
                return fives + ones + ones;

            case 8:
                return fives + ones + ones + ones;

            case 9:
                return ones + tens;

            default:
                return "";
        }
    }
}
