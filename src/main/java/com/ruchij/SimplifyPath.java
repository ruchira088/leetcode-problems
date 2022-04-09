package com.ruchij;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String stringPath) {
        Stack<String> filePath = new Stack<>();
        String[] names = stringPath.split("/");

        for (String name : names) {
            if (!name.isEmpty()) {
                if (name.equals("..") && !filePath.isEmpty()) {
                    filePath.pop();
                } else if (!name.equals("..") && !name.equals(".")) {
                    filePath.push(name);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (String path : filePath) {
            stringBuilder.append("/");
            stringBuilder.append(path);
        }

        return stringBuilder.isEmpty() ? "/" : stringBuilder.toString();
    }
}
