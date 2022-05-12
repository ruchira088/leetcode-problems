package com.ruchij;

public class MinAddToMakeValid {

    public int minAddToMakeValid(String s) {
        char[] chars = s.toCharArray();
        int state = 0;
        int count = 0;

        for (int i = 0; i < chars.length; i++) {
            char character = chars[i];

            if (character == '(') {
                state++;
            } else {
                state--;

                if (state < 0) {
                    count++;
                    state = 0;
                }
            }
        }

        return state + count;
    }

}
