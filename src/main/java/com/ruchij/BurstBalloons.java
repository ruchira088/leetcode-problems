package com.ruchij;

import java.util.*;
import java.util.stream.Collectors;

public class BurstBalloons {

    public int maxCoins(int[] nums) {
        return maxCoins(Arrays.stream(nums).boxed().collect(Collectors.toList()), new HashMap<>(), 0);
    }

    public int maxCoins(List<Integer> balloons, Map<List<Integer>, Integer> mappings, int coins) {
        int max = coins;

        int size = balloons.size();

        for (int i = 0; i < size; i++) {
            ArrayList<Integer> updatedBalloons = new ArrayList<>(balloons);
            Integer popped = updatedBalloons.remove(i);

            int left = i == 0 ? 1 : balloons.get(i - 1);
            int right = i == size - 1 ? 1 : balloons.get(i + 1);

            int updated = coins + left * popped * right;

            int result = maxCoins(updatedBalloons, mappings, updated);
            max = Math.max(max, result);

            mappings.put(updatedBalloons, result);
        }

        return max;
    }
}
