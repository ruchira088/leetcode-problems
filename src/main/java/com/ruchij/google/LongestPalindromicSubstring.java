package com.ruchij.google;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (longest.length() < j - i) {
                    String term = s.substring(i, j);

                    if (isPalindrome(term)) {
                        longest = term;
                    }
                }
            }
        }

        return longest;
    }

    private boolean isPalindrome(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
