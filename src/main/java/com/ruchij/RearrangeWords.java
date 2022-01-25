package com.ruchij;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RearrangeWords {
    public String reorderSpaces(String text) {
        Stream<String> characterStream = Arrays.stream(text.split(""));
        long spaceCount = characterStream.filter(character -> character.contentEquals(" ")).count();
        List<String> words =
                Arrays.stream(text.split(" ")).filter(word -> !word.trim().isEmpty()).collect(Collectors.toList());

        int wordCount = words.size();

        long spaceLength = wordCount <= 1 ? 0 : spaceCount / (wordCount - 1);
        long remainingSpaces = spaceCount - (wordCount - 1) * spaceLength;

        StringBuilder stringBuilder = new StringBuilder();

        for (String word : words) {
            stringBuilder.append(word);
            stringBuilder.append(repeat(" ", (int) spaceLength));
        }


        return stringBuilder.toString().trim() + repeat(" ", (int) remainingSpaces);
    }

    private String repeat(String input, int repeat) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.valueOf(input).repeat(Math.max(0, repeat)));

        return stringBuilder.toString();
    }
}
