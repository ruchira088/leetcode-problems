package com.ruchij;

import java.util.*;

public class ReorderDataLogs {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digitLogs = new ArrayList<>();
        List<String> letterLogs = new ArrayList<>();

        for (String log : logs) {
            if (isLetterLog(log)) {
                letterLogs.add(log);
            } else {
                digitLogs.add(log);
            }
        }

        letterLogs.sort(Comparator.comparing(o -> ((String) o).substring(((String) o).indexOf(" ")))
                .thenComparing(string -> (String) string));

        letterLogs.addAll(digitLogs);

        return letterLogs.toArray(new String[0]);
    }

    private boolean isLetterLog(String log) {
        return !Character.isDigit(log.charAt(log.indexOf(" ") + 1));
    }
}
