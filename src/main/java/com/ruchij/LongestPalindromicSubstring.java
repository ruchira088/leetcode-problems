package com.ruchij;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int j = i; j < s.length(); j++) {
                stringBuilder.append(s.charAt(j));

                String word = stringBuilder.toString();

                if (word.length() > longest.length() && isPalindrome(word)) {
                    longest = word;
                }
            }
        }

        return longest;
    }

    boolean isPalindrome(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
