package com.ruchij;

import java.util.HashSet;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0;
        HashSet<Integer> visited = new HashSet<>();

        while (!visited.contains(i)) {
            visited.add(i);
            int trip = canDoWholeTrip(gas, cost, i);

            if (trip == -1) {
                return i;
            } else {
                if(trip + 1 == gas.length) {
                    i = 0;
                } else {
                    i = trip + 1;
                };
            }
        }

        return -1;
    }

    int canDoWholeTrip(int[] gas, int[] cost, int start) {
        int fuel = 0;
        int index = start;
        HashSet<Integer> visited = new HashSet<>();

        while (!visited.contains(index)) {
            visited.add(index);
            fuel += gas[index];
            fuel -= cost[index];

            if (fuel < 0) {
                return index;
            }

            index++;

            if (index == gas.length) {
                index = 0;
            }
        }

        return -1;
    }
}
