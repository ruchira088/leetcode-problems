package com.ruchij.google;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] xs, int[] ys) {
        int totalLength = xs.length + ys.length;
        int midPoint = totalLength / 2;

        int indexY = ys.length / 2;

        while (true) {
            int indexX = midPoint - indexY;

            int leftY = indexY == 0 ? Integer.MIN_VALUE : ys[indexY - 1];
            int rightY = indexY == ys.length ? Integer.MAX_VALUE : ys[indexY];

            int leftX = indexX == 0 ? Integer.MIN_VALUE : xs[indexX - 1];
            int rightX = indexX == xs.length ? Integer.MAX_VALUE : xs[indexX];

            if (leftY <= rightX && leftX <= rightY) {
                if (totalLength % 2 == 1) {
                    return Math.min(rightY, rightX);
                } else {
                    return  ((double) (Math.max(leftY, leftX) + Math.min(rightY, rightX))) / 2;
                }
            } else if (leftY > rightX) {
                indexY--;
            } else {
                indexY++;
            }
        }
    }
}
