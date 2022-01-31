package com.ruchij;

public class MinimumParenthesisRemoved {
    public String minRemoveToMakeValid(String string) {
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                count++;
                stringBuilder.append('(');
            } else if (string.charAt(i) == ')') {
                if (count > 0) {
                    count--;
                    stringBuilder.append(')');
                }
            } else {
                stringBuilder.append(string.charAt(i));
            }
        }

        while (count > 0) {
            int index = stringBuilder.lastIndexOf("(");
            stringBuilder.deleteCharAt(index);
            count--;
        }

        return stringBuilder.toString();
    }
}
