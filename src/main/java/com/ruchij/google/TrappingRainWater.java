package com.ruchij.google;

public class TrappingRainWater {
    public int trap(int[] heights) {
        return trapThree(heights);
    }

    private int trapOne(int[] heights) {
        int water = 0;

        for (int i = 0; i < heights.length; i++) {
            int leftMax = 0;
            int rightMax = 0;

            for (int left = 0; left < i; left++) {
                leftMax = Math.max(leftMax, heights[left]);
            }

            for (int right = i + 1; right < heights.length; right++) {
                rightMax = Math.max(rightMax, heights[right]);
            }

            int waterLevel = Math.min(leftMax, rightMax);

            int diff = waterLevel - heights[i];

            if (diff > 0) {
                water += diff;
            }
        }

        return water;
    }

    private int trapTwo(int[] heights) {
        int water = 0;
        int[] leftMaxes = new int[heights.length];
        int[] rightMaxes = new int[heights.length];

        int leftMaxValue = 0;

        for (int i = 0; i < heights.length; i++) {
            leftMaxValue = Math.max(leftMaxValue, heights[i]);
            leftMaxes[i] = leftMaxValue;
        }

        int rightMaxValue = 0;

        for (int i = heights.length - 1; i >= 0; i--) {
            rightMaxValue = Math.max(rightMaxValue, heights[i]);
            rightMaxes[i] = rightMaxValue;
        }


        for (int i = 0; i < heights.length; i++) {
            int waterLevel = Math.min(i == 0 ? 0 : leftMaxes[i - 1], i == heights.length - 1 ? 0 : rightMaxes[i + 1]);

            int diff = waterLevel - heights[i];

            if (diff > 0) {
                water += diff;
            }
        }

        return water;
    }

    private int trapThree(int[] heights) {
        int water = 0;
        int left = 0;
        int leftMax = 0;
        int right = heights.length - 1;
        int rightMax = 0;

        while (left <= right) {
            if (leftMax <= rightMax) {
                int diff = leftMax - heights[left];
                if (diff > 0) {
                    water += diff;
                }

                leftMax = Math.max(leftMax, heights[left]);
                left++;
            } else {
                int diff = rightMax - heights[right];
                if (diff > 0) {
                    water += diff;
                }
                rightMax = Math.max(rightMax, heights[right]);
                right--;
            }
        }

        return water;
    }
}
