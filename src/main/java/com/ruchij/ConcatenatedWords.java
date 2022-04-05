package com.ruchij;

import java.util.*;

public class ConcatenatedWords {
    static final class Trie {
        private String value;
        private Map<Character, Trie> children;

        Trie(String value, Map<Character, Trie> children) {
            this.value = value;
            this.children = children;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (Trie) obj;
            return Objects.equals(this.value, that.value) &&
                    Objects.equals(this.children, that.children);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, children);
        }

        @Override
        public String toString() {
            return "Trie[" +
                    "value=" + value + ", " +
                    "children=" + children + ']';
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie root = buildTrie(words);
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (findConcat(root, word, 0)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean findConcat(Trie root, String word, int count) {
        Trie current = root;

        for (int i = 0; i < word.length(); i++) {
            current = current.children.get(word.charAt(i));

            if (current == null) {
                return false;
            }

            if (current.value != null && i != word.length() - 1) {
                if (findConcat(root, word.substring(i + 1), count + 1)) {
                    return true;
                }
            }
        }

        return count > 0 && current.value != null;
    }

    private Trie buildTrie(String[] words) {
        Trie root = new Trie(null, new HashMap<>());

        for (String word : words) {
            addToTrie(root, word);
        }

        return root;
    }

    private void addToTrie(Trie trie, String word) {
        for (char character : word.toCharArray()) {
            trie = trie.children.computeIfAbsent(character, key -> new Trie(null, new HashMap<>()));
        }

        trie.value = word;
    }
}
