package com.ruchij;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String trimmed = s.trim();
        int lastIndex = trimmed.lastIndexOf(" ");

        return lastIndex == -1 ? trimmed.length() : trimmed.length() - (lastIndex + 1);
    }
}
