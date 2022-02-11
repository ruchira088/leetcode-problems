package com.ruchij;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoDistinctChars {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        List<Character> characters = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        int max = 0;

        for (Character character: s.toCharArray()) {
            boolean contains = set.contains(character);
            if (set.size() < 2 || contains) {
                characters.add(character);
                if (!contains) {
                    set.add(character);
                }
            } else {
                int size = characters.size();

                if (size > max) {
                    max = size;
                }

                Character last = characters.get(size - 1);
                List<Character> newCharacters = new ArrayList<>();

                for (int i = size - 1; i >= 0; i--) {
                    if (characters.get(i) == last) {
                        newCharacters.add(characters.get(i));
                    } else {
                        break;
                    }
                }

                characters = newCharacters;
                newCharacters.add(character);
                set = Set.of(character, last);
            }
        }

        return Math.max(max, characters.size());

    }
}
