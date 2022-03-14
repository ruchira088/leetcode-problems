package com.ruchij;

import java.util.*;
import java.util.stream.Collectors;

public class SearchSuggestionsSystem {
    class Trie {
        Set<String> values = new HashSet<>();
        Map<Character, Trie> children = new HashMap<>();
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = buildTrie(products);
        List<List<String>> result = new ArrayList<>();

        for (int i = 1; i <= searchWord.length(); i++) {
            result.add(find(root, searchWord.substring(0, i)));
        }

        return result;
    }

    List<String> find(Trie trie, String word) {
        if (word.isEmpty()) {
            return trie.values.stream().sorted().limit(3).collect(Collectors.toList());
        } else {
            char head = word.charAt(0);

            Trie child = trie.children.get(head);

            if (child == null) {
                return List.of();
            } else {
                return find(child, word.substring(1));
            }
        }
    }

    Trie buildTrie(String[] products) {
        Trie root = new Trie();

        for (String product : products) {
            insert(root, product, 0);
        }

        return root;
    }

    void insert(Trie trie, String word, int index) {
        trie.values.add(word);

        if (word.length() > index) {
            char head = word.charAt(index);
            Trie child = trie.children.getOrDefault(head, new Trie());

            trie.children.put(head, child);

            insert(child, word, index + 1);
        }
    }
}
