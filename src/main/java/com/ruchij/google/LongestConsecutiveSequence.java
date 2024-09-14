package com.ruchij.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        return longestConsecutiveTwo(nums);
    }

    public int longestConsecutiveTwo(int[] nums) {
        HashMap<Integer, AtomicInteger> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                AtomicInteger plusOne = map.get(num + 1);
                AtomicInteger minusOne = map.get(num - 1);

                if (plusOne != null && minusOne != null) {
                    int value = plusOne.intValue() + minusOne.intValue() + 1;
                    AtomicInteger updated = new AtomicInteger(value);

                    int current = num + 1;
                    while (map.get(current) != null) {
                        map.put(current, updated);
                        current++;
                    }

                    current = num - 1;
                    while (map.get(current) != null) {
                        map.put(current, updated);
                        current--;
                    }

                    map.put(num, updated);
                } else if (plusOne != null) {
                    plusOne.incrementAndGet();
                    map.put(num, plusOne);
                } else if (minusOne != null) {
                    minusOne.incrementAndGet();
                    map.put(num, minusOne);
                } else {
                    map.put(num, new AtomicInteger(1));
                }
            }
        }

        int max = 0;

        for (AtomicInteger atomicInteger : map.values()) {
            max = Math.max(atomicInteger.get(), max);
        }

        return max;
    }

    public int longestConsecutiveOne(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else {
            int[] ints = Arrays.copyOf(nums, nums.length);
            Arrays.sort(ints);
            int current = ints[0];
            int count = 1;
            int max = 1;

            for (int i = 1; i < ints.length; i++) {
                int value = ints[i];

                if (current == value) {

                } else if (current + 1 == value) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }

                current = value;
            }
            return max;
        }
    }
}
