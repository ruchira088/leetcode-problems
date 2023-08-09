package com.ruchij;

import java.util.ArrayDeque;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int visited = 0;
        int maxIndex = nums.length - 1;

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            Integer index = queue.poll();

            if (index == maxIndex) {
                return true;
            }

            int steps = nums[index];

            if (maxIndex <= index + steps) {
                return true;
            }

            while (visited < index + steps) {
                visited++;
                queue.add(visited);
            }
        }

        return false;
    }
}
