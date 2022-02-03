package com.ruchij;

import java.util.HashSet;
import java.util.Set;

public class NumberOfMatchingSubSequences {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        Set<String> found = new HashSet<>();
        Set<String> notFound = new HashSet<>();

        for (String word: words) {
            if (!notFound.contains(word) && (found.contains(word) || isMatch(s, word))) {
                count++;
                found.add(word);
            } else {
                notFound.add(word);
            };
        }

        return count;
    }

    public boolean isMatch(String parent, String word) {
        for (int i = 0; i < parent.length(); i++) {
            if (word.equals("")) {
                return true;
            } else if (word.charAt(0) == parent.charAt(i)) {
                word = word.substring(1);
            }
        }

        return word.equals("");
    }
}
