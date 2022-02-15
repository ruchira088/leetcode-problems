package com.ruchij;

public class TrappingRainWater {
    public int trap(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int water = 0;
        int maxLeft = 0;
        int maxRight = 0;

        while (left < right) {
            if (heights[left] <= heights[right]) {
                if (heights[left] > maxLeft) {
                    maxLeft = heights[left];
                } else {
                    water += (maxLeft - heights[left]);
                }
                left++;
            } else {
                if (heights[right] > maxRight) {
                    maxRight = heights[right];
                } else {
                    water += (maxRight - heights[right]);
                }
                right--;
            }
        }

        return water;
    }

//    public int trap(int[] heights) {
//        int index = 0;
//        int water = 0;
//
//        while (index < heights.length - 1) {
//            int current = heights[index] + 1;
//
//            int next = -1;
//
//            while (next == -1) {
//                current--;
//                next = nextMatchingOrGreaterValueIndex(index, current, heights);
//            }
//
//            heights[index] = current;
//
//            water += trap(heights, index, next);
//            index = next;
//        }
//
//        return water;
//    }
//
//    private int nextMatchingOrGreaterValueIndex(int index, int current, int[] heights) {
//        for (int i = index + 1; i < heights.length; i++ ) {
//            if (heights[i] >= current) {
//                return i;
//            }
//        }
//
//        return -1;
//    }
//
//    private int trap(int[] heights, int startIndex, int end) {
//        if (startIndex == end) {
//            return 0;
//        } else {
//            int highest = heights[startIndex];
//            int water = 0;
//
//            for (int i = startIndex; i < end; i++) {
//                water += (highest - heights[i]);
//            }
//
//            return water;
//        }
//    }
}
