package com.ruchij.google;

public class MergeStringsAlternatively {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();
        int limit = Math.min(word1.length(), word2.length());

        for (int i = 0; i < limit; i++) {
            stringBuilder.append(word1.charAt(i));
            stringBuilder.append(word2.charAt(i));
        }

        if (word1.length() == limit) {
            stringBuilder.append(word2.substring(limit));
        } else {
            stringBuilder.append(word1.substring(limit));
        }

        return stringBuilder.toString();
    }
}
