package com.ruchij;

import java.util.Map;

public class RomanToInteger {
    private final Map<Character, Integer> MAPPINGS =
            Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

    public int romanToInt(String s) {
        int number = 0;
        int index = 0;
        char[] charArray = s.toCharArray();

        while (index < charArray.length) {
            Integer current = MAPPINGS.get(charArray[index]);

            if(index != charArray.length - 1) {
                Integer next = MAPPINGS.get(charArray[index + 1]);

                if (next > current) {
                    number += (next - current);
                    index += 2;
                    continue;
                }
            }

            number += current;
            index++;
        }

        return number;
    }
}
