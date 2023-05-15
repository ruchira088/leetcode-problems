package com.ruchij;

import java.util.HashMap;
import java.util.Map;

public class MinimumRoundsToCompleteAllTasks {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = parse(tasks);
        int result = 0;

        for (Integer count : map.values()) {
            int turns = turns(count);

            if (turns < 0) {
                return -1;
            } else {
                result += turns;
            }
        }

        return result;
    }

    int turns(int number) {
        if (number < 2) {
            return -1;
        }

        int threeDivided = number / 3;
        int threeMod = number % 3;

        if (threeMod == 0) {
            return threeDivided;
        } else {
            return threeDivided + 1;
        }
    }

    Map<Integer, Integer> parse(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int task : tasks) {
            int count = map.getOrDefault(task, 0);
            map.put(task, count + 1);
        }

        return map;
    }
}
