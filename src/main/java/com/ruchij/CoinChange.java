package com.ruchij;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Objects;

public class CoinChange {
    static final class State {
        private final int coinCount;
        private final int remaining;

        State(int coinCount, int remaining) {
            this.coinCount = coinCount;
            this.remaining = remaining;
        }

        public int coinCount() {
            return coinCount;
        }

        public int remaining() {
            return remaining;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (State) obj;
            return this.coinCount == that.coinCount &&
                    this.remaining == that.remaining;
        }

        @Override
        public int hashCode() {
            return Objects.hash(coinCount, remaining);
        }

        @Override
        public String toString() {
            return "State[" +
                    "coinCount=" + coinCount + ", " +
                    "remaining=" + remaining + ']';
        }
    }

    public int coinChange(int[] coins, int amount) {
        ArrayDeque<State> queue = new ArrayDeque<>();
        queue.add(new State(0, amount));
        HashMap<Integer, Integer> minCoins = new HashMap<>();

        while (!queue.isEmpty()) {
            State state = queue.pop();

            if (state.remaining == 0) {
                return state.coinCount;
            } else {
                Integer min = minCoins.get(state.remaining);

                if (min == null || min >= state.coinCount) {
                    for (int coin : coins) {
                        int remaining = state.remaining - coin;

                        Integer currentMinimum = minCoins.get(remaining);

                        if (remaining >= 0 && (currentMinimum == null || currentMinimum > state.coinCount + 1)) {
                            queue.add(new State(state.coinCount + 1, remaining));
                            minCoins.put(remaining, state.coinCount + 1);
                        }
                    }
                }
            }
        }

        return -1;
    }
}
