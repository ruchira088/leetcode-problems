package com.ruchij;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructDigitsFromEnglish {
    public String originalDigits(String input) {
        Map<Character, Integer> map = new HashMap<>(20);

        for (char character : input.toCharArray()) {
            Integer count = map.getOrDefault(character, 0);
            map.put(character, count + 1);
        }

        Integer twos = map.getOrDefault('w', 0);
        remove('o', twos, map);

        Integer fours = map.getOrDefault('u', 0);
        remove('o', fours, map);

        Integer sixes = map.getOrDefault('x', 0);
        remove('s', sixes, map);
        remove('i', sixes, map);

        Integer eights = map.getOrDefault('g', 0);
        remove('i', eights, map);
        remove('h', eights, map);

        Integer zeros = map.getOrDefault('z', 0);
        remove('o', zeros, map);

        Integer sevens = map.getOrDefault('s', 0);
        remove('v', sevens, map);

        Integer ones = map.getOrDefault('o', 0);

        Integer threes = map.getOrDefault('h', 0);

        Integer fives = map.getOrDefault('v', 0);
        remove('i', fives, map);

        Integer nines = map.getOrDefault('i', 0);

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;

        for (int count : List.of(zeros, ones, twos, threes, fours, fives, sixes, sevens, eights, nines)) {
            stringBuilder.append(String.valueOf(index).repeat(count));

            index++;
        }

        return stringBuilder.toString();
    }

    private void remove(char character, int count, Map<Character, Integer> map) {
        int current = map.getOrDefault(character, 0);
        map.put(character, current - count);
    }

}
