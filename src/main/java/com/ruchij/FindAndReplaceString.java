package com.ruchij;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FindAndReplaceString {
    static final class Replacement {
        private final String world;
        private final int length;

        Replacement(String replacement, int length) {
            this.world = replacement;
            this.length = length;
        }

        public String replacement() {
            return world;
        }

        public int length() {
            return length;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (Replacement) obj;
            return Objects.equals(this.world, that.world) &&
                    this.length == that.length;
        }

        @Override
        public int hashCode() {
            return Objects.hash(world, length);
        }

        @Override
        public String toString() {
            return "Replacement[" +
                    "replacement=" + world + ", " +
                    "length=" + length + ']';
        }
    }

    public String findReplaceString(String string, int[] indices, String[] sources, String[] targets) {
        Map<Integer, Replacement> mappings = new HashMap<>();

        for (int i = 0; i < indices.length; i++) {
            int start = indices[i];
            String source = sources[i];
            String existing = string.substring(start, start + source.length());

            if (source.equals(existing)) {
                mappings.put(start, new Replacement(targets[i], source.length()));
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        int index = 0;

        while (index < string.length()) {
            Replacement replacement = mappings.getOrDefault(index, new Replacement(String.valueOf(string.charAt(index)), 1));
            stringBuilder.append(replacement.world);
            index += replacement.length;
        }

        return stringBuilder.toString();
    }
}
