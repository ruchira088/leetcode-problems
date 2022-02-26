package com.ruchij;

public class MinimumWindowSubsequence {
    public String minWindow(String main, String match) {
        String result = "";
        String prefix = sameChar(match);

        for (int i = 0; i < main.length(); i++) {
            String currentMatch = match;
            int end = i + prefix.length() + 1;

            if (end < main.length() && main.substring(i + 1, end).equals(prefix)) {
                continue;
            }

            if (main.charAt(i) == match.charAt(0)) {
                for (int j = i; j < main.length(); j++) {
                    if (main.charAt(j) == currentMatch.charAt(0)) {
                        currentMatch = currentMatch.substring(1);

                        if (currentMatch.isEmpty()) {
                            String currentResult = main.substring(i, j + 1);

                            if (result.length() == 0 || result.length() > currentResult.length()) {
                                result = currentResult;
                            }

                            break;
                        }
                    }
                }
            }
        }

        return result;
    }

    private String sameChar(String input) {
        String result = "";

        for (char character : input.toCharArray()) {
            String ch = String.valueOf(character);

            if (result.isEmpty()) {
                result = ch;
            } else if (result.contains(ch)) {
                result = result + ch;
            } else {
                break;
            }
        }

        return result;
    }
}
