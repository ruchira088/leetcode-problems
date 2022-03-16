package com.ruchij;

import java.util.*;

public class AmazonCoins {

    record State(int remaining, Map<Integer, Integer> availableCoins, Map<Integer, Integer> usedCoins) { }

    Map<Integer, Integer> provideChange(Map<Integer, Integer> coins, int amount) {
        ArrayDeque<State> queue = new ArrayDeque<>();
        Set<Map<Integer, Integer>> visited = new HashSet<>();
        queue.add(new State(amount, coins, new HashMap<>()));

        while (!queue.isEmpty()) {
            State state = queue.poll();

            if (state.remaining == 0) {
                return state.usedCoins;
            }

            if (!visited.contains(state.usedCoins)) {
                visited.add(state.usedCoins);

                for (Map.Entry<Integer, Integer> entry : state.availableCoins.entrySet()) {
                    if (entry.getValue() > 0 && entry.getKey() <= state.remaining) {
                        Map<Integer, Integer> updated = new HashMap<>(state.availableCoins);
                        updated.put(entry.getKey(), updated.get(entry.getKey()) - 1);

                        Map<Integer, Integer> updatedUsed = new HashMap<>(state.usedCoins);
                        updatedUsed.put(entry.getKey(), updatedUsed.getOrDefault(entry.getKey(), 0) + 1);

                        queue.add(new State(state.remaining - entry.getKey(), updated, updatedUsed));
                    }

                }
            }

        }

        return null;
    }
}
