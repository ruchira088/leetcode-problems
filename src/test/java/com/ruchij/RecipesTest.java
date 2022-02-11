package com.ruchij;

import org.junit.jupiter.api.Test;

import java.util.List;

class RecipesTest {
    private final Recipes recipes = new Recipes();

    @Test
    void testOne() {
        String[] recipesArray = {"ju","fzjnm","x","e","zpmcz","h","q"};
        List<List<String>> ingredients =
                List.of(
                        List.of("d"),
                        List.of("hveml","f","cpivl"),
                        List.of("cpivl","zpmcz","h","e","fzjnm","ju"),
                        List.of("cpivl","hveml","zpmcz","ju","h"),
                        List.of("h","fzjnm","e","q","x"),
                        List.of("d","hveml","cpivl","q","zpmcz","ju","e","x"),
                        List.of("f","hveml","cpivl")
                );
        String[] supplies = {"f","hveml","cpivl","d"};

        recipes.findAllRecipes(recipesArray, ingredients, supplies);

    }

}