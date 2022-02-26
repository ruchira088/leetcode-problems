package com.ruchij;

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie {
    static class Trie {
        Map<Character, Trie> children = new HashMap<>();

        public Trie() {
        }

        public void insert(String word) {
            if (word.isEmpty()) {
                children.put(null, new Trie());
            } else {
                char head = word.charAt(0);
                Trie child = children.getOrDefault(head, new Trie());
                child.insert(word.substring(1));
                children.put(head, child);
            }
        }

        public boolean search(String word) {
            if (word.isEmpty()) {
                return children.containsKey(null);
            } else {
                char head = word.charAt(0);
                Trie child = children.get(head);

                return child != null && child.search(word.substring(1));
            }
        }

        public boolean startsWith(String prefix) {
            if (prefix.isEmpty()) {
                return true;
            } else {
                char head = prefix.charAt(0);
                Trie child = children.get(head);

                return child != null && child.startsWith(prefix.substring(1));
            }
        }
    }

}
