package com.ruchij;

import java.util.*;

public class ShortestWordDistance {
    class WordDistance {
        Map<String, List<Integer>> wordIndexes = new HashMap<>();

        public WordDistance(String[] wordsDict) {
            for (int i = 0; i < wordsDict.length; i++) {
                wordIndexes.computeIfAbsent(wordsDict[i], key -> new ArrayList<>()).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            int min = 30_000;
            List<Integer> indexesOne = wordIndexes.get(word1);
            List<Integer> indexesTwo = wordIndexes.get(word2);

            for (Integer one : indexesOne) {
                int last = 30_000;

                for (Integer two : indexesTwo) {
                    int current = Math.abs(one - two);

                    if (last < current) {
                        break;
                    } else {
                        min = Math.min(min, current);
                        last = current;
                    }

                }
            }

            return min;
        }
    }
}
