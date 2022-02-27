package com.ruchij;

import java.util.*;
import java.util.stream.Collectors;

public class PrefixSuffixSearch {
    static class WordFilter {
        class Trie {
            Map<Character, Trie> children = new HashMap<>();

            public void insert(String word) {
                if (word.isEmpty()) {
                    this.children.put(null, new Trie());
                } else {
                    Character head = word.charAt(0);

                    Trie child = children.getOrDefault(head, new Trie());
                    child.insert(word.substring(1));

                    children.put(head, child);
                }
            }

            public Trie findPrefix(String prefix) {
                if (prefix.isEmpty()) {
                    return this;
                } else {
                    Character head = prefix.charAt(0);

                    Trie child = children.get(head);

                    if (child != null) {
                        return child.findPrefix(prefix.substring(1));
                    } else {
                        return null;
                    }
                }
            }

            public Set<String> values() {
                HashSet<String> hashSet = new HashSet<>();

                for (Map.Entry<Character, Trie> entry : children.entrySet()) {
                    if (entry.getKey() == null) {
                        hashSet.add("");
                    } else {
                        for (String value : entry.getValue().values()) {
                            hashSet.add(entry.getKey() + value);
                        }
                    }
                }

                return hashSet;
            }

        }

        Trie trie = new Trie();
        Map<String, Integer> cache = new HashMap<>();
        String[] words;

        public WordFilter(String[] words) {
            for (int i = 0; i < words.length; i++) {
                terms(words[i]).forEach(trie::insert);
            }

            this.words = words;
        }

        public int f(String prefix, String suffix) {
            String searchTerm = suffix + "-" + prefix;

            Integer integer = this.cache.get(searchTerm);

            if (integer != null) {
                return integer;
            }

            Trie trie = this.trie.findPrefix(searchTerm);

            if (trie == null) {
                this.cache.put(searchTerm, -1);

                return -1;
            } else {
                int index = -1;

                Set<String> matches = trie.values().stream()
                        .map(term -> prefix + term)
                        .collect(Collectors.toSet());

                for (int i = 0; i < words.length; i++) {
                    if (matches.contains(words[i])) {
                        index = i;
                    }
                }

                this.cache.put(searchTerm, index);

                return index;
            }
        }

        private Set<String> terms(String word) {
            HashSet<String> result = new HashSet<>();

            for (int i = 0; i <= word.length(); i++) {
                result.add(word.substring(i) + "-" + word);
            }

            return result;
        }
    }
}
