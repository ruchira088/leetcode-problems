package com.ruchij.google;

import java.util.ArrayList;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int length = s.length();
        String longest = "";

        for (int i = 0; i < length; i++) {
            boolean odd = true;
            boolean even = true;
            for (int d = 0; d <= length / 2; d++) {
                int left = i - d;
                ArrayList<Integer> list = new ArrayList<>();

                if (odd) {
                    list.add(0);
                }

                if (even) {
                    list.add(1);
                }

                for (int diff : list) {
                    int right = i + d + diff;

                    if ((diff == 0 && odd) || (diff == 1 && even)) {
                        if (left >= 0 && right < length) {
                            if (s.charAt(left) == s.charAt(right)) {
                                String term = s.substring(left, right + 1);

                                if (longest.length() < term.length()) {
                                    longest = term;
                                }
                            } else {
                                if (diff == 0) {
                                    odd = false;
                                } else {
                                    even = false;
                                }
                            }
                        }
                    }
                }

            }
        }

        return longest;
    }
}
