package com.ruchij;

public class NeedleStack {
    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }

        for (int i = 0; i < haystack.length(); i++) {
            if (compare(haystack, needle, i)) {
                return i;
            }
        }

        return -1;
    }

    boolean compare(String haystack, String needle, int index) {
        String word = haystack.substring(index, Math.min(haystack.length(), index + needle.length()));

        return word.equals(needle);
    }
}
