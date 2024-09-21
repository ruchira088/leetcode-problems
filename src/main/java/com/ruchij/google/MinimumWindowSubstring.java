package com.ruchij.google;

import java.util.*;

public class MinimumWindowSubstring {
    record Entry(int index, char character) {}

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        } else {
            Map<Character, Integer> characterCount = characterCount(t);
            Set<Character> characters = new HashSet<>(characterCount.keySet());

            PriorityQueue<Entry> characterQueue = new PriorityQueue<>(Comparator.comparing(entry -> entry.index));
            Map<Character, List<Integer>> additional = new HashMap<>();

            String result = null;

            char[] charArray = s.toCharArray();

            for (int i = 0; i < charArray.length; i++) {
                char character = charArray[i];

                Integer count = characterCount.getOrDefault(character, 0);

                if (count > 0) {
                    characterQueue.add(new Entry(i, character));

                    if (count == 1) {
                        characterCount.remove(character);

                        if (characterCount.isEmpty() && characterQueue.peek() != null) {
                            result = s.substring(characterQueue.peek().index, i+1);
                        }
                    } else {
                        characterCount.put(character, count - 1);
                    }
                } else if (characters.contains(character)) {
                    if (characterQueue.peek() != null) {
                        Entry entry = characterQueue.peek();

                        if (entry.character == character) {
                            characterQueue.remove();
                            characterQueue.add(new Entry(i, character));

                            while (!characterQueue.isEmpty()) {
                                Entry peek = characterQueue.peek();
                                List<Integer> integers = additional.getOrDefault(peek.character, List.of());

                                if (!integers.isEmpty()) {
                                    Entry remove = characterQueue.remove();
                                    characterQueue.add(new Entry(integers.removeFirst(), remove.character));
                                } else {
                                    break;
                                }
                            }

                            String string = s.substring(characterQueue.peek().index, i+1);

                            if (characterCount.isEmpty() && result.length() >= string.length()) {
                                result = string;
                            }
                        } else {
                            List<Integer> integers = additional.computeIfAbsent(character, __ -> new ArrayList<>());
                            integers.add(i);
                        }
                    }
                }

            }

            return result == null ? "" : result;
        }
    }

    private Map<Character, Integer> characterCount(String input) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char character : input.toCharArray()) {
            int count = hashMap.getOrDefault(character, 0) + 1;
            hashMap.put(character, count);
        }

        return hashMap;
    }
}
