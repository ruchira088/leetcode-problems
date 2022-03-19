package com.ruchij;

import java.util.*;

public class WordLadder {
    static final class Trie {
        private String value;
        private final Map<Character, Trie> children;

        Trie(String value, Map<Character, Trie> children) {
            this.value = value;
            this.children = children;
        }

        @Override
        public String toString() {
            return "Trie[" +
                    "value=" + value + ", " +
                    "children=" + children + ']';
        }
    }

    record State(String word, int count) { }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Trie trie = new Trie(null, new HashMap<>());

        for (String word : wordList) {
            addToTrie(trie, 0, word);
        }

        ArrayDeque<State> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.add(new State(beginWord, 1));

        while (!queue.isEmpty()) {
            State state = queue.pop();

            if (state.word.equals(endWord)) {
                return state.count;
            } else if (!visited.contains(state.word)) {
                visited.add(state.word);

                for (String neighbour : neighbours(trie, state.word)) {
                    if (!visited.contains(neighbour)) {
                        queue.add(new State(neighbour, state.count + 1));
                    }
                }

            }
        }

        return 0;
    }

    void addToTrie(Trie trie, int index, String word) {
        if (word.length() > index) {
            char head = word.charAt(index);
            Trie child = trie.children.computeIfAbsent(head, x -> new Trie(null, new HashMap<>()));
            addToTrie(child, index + 1, word);
        } else {
            trie.value = word;
        }
    }

    Set<String> neighbours(Trie trie, String word) {
        Set<String> words = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            words.addAll(neighbours(trie, word, 0, i));
        }

        return words;
    }

    Set<String> neighbours(Trie trie, String word, int index, int diffIndex) {
        Set<String> words = new HashSet<>();

        if (word.length() > index) {
            char head = word.charAt(index);

            if (index != diffIndex) {
                Trie child = trie.children.get(head);

                if (child != null) {
                    return neighbours(child, word, index + 1, diffIndex);
                }
            } else {
                for (Map.Entry<Character, Trie> entry : trie.children.entrySet()) {
                    if (entry.getKey() != head) {
                        words.addAll(neighbours(entry.getValue(), word, index + 1, diffIndex));
                    }
                }
            }
        } else if (trie.value != null) {
            words.add(trie.value);
        }

        return words;
    }


}
