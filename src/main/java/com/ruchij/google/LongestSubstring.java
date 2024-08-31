package com.ruchij.google;

import java.util.*;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        ArrayDeque<Character> queue = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (!queue.contains(character)) {
                queue.add(character);
                longest = Math.max(longest, queue.size());
            } else {
                queue.add(character);
                boolean removed = false;

                while (!removed) {
                    Character current = queue.removeFirst();
                    removed = current == character;
                }
            }
        }

        return longest;
    }
}
