package com.ruchij;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TilePossibilities {
    public int numTilePossibilities(String tiles) {
        return possibilities(tiles).size() - 1;
    }

    Set<List<String>> possibilities(String letters) {
        ArrayList<Character> data = new ArrayList<>();

        for (Character character : letters.toCharArray()) {
            data.add(character);
        }

        return possibilities(data);
    }

    Set<List<String>> possibilities(List<Character> letters) {
        Set<List<String>> result = new HashSet<>();

        if (letters.isEmpty()) {
            List<String> empty = new ArrayList<>();
            result.add(empty);
        } else {
            for (Character character : letters) {
                ArrayList<Character> current = new ArrayList<>(letters);
                current.remove(character);

                Set<List<String>> rest = possibilities(current);
//                result.addAll(rest);

                for (List<String> word : rest) {
                    ArrayList<String> strings = new ArrayList<>(word);
                    strings.add(character.toString());
                    result.add(strings);
                }
            }
        }

        return result;
    }
}
