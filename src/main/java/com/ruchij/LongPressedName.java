package com.ruchij;

public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int index = 0;

        for (int i = 0; i < typed.length(); i++) {
            if (name.charAt(Math.min(index, name.length() - 1)) == typed.charAt(i)) {
                index++;
            } else if (index > 0) {
                if (index >= name.length() || name.charAt(index - 1) != typed.charAt(i)) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return index >= name.length();
    }
}
