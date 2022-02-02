package com.ruchij;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strings) {
        String common = null;

        for (String word: strings) {
            if (common == null) {
                common = word;
            } else if (common.equals("")) {
                break;
            } else {
                common = commonPrefix(word, common);
            }
        }

        return common == null ? "" : common;
    }

    private String commonPrefix(String wordOne, String wordTwo) {
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();

        while (index < wordOne.length() && index < wordTwo.length()) {
            if (wordOne.charAt(index) == wordTwo.charAt(index)) {
                stringBuilder.append(wordOne.charAt(index));
                index++;
            } else {
                break;
            }
        }

        return stringBuilder.toString();
    }
}
