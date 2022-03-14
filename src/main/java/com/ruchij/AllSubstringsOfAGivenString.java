package com.ruchij;

import java.util.*;

public class AllSubstringsOfAGivenString {

    public int uniqueLetterString(String s) {
        List<Integer>[] charIndexes = group(s);
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            int character = s.charAt(i) - 'A';
            List<Integer> integers = charIndexes[character];

            int currentIndexPosition = Collections.binarySearch(integers, i);
            int startIndex = 0;
            int endIndex = s.length();

            if (currentIndexPosition != 0) {
                startIndex = integers.get(currentIndexPosition - 1) + 1;
            }

            if (currentIndexPosition < integers.size() - 1) {
                endIndex = integers.get(currentIndexPosition + 1);
            }

            int value = (endIndex - i) * (i - startIndex + 1);

            count += value;
        }

        return count;
    }

    private List<Integer>[] group(String input) {
        List<Integer>[] indexed = new List[26];

        for (int i = 0; i < input.length(); i++) {
            int character = input.charAt(i) - 'A';
            List<Integer> indexes = indexed[character];

            if (indexes == null) {
                indexes = new ArrayList<>();
            }

            indexes.add(i);
            indexed[character] = indexes;
        }

        return indexed;
    }
}
