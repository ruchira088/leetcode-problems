package com.ruchij;

import java.util.HashMap;
import java.util.Map;

public class LogLimiter {
    public class Logger {
        public Map<String, Integer> map = new HashMap<>();

        public Logger() {

        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            Integer last = map.get(message);

            if (last == null || last + 10 <= timestamp) {
                map.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        }
    }
}
