package com.ruchij;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String number = String.valueOf(x);
        String reversed = reverse(number);

        return number.contentEquals(reversed);
    }

    private String reverse(String input) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = input.length() - 1; i >= 0; i--) {
            stringBuilder.append(input.charAt(i));
        }

        return stringBuilder.toString();
    }
}
