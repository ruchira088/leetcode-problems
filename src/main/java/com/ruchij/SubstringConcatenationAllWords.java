package com.ruchij;

import java.util.*;

public class SubstringConcatenationAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indexes = new ArrayList<>();
        Map<String, Integer> target = group(words);
        int index = 0;
        int wordCount = words.length;
        int wordLength = words[0].length();
        int totalLength = wordLength * wordCount;

        while (index < s.length()) {
           String substring = s.substring(index, Math.min(index + totalLength, s.length()));

           if (substring.length() < totalLength) {
               break;
           }

           if (split(substring, wordLength).equals(target)) {
               indexes.add(index);
           }

           index++;
        }

        return indexes;
    }

    Map<String, Integer> group(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        return map;
    }

    Map<String, Integer> split(String input, int size) {
        Map<String, Integer> map = new HashMap<>();

        while (!input.isEmpty()) {
            int end = Math.min(size, input.length());
            String word = input.substring(0, end);
            map.put(word, map.getOrDefault(word, 0) + 1);
            input = input.substring(end);
        }


        return map;
    }
}
