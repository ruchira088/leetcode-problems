package com.ruchij.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSpecialSubstringThrice {
    public int maximumLength(String s) {
        Map<Character, List<Integer>> characterMap = summary(s);
        int result = -1;

        for (List<Integer> positions : characterMap.values()) {
            result = Math.max(result, findSpecialSubstringCount(positions));
        }

        return result;
    }

    private int findSpecialSubstringCount(List<Integer> positions) {
        if (positions.size() < 3) {
            return -1;
        } else {
            int length = 1;
            boolean exit = false;

            while (!exit) {
                int count = 0;

                for (int i = 0; i < positions.size(); i++) {
                    int index = positions.get(i);

                    int current = 1;
                    for (int j = i + 1; j < positions.size(); j++) {
                        if (index + 1 == positions.get(j)) {
                           index++;
                           current++;

                           if (current == length + 1) {
                               count++;
                               break;
                           }
                        } else {
                            break;
                        }
                    }

                    if (count == 3) {
                        break;
                    }
                }

                if (count == 3) {
                    length++;
                } else {
                    exit = true;
                }
            }


            return length;
        }
    }

    private Map<Character, List<Integer>> summary(String input) {
        HashMap<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            List<Integer> positions = map.computeIfAbsent(c, __ -> new ArrayList<>());
            positions.add(i);
        }

        return map;
    }

}
