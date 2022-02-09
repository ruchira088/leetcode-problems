package com.ruchij;

public class SubstringMatching {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            String subString = s.substring(0, i);
            String remaining = s.substring(i);

            if (remaining.startsWith(subString)) {
                String result = s.replace(subString, "");

                if (result.contentEquals("")) {
                    return true;
                }
            }
        }

        return false;
    }
}
