package com.ruchij;

import java.util.*;
import java.util.stream.Collectors;

public class LongestWordChain {

    public int longestStrChain(String[] words) {
        Map<String, Integer> memoization = new HashMap<>();
        int max = 0;

        Map<Integer, List<String>> wordsByLength =
                Arrays.stream(words).collect(Collectors.groupingBy(String::length));

        List<Integer> sortedLength = wordsByLength.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        for (Integer length: sortedLength) {
            List<String> strings = wordsByLength.get(length);
            List<String> nextWords = wordsByLength.getOrDefault(length + 1, List.of());

            for (String word: strings) {
                int maxChainSize =
                        nextWords.stream()
                                .filter(next -> isChain(word, next))
                                .mapToInt(next -> memoization.getOrDefault(next, 0))
                                .max()
                                .orElse(0) + 1;

                if (max < maxChainSize) {
                    max = maxChainSize;
                }

                memoization.put(word, maxChainSize);
            }
        }

        return max;
    }

    boolean isChain(String word, String next) {
        char[] wordChars = word.toCharArray();
        char[] nextChars = next.toCharArray();

        int j = 0;

        for (int i = 0; i < wordChars.length; i++) {
            if (wordChars[i] == nextChars[j]) {
                j++;
            } else if (j == i) {
                j++;

                if (wordChars[i] == nextChars[j]) {
                    j++;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;

    }
}
