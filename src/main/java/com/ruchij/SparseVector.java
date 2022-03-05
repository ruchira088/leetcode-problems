package com.ruchij;

import java.util.HashMap;
import java.util.Map;

public class SparseVector {
    Map<Integer, Integer> vector = new HashMap<>();

    SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];

            if (value != 0) {
                vector.put(i, value);
            }

        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;

        for (Map.Entry<Integer, Integer> entry : vec.vector.entrySet()) {
            Integer value = vector.getOrDefault(entry.getKey(), 0);
            result = result + (entry.getValue() * value);
        }

        return result;
    }
}
