package com.ruchij;

public class ValidPalindrome {
    public boolean validPalindrome(String input) {
        String reversed = reverse(input);

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != reversed.charAt(i)) {
                return isPalindrome(input, reversed, i) || isPalindrome(reversed, input, i);
            }
        }

        return true;
    }

    private boolean isPalindrome(String input, String reversed, int index) {
        String updatedInput = input.substring(0, index) + input.substring(index + 1);
        String updatedReversed = reversed.substring(0, reversed.length() - index - 1) + reversed.substring(reversed.length() - index);

        return updatedInput.equals(updatedReversed);
    }

    private String reverse(String input) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = input.length() - 1; i >= 0; i--) {
            stringBuilder.append(input.charAt(i));
        }

        return stringBuilder.toString();
    }
}
