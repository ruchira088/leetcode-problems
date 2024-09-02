package com.ruchij.google;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int diff = right - left;
            max = Math.max(max, diff * Math.min(height[left], height[right]));

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return max;
    }
}
