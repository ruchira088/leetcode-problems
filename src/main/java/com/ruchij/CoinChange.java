package com.ruchij;

import java.util.*;

public class CoinChange {
    record State(int coinCount, int remaining) { }

    public int coinChange(int[] coins, int amount) {
        ArrayDeque<State> queue = new ArrayDeque<>();
        queue.add(new State(0, amount));
        Set<Integer> count = new HashSet<>();

        while (!queue.isEmpty()) {
            State state = queue.pop();

            if (state.remaining == 0) {
                return state.coinCount;
            } else if (!count.contains(state.remaining)){
                count.add(state.remaining);

                for (int coin : coins) {
                    int remaining = state.remaining - coin;

                    if (remaining >= 0 && !count.contains(remaining)) {
                        queue.add(new State(state.coinCount + 1, remaining));
                    }
                }
            }
        }

        return -1;
    }
}
