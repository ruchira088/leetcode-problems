package com.ruchij;

public class CountBinarySubstrings {
    record Result(int index, int count) {}

    public int countBinarySubstrings(String s) {
        int count = 0;
        int index = 0;
        char[] chars = s.toCharArray();

        while (index < chars.length) {
            Result result = substrings(index, chars);
            index = result.index;
            count += result.count;
        }

        return count;
    }

    Result substrings(int index, char[] word) {
        int ones = 0;
        int zeros = 0;
        int count = 0;
        int next = word.length;
        char last = word[index];

        while (index < word.length) {
            char current = word[index];

            if (last == current || current == '1' && ones == 0 || current == '0' && zeros == 0) {
                if (current == '1') {
                    ones++;
                } else {
                    zeros++;
                }
            } else {
                break;
            }

            if (last != current) {
                next = index;
            }


            if (ones > 0 && zeros > 0) {
                if (current == '1' && ones > zeros || current == '0' && zeros > ones) {
                    break;
                }

                count++;
            }

            last = current;
            index++;
        }

        return new Result(next, count);
    }
}
