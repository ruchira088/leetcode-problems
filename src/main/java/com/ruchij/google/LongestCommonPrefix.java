package com.ruchij.google;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length != 0) {
            int index = 0;

            outer:
            while (index < strs[0].length()) {
                char character = strs[0].charAt(index);

                for (int i = 1; i < strs.length; i++) {
                    String word = strs[i];
                    if (word.length() <= index || word.charAt(index) != character) {
                        break outer;
                    }
                }

                index++;
            }

            return strs[0].substring(0, index);
        } else {
            return "";
        }
    }
}
