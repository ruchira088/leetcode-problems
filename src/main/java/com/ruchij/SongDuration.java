package com.ruchij;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SongDuration {
    public int numPairsDivisibleBy60(int[] times) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int count = 0;

        for (int time : times) {
            int mod = time % 60;
            hashMap.put(mod, hashMap.getOrDefault(mod, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer mod = entry.getKey();

            if (!visited.contains(mod)) {
                visited.add(mod);

                int match = (60 - mod) % 60;
                long matches = (long) hashMap.getOrDefault(match, 0);
                visited.add(match);

                if ((mod == 0 || mod == 30) && matches > 0) {
                    count += matches * (matches - 1) / 2;
                } else {
                    count += matches * entry.getValue();
                }
            }
        }

        return count;
    }
}
