package com.ruchij;

import java.util.ArrayDeque;
import java.util.HashSet;

public class CoinChangeTwo {
    record State(int coins, int amount) {}

    public int coinChange(int[] coins, int amount) {
        ArrayDeque<State> queue = new ArrayDeque<>();
        queue.add(new State(0, amount));

        HashSet<Integer> seenBefore = new HashSet<>();

        while (!queue.isEmpty()) {
            State state = queue.pop();

            if (state.amount == 0) {
                return state.coins;
            }

            if (!seenBefore.contains(state.amount)) {
                seenBefore.add(state.amount);

                for (int coin : coins) {
                    int remaining = state.amount - coin;

                    if (remaining >= 0) {
                        queue.add(new State(state.coins() + 1, remaining));
                    }
                }
            }
        }

        return -1;
    }
}
