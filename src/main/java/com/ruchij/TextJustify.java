package com.ruchij;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TextJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<List<String>> result = new ArrayList<>();
        LinkedList<String> line = new LinkedList<>();

        for (String word: words) {
            int length = minLineLength(line);

            if (line.isEmpty() || length + 1 + word.length() <= maxWidth) {
                line.add(word);
            } else {
                result.add(line);
                line = new LinkedList<>();
                line.add(word);
            }
        }

        result.add(line);

        return consolidate(result, maxWidth);
    }

    private List<String> consolidate(List<List<String>> lines, int maxWidth) {
        List<String> result = new LinkedList<>();

        while (lines.size() > 1) {
            List<String> line = lines.remove(0);
            result.add(justify(line, maxWidth));
        }

        if (!lines.isEmpty()) {
            List<String> lastLine = lines.remove(0);
            StringBuilder builder = new StringBuilder();

            for (String word: lastLine) {
                builder.append(word);
                builder.append(" ");
            }

            String line = builder.toString().trim();

            result.add(line + repeat(" ", maxWidth - line.length()));
        }


        return result;
    }

    private String justify(List<String> line, int maxWidth) {
        int length = line.stream().mapToInt(String::length).sum();
        int whiteSpace = maxWidth - length;

        int wordCount = line.size();

        if (wordCount == 1) {
            String word = line.get(0);

            return word + repeat(" ", maxWidth - word.length());
        } else {
            int spaces = wordCount - 1;

            int spaceSize = whiteSpace / spaces;
            int remaining = whiteSpace - (spaceSize * spaces);

            StringBuilder builder = new StringBuilder();

            for (String word : line) {
                builder.append(word);
                builder.append(repeat(" ", spaceSize));

                if (remaining > 0) {
                    builder.append(" ");
                    remaining--;
                }
            }

            return builder.toString().trim();
        }
    }

    private String repeat(String input, int repeat) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < repeat; i++) {
            result.append(input);
        }

        return result.toString();
    }

    private int minLineLength(List<String> line) {
        int length = 0;

        for (String word: line) {
            length += word.length();
            length += 1;
        }

        length += -1;

        return Math.max(length, 0);
    }
}
