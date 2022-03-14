package com.ruchij;

import java.util.HashMap;
import java.util.Map;

public class AllSubstringsOfAGivenString {

    public int uniqueLetterString(String s) {
        int count = 0;
        Map<String, Integer> cache = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String input = s.substring(i, j);
                Integer result = cache.get(input);

                if (result == null) {
                    result = countUniqueChars(input);
                    cache.put(input, result);
                }

                count += result;
            }
        }

        return count;
    }

    private int countUniqueChars(String input) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char character : input.toCharArray()) {
            map.put(character, map.getOrDefault(character, 0) + 1);
        }

        return map.values().stream().filter(count -> count == 1).mapToInt(value -> value).sum();
    }
}
