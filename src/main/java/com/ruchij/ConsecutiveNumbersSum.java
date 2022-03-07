package com.ruchij;

import java.util.ArrayDeque;

public class ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int n) {
        int sum = 0;
        int count = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i <= (n + 1)/ 2; i++) {
            queue.add(i);
            
            sum += i;
            
            while (sum > n && !queue.isEmpty()) {
                Integer number = queue.pop();
                sum -= number;
            }

            if (sum == n) {
                count++;
            }
            
        }

        if (n != 1) {
            count++;
        }

        return count;
    }
}
