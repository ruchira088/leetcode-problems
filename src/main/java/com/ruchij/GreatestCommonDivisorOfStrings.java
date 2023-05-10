package com.ruchij;

public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String stringA, String stringB) {
        String mod = mod(stringA, stringB);

        if (mod.length() == 0) {
            return stringB;
        } else if (mod.equals(stringA) && mod(stringB, stringA).equals(stringB)) {
            return "";
        } else {
            return gcdOfStrings(stringB, mod);
        }
    }

    String mod(String stringA, String stringB) {
        if (stringA.startsWith(stringB)) {
            return mod(stringA.substring(stringB.length()), stringB);
        } else {
            return stringA;
        }
    }
}
