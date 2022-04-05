package com.ruchij;

public class SumOfSubArrayMinimum {
    public int sumSubarrayMins(int[] arr) {
        int sum = 0;
        int mod = 1_000_000_000 + 7;

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];

            for (int j = i; j < arr.length; j++) {
                min = Math.min(arr[j], min);
                sum = (sum + min) % mod;
            }
        }

        return sum;
    }
}
