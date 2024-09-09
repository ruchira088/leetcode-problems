package com.ruchij.google;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSameEndSubstrings {
    public int[] sameEndSubstringCount(String s, int[][] queries) {
        int[] answer = new int[queries.length];
        Map<Character, Integer>[] charMappings = mappings(s);

        for (int i = 0; i < answer.length; i++) {
            int[] query = queries[i];
            answer[i] = sameEndSubstringCount(charMappings, query[0], query[1] + 1);
        }

        return answer;
    }

    Map<Character, Integer>[] mappings(String input) {
        Map<Character, Integer>[] chars = new Map[input.length() + 1];
        chars[0] = new HashMap<>();
        HashMap<Character, Integer> characters = new HashMap<>();


        for (int i = 0; i < input.length(); i++) {
            Character character = input.charAt(i);
            Integer existing = characters.getOrDefault(character, 0);
            characters.put(character, existing + 1);
            chars[i + 1] = new HashMap<>(characters);
        }

        return chars;
    }

    int sameEndSubstringCount(Map<Character, Integer>[] mappings, int start, int end) {
        Map<Character, Integer> startChars = mappings[start];
        Map<Character, Integer> chars = new HashMap<>(mappings[end]);

        for (Map.Entry<Character, Integer> entry : startChars.entrySet()) {
            int diff = chars.get(entry.getKey()) - entry.getValue();

            if (diff == 0) {
                chars.remove(entry.getKey());
            } else {
                chars.put(entry.getKey(), diff);
            }
        }

        return calculate(chars);
    }

    int calculate(Map<Character, Integer> chars) {
        int count = 0;

        for (int i : chars.values()) {
            count += (i * (i + 1))/2;
        }

        return count;
    }
}
