package com.ruchij.google;

import java.util.ArrayDeque;
import java.util.HashSet;

public class CoinChange {
    record State(int coinCount, int remaining) {}

    public int coinChange(int[] coins, int amount) {
        ArrayDeque<State> queue = new ArrayDeque<>();
        queue.add(new State(0, amount));
        HashSet<Integer> seen = new HashSet<>();

        while (!queue.isEmpty()) {
            State state = queue.poll();

            if (state.remaining == 0) {
                return state.coinCount;
            }

            if (state.remaining > 0 && !seen.contains(state.remaining)) {
                seen.add(state.remaining);

                for (int coin : coins) {
                    State newState = new State(state.coinCount + 1, state.remaining - coin);
                    queue.add(newState);
                }
            }
        }

        return -1;
    }
}
