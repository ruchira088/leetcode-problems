package com.ruchij;

import java.util.*;

public class ThreeSumWithMultiplicity {
    public int threeSumMulti(int[] arr, int target) {
        Set<Map<Integer, Integer>> matches = new HashSet<>();
        Map<Integer, Integer> values = new HashMap<>();
        long count = 0;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int remainder = target - arr[i];
            int start = i + 1;
            int end = arr.length - 1;
            values.put(arr[i], values.getOrDefault(arr[i], 0) + 1);

            while (start < end) {
                int startValue = arr[start];
                int endValue = arr[end];
                int sum = startValue + endValue;
                if (sum > remainder) {
                    while (endValue == arr[end]) {
                        end--;
                    }
                } else {
                    if (sum == remainder) {
                        HashMap<Integer, Integer> map = new HashMap<>();

                        List.of(arr[i], startValue, endValue).forEach(number ->
                                map.put(number, map.getOrDefault(number, 0) + 1)
                        );

                        matches.add(map);
                    }

                    while (start < arr.length && startValue == arr[start]) {
                        start++;
                    }
                }
            }
        }

        values.put(arr[arr.length - 2], values.getOrDefault(arr[arr.length - 2], 0) + 1);
        values.put(arr[arr.length - 1], values.getOrDefault(arr[arr.length - 1], 0) + 1);

        for (Map<Integer, Integer> match : matches) {
            long results = 1;

            for (Map.Entry<Integer, Integer> entry : match.entrySet()) {
                results = results * combinations(values.get(entry.getKey()), entry.getValue());
            }

            count += results % (Math.pow(10, 9) + 7);
        }

        return (int) count;
    }

    long combinations(int n, int r) {
        long result = 1;

        for (int i = n - r + 1; i <= n; i++) {
            result = result * i;
        }

        return result / factorial(r);
    }

    int factorial(int value) {
        if (value == 0) {
            return 1;
        } else {
            return value * factorial(value - 1);
        }
    }
}
