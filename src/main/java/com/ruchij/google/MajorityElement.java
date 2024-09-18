package com.ruchij.google;

import java.util.HashMap;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int maxCount = 0;
        int number = 0;

        for (int num : nums) {
            int newCount = count.getOrDefault(num, 0) + 1;
            count.put(num, newCount);

            if (newCount > maxCount) {
                maxCount = newCount;
                number = num;
            }
        }

        return number;
    }
}
