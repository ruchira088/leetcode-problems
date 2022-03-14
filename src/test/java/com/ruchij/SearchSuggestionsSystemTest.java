package com.ruchij;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchSuggestionsSystemTest {
    private final SearchSuggestionsSystem searchSuggestionsSystem = new SearchSuggestionsSystem();

    @Test
    void testOne() {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        System.out.println(searchSuggestionsSystem.suggestedProducts(products, "mouse"));
    }

}