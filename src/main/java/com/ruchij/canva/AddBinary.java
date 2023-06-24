package com.ruchij.canva;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        String reversedA = new StringBuilder(a).reverse().toString();
        String reversedB = new StringBuilder(b).reverse().toString();

        int carry = 0;

        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            int x = a.length() > i ? parse(reversedA.charAt(i)) : 0;
            int y = b.length() > i ? parse(reversedB.charAt(i)) : 0;

            int sum = x + y + carry;
            carry = sum >= 2 ? 1 : 0;
            stringBuilder.append(sum % 2);
        }

        if (carry != 0) {
            stringBuilder.append(carry);
        }

        return stringBuilder.reverse().toString();

    }

    private int parse(char character) {
        if (character == '1') {
            return 1;
        } else {
            return 0;
        }
    }
}
