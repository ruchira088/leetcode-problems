package com.ruchij;

import java.util.HashMap;
import java.util.HashSet;

public class MaximumNumberOfOccurrencesOfSubstring {
    public int maxFreq(String input, int maxLetters, int minSize, int maxSize) {
        int max = 0;
        HashMap<String, Integer> wordCount = new HashMap<>();

        for (int i = 0; i <= input.length() - minSize; i++) {
            String substring = input.substring(i, i + minSize);

            if (uniqueLetters(substring) <= maxLetters) {
                int count = wordCount.getOrDefault(substring, 0) + 1;
                wordCount.put(substring, count);

                if (count > max) {
                    max = count;
                }
            }
        }

        return max;
    }

    int uniqueLetters(String input) {
        HashSet<Character> characters = new HashSet<>();

        for (char character : input.toCharArray()) {
            characters.add(character);
        }

        return characters.size();
    }
}
