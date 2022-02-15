package com.ruchij;

import java.util.ArrayDeque;
import java.util.Set;

public class MinimumTicketCost {
    record State(int cost, int startIndex) {}

    public int mincostTickets(int[] days, int[] costs) {
        ArrayDeque<State> queue = new ArrayDeque<>();
        queue.add(new State(0, 0));

        int[] minCosts = new int[days.length + 1];
        int[] oneDay = {costs[0], 1};
        int[] sevenDay = {costs[1], 7};
        int[] thirtyDay = {costs[2], 30};
        Set<int[]> tickets = Set.of(oneDay, sevenDay, thirtyDay);

        while (!queue.isEmpty()) {
            State state = queue.pop();

            if (state.startIndex < days.length) {
                if (minCosts[state.startIndex] == 0 || minCosts[state.startIndex] >= state.cost) {
                    for (int[] ticket : tickets) {
                        int price = ticket[0];
                        int dayCount = ticket[1];

                        int limit = days[state.startIndex] + dayCount;
                        int next = state.startIndex;

                        while (next < days.length && days[next] < limit) {
                            next++;
                        }

                        State nextState = new State(state.cost + price, next);

                        if (minCosts[next] == 0 || minCosts[next] > nextState.cost) {
                            minCosts[next] = nextState.cost;
                            queue.add(nextState);
                        }
                    }
                }
            }
        }

        return minCosts[days.length];
    }
}
