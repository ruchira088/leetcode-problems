package com.ruchij.google;

import java.util.*;

public class CoinChangeII {
    record State(Map<Integer, Integer> coins, int total) {}

    record Entry(int amount, int index) {}

    public int change(int amount, int[] coins) {
        return change(amount, coins, 0, new HashMap<>());
    }

    private int change(int amount, int[] coins, int index, Map<Entry, Integer> cache) {
        if (cache.containsKey(new Entry(amount, index))) {
            return cache.get(new Entry(amount, index));
        } else if (amount == 0) {
            return 1;
        } else if (amount < 0) {
            return 0;
        } else {
            int count = 0;
            for (int i = index; i < coins.length; i++) {
                count += change(amount - coins[i], coins, i, cache);
            }

            cache.put(new Entry(amount, index), count);

            return count;
        }
    }


    public int changeIII(int amount, int[] coins) {
        ArrayList<Integer> amounts = new ArrayList<>();
        amounts.add(0);
        int count = 0;

        for (int coin : coins) {
            ArrayList<Integer> temp = new ArrayList<>(amounts);
            amounts = new ArrayList<>();
            for (int num : temp) {
                int remaining = amount - num;

                if (remaining == 0) {
                    count++;
                } else if (remaining > 0) {
                    int max = remaining / coin;
                    for (int j = 0; j <= max; j++) {
                        amounts.add(num + coin * j);
                    }
                }
            }
        }

        for (int num : amounts) {
            if (num == amount) {
                count++;
            }
        }

        return count;
    }


    public int change2(int amount, int[] coins) {
        ArrayDeque<State> queue = new ArrayDeque<>();
        queue.add(new State(new HashMap<>(), 0));
        HashSet<Map<Integer, Integer>> seen = new HashSet<>();

        int total = 0;

        while (!queue.isEmpty()) {
            State state = queue.poll();

            if (state.total <= amount && !seen.contains(state.coins)) {
                seen.add(state.coins);
                if (state.total == amount) {
                    total++;
                } else {
                    for (int coin : coins) {
                        HashMap<Integer, Integer> updatedCoins = new HashMap<>(state.coins);
                        updatedCoins.put(coin, updatedCoins.getOrDefault(coin, 0) + 1);
                        queue.add(new State(updatedCoins, state.total + coin));
                    }
                }
            }

        }

        return total;
    }
}
