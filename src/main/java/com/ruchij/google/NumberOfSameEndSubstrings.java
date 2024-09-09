package com.ruchij.google;

import java.util.HashMap;

public class NumberOfSameEndSubstrings {
    public int[] sameEndSubstringCount(String s, int[][] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < answer.length; i++) {
            int[] query = queries[i];
            answer[i] = sameEndSubstringCount(s, query[0], query[1]);
        }

        return answer;
    }

    int sameEndSubstringCount(String s, int start, int end) {
        int count = 0;
        String string = s.substring(start, end + 1);
        HashMap<Character, Integer> characters = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            Character character = string.charAt(i);
            Integer existing = characters.getOrDefault(character, 0);
            characters.put(character, existing + 1);
        }

        for (Integer i : characters.values()) {
            count += (i * (i + 1))/2;
        }

        return count;
    }
}
