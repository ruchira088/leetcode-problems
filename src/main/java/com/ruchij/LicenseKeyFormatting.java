package com.ruchij;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder result = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = s.toCharArray();

        for (int i = s.length() - 1; i >= 0; i--) {
            char character = charArray[i];

            if (character != '-') {
                stringBuilder.append(character);

                if (stringBuilder.length() == k) {
                    if (!result.isEmpty()) {
                        result.append('-');
                    }

                    result.append(stringBuilder);

                    stringBuilder = new StringBuilder();
                }
            }
        }

        if (!stringBuilder.isEmpty()) {
            if (!result.isEmpty()) {
                result.append('-');
            }

            result.append(stringBuilder);
        }

        return result.reverse().toString().toUpperCase();
    }
}
