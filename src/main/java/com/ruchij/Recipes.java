package com.ruchij;

import java.util.*;

public class Recipes {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> recipeMap = new HashMap<>();
        Set<String> suppliesSet = new HashSet<>(Arrays.asList(supplies));
        List<String> result = new ArrayList<>();

        for (int i = 0; i < recipes.length; i++) {
            recipeMap.put(recipes[i], ingredients.get(i));
        }

        for (String recipe : recipes) {
            if (canMakeRecipe(recipe, recipeMap, suppliesSet, new HashSet<>())) {
                result.add(recipe);
            }
        }

        return result;
    }

    private boolean canMakeRecipe(String recipe, Map<String, List<String>> recipeMap, Set<String> suppliesSet, Set<String> searches) {
        if (!suppliesSet.contains(recipe)) {
            if (searches.contains(recipe)) {
                return false;
            }

            searches.add(recipe);

            List<String> ingredients = recipeMap.get(recipe);

            if (ingredients == null) {
                return false;
            }

            for (String ingredient : ingredients) {
                if (!canMakeRecipe(ingredient, recipeMap, suppliesSet, searches)) {
                    return false;
                }
            }

            suppliesSet.add(recipe);

        }
        return true;
    }
}
