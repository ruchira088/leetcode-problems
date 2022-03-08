package com.ruchij;

import java.util.*;
import java.util.stream.Collectors;

public class SubstringConcatenationAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        List<Integer> indexes = new ArrayList<>();
        Map<String, Integer> target = group(words);
        Map<String, Integer> state = new HashMap<>();
        int index = 0;
        boolean queueIsFull = false;
        int wordCount = words.length;
        int wordLength = words[0].length();
        List<String> terms = split(s, wordLength, Arrays.stream(words).collect(Collectors.toSet()));

        for (String word : terms) {
            if (queueIsFull || queue.size() == wordCount) {
                queueIsFull = true;
                String remove = queue.pop();

                int current = state.get(remove);

                if (current == 1) {
                    state.remove(remove);
                } else {
                    state.put(remove, current - 1);
                }
            }

            queue.add(word);

            state.put(word, state.getOrDefault(word, 0) + 1);

            index += word.length();

            if (state.equals(target)) {
                indexes.add(index - wordCount * wordLength);
            }
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

    List<String> split(String input, int size, Set<String> words) {
        ArrayList<String> list = new ArrayList<>();
        int index = 0;

        while (index < input.length()) {
            String word = input.substring(index, Math.min(index + size, input.length()));

            if (words.contains(word)) {
                list.add(word);
                index += size;
            } else {
                list.add(input.substring(index, index + 1));
                index++;
            }
        }

        return list;
    }
}
